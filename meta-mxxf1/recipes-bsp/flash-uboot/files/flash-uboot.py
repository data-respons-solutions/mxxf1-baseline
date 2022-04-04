#!/usr/bin/env python3

import sys, errno, os, subprocess, hashlib, gpiod

mtd_file = "/dev/mtd0"
mtd0_size=0;
mtd_size = []
mtd_names = []

def get_mtd_hash(offset, length):
  with open(mtd_file, "rb") as f:
    f.seek(offset)
    bytes_read = f.read(length);
    h = hashlib.md5()
    h.update(bytes_read);
    return h.hexdigest()


def get_partitioning():

  with open("/proc/mtd", "r") as mtd:
    slist = mtd.read().splitlines()
    slist.pop(0)
    print("Found", len(slist), "Partitions")
    n=0;
    for s in slist:
      msize = "0x" + s.split(' ')[1]
      mtd_size.append(msize)
      name = s.split(' ')[3]
      name = name[1:-1]
      mtd_names.append(name)
      print(str.format("/dev/mtd{0}: {1} [{2}]", n, name, msize))
      n = n+1

def check_same(spl, ub):

  print("\nCheck if update is needed")
  same = 1;
  stat_spl = os.stat(spl)
  with open(spl, "rb") as fspl:
    spl_bytes = fspl.read(stat_spl.st_size)

  stat_uboot = os.stat(ub)
  with open(ub, "rb") as fub:
    ub_bytes = fub.read(stat_uboot.st_size)

  splhash = hashlib.md5()
  splhash.update(spl_bytes)
  mtd_spl_digest = get_mtd_hash(1024, stat_spl.st_size);
  #print "Digest of mtd spl is", mtd_spl_digest
  if (mtd_spl_digest != splhash.hexdigest() ):
    print(spl.ljust(20),splhash.hexdigest())
    print("flash SPL:".ljust(20), mtd_spl_digest)
    same = 0

  mtd_ub_digest = get_mtd_hash(1024*256, stat_uboot.st_size)
  ubhash = hashlib.md5()
  ubhash.update(ub_bytes)
  if (mtd_ub_digest != ubhash.hexdigest()):
    print(ub.ljust(20),ubhash.hexdigest())
    print("flash u-boot".ljust(20), mtd_ub_digest)
    same = 0

  return same;

def erase_flash():
  try:
    print(str.format("Erase mtd0 [{0}: {1}]", mtd_names[0], mtd_size[0]))
    subprocess.check_call(["/usr/sbin/mtd_debug", "erase", "/dev/mtd0", "0", mtd_size[0]])
    print(mtd_names[0], "Erased")

    if (len(mtd_names) > 1 and mtd_names[1] == "u-boot-env"):
      print(str.format("Erase mtd1 [{0}: {1}]", mtd_names[1], mtd_size[1]))
      subprocess.check_call(["/usr/sbin/mtd_debug", "erase", "/dev/mtd1", "0", mtd_size[1]])
      print(mtd_names[1], "Erased")

  except subprocess.CalledProcessError as e:
    print("Exception in erase_flash command:",os.strerror(e.returncode))
    raise OSError('mtd failed erase')

# Write the flash
def write_flash(offset, file_name):
  fstat = os.stat(file_name)
  with open(file_name, "rb") as f:
    file_bytes = f.read(fstat.st_size);

  with open(mtd_file, "wb") as mtd:
    mtd.seek(offset)
    mtd.write(file_bytes)

  return 0


# Program starts here
result = 0

line = gpiod.find_line("spiflash-wp")
if (line == None):
  print("No GPIO named spiflash-wp")
  sys.exit(1)

if len(sys.argv) < 3:
  print ("usage: flash <spl> <image>")
  sys.exit(1)

try:
  get_partitioning()

  # Check need for update
  t = check_same(sys.argv[1], sys.argv[2])
  if (t==0):
    print("NEED TO FLASH")
    line.request(sys.argv[0])
    line.set_direction_output()
    line.set_value(1)
    print("Enabled flash for write")
    erase_flash()
    write_flash(0x400, sys.argv[1])
    write_flash(0x40000, sys.argv[2])
    if (check_same(sys.argv[1], sys.argv[2])):
      print("Flash updated")
    else:
      result = 1
      print("FAILURE")
  else:
    print("Flash is up to date, no programming")
except IOError as e:
  print("IO Error", os.strerror(e.errno))
  result = e.errno
except OSError as e:
  print("OS Error", os.strerror(e.errno))
  result = e.errno

finally:
  if (line.is_requested()):
    line.set_value(0)
    line.release()

sys.exit(result)
