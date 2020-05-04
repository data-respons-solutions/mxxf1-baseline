#!/usr/bin/env python3

# Program start

import subprocess, sys
from subprocess import CalledProcessError

try:
  ident = subprocess.check_output(["/usr/bin/vpdget", "PRODUCT_SERIAL"], universal_newlines=True)
except CalledProcessError as e:
  print("Unable to get PRODUCT_SERIAL from nvram")
  exit(1)
  
istr = str(ident).lower().rstrip()

if (len(sys.argv) > 1):
  prefix = sys.argv[1]
else:
  prefix = "mxxf1-"
  

#print ident
hname = prefix + istr
print(str.format("Setting hostname to: {0}", hname))

try:
  subprocess.check_call(["/usr/bin/hostnamectl", "set-hostname", hname])
  subprocess.check_call(["/usr/bin/avahi-set-host-name", hname])
except CalledProcessError as e:
  print(str.format("Error setting hostname to {0}", hname))
  exit(1)

exit(0)
