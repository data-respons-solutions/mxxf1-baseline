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
    mxxf1-buzzer \
    bzip2 \
    glibc-localedata-i18n \
    glibc-localedata-posix \
    localedef \
    iperf3 \
"


