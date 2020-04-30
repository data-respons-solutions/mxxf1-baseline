#!/usr/bin/env python3

import sys, errno, os, subprocess, hashlib

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

def enable_write():
  stdout = open("/sys/class/gpio/gpio171/value", "w")
  subprocess.call(["/bin/echo", "0"], stdout=stdout)

def disable_write():
  stdout = open("/sys/class/gpio/gpio171/value", "w")
  subprocess.call(["/bin/echo", "1"], stdout=stdout)

def erase_flash():
  try:
    if (len(mtd_names) > 1 and mtd_names[1] == "u-boot-env"):
      print(str.format("Erase mtd1 [{0}: {1}]", mtd_names[1], mtd_size[1]))
      print(subprocess.check_output(["/usr/sbin/mtd_debug", "erase", "/dev/mtd1", "0", mtd_size[1]]))
      print(mtd_names[1], "Erased")
      
    else:
      print(str.format("Erase mtd0 [{0}: (u-boot env)]", mtd_names[0]))
      print(subprocess.check_output(["/usr/sbin/mtd_debug", "erase", "/dev/mtd0", "0xC0000", "0x40000"]))
      print(mtd_names[0], "Erased env part")
  
      
  except subprocess.CalledProcessError as e:
    print("Exception in erase_flash:",os.strerror(e.returncode))
    raise e
  

# Program starts here
result = 0
try:
  get_partitioning()
  print("ERASE u-boot env")
  enable_write()
  erase_flash()
    
except IOError as e:
  print("IO Error", os.strerror(e.errno))
  result = e.errno
except OSError as e:
  print("OS Error", os.strerror(e.errno))
  result = e.errno

finally:
  disable_write()

sys.exit(result)
