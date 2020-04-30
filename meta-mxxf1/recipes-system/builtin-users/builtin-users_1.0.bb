SUMMARY = "DR Users"
DESCRIPTION = "Generate builtin users"
SECTION = "base"
PR = "r1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://authorized_keys"

S = "${WORKDIR}"

inherit useradd


USERADD_PACKAGES = "${PN}"

USERADD_PARAM_${PN} += "--create-home --shell /bin/bash --groups sudo,tty,video,audio,input --system dr"

do_install () {
    install -d -m 700 ${D}/home/dr/.ssh
    install -p -m 600  authorized_keys ${D}/home/dr/.ssh
    
    chown -R dr ${D}/home/dr
    chgrp -R dr ${D}/home/dr
}

FILES_${PN} = "/home/dr/.ssh/authorized_keys"
# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
# ALLOW_EMPTY_${PN} = "1"
