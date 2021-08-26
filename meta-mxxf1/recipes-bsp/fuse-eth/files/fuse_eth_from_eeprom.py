#!/usr/bin/env python3

import subprocess, string, os

allchars = "".join(chr(a) for a in range(256))
delchars = set(allchars) - set(string.hexdigits)

fuse_path = '/sys/fsl_otp'
#fuse_path = '/home/root'

def checkMAC(s):
  mac = s.translate("".join(allchars),"".join(delchars))
  if len(mac) != 12:
      raise ValueError("Ethernet MACs are always 12 hex characters, you entered %s" % mac)
  return mac.upper()
  
# Program start

try:
  vpd_mac = subprocess.check_output(['/usr/bin/vpdget', 'FEC_MAC_ADDR'], text=True)
  vpd_mac = str.strip(vpd_mac, '\n')
  checkMAC(vpd_mac)
  print("FEC_MAC_ADDR", vpd_mac, "is valid")
  s = vpd_mac.split(':')
  if (len(s) < 6):
    print("Could not split mac in 6 digits")
    exit(1)
  eth0 = "0x" + s[2] + s[3] + s[4] + s[5] + "\n"
  eth1 = "0x" + s[0] + s[1] + "\n"
    
except subprocess.CalledProcessError as e:
  print("vpdget failed - exit")
  exit(1)
except ValueError as v:
  print("FEC_MAC_ADDR", vpd_mac, "is not valid")
  exit(1)

with open(os.path.join(fuse_path, 'HW_OCOTP_MAC0'), 'r') as f:
  mac0 = f.read()

with open(os.path.join(fuse_path, 'HW_OCOTP_MAC1'), 'r') as f:
  mac1 = f.read()

if (int(mac0, base=16) == 0 and int(mac1, base=16) == 0):
  print("Not fused, set to", str.strip(eth1, '\n'), str.strip(eth0, '\n'))
  with open(os.path.join(fuse_path, 'HW_OCOTP_MAC0'), 'w') as f:
    f.write(eth0)

  with open(os.path.join(fuse_path, 'HW_OCOTP_MAC1'), 'w') as f:
    f.write(eth1)
    
else:
  print("Unit is already fused", str.strip(mac1, '\n'), str.strip(mac0, '\n'))

exit (0)
