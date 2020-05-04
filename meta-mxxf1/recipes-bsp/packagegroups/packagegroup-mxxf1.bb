# Copyright (C) 2014 DATA RESPONS AS.

SUMMARY = "RRM10 Collection"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
    eeprom-gen \
    libsysfs \
    button-daemon \
    lmsensors-sensord \
    usbutils \
    canutils \
    fuse-eth \
    mxxf1-buzzer \
    bzip2 \
    glibc-localedata-i18n \
    glibc-localedata-posix \
    localedef \
    iperf3 \
"
pkg_postinst_ontarget_${PN} () {
#!/bin/sh
if [ "x$D" != "x" ]; then
    exit 1
fi
/usr/sbin/fuse_eth_from_eeprom.py
}


