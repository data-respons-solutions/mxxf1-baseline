# Copyright (C) 2014 DATA RESPONS AS.

SUMMARY = "RRM10 Collection"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
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
    udisks2 \
    pciutils \
    i2c-tools \
    phytool \
    libgpiod-tools \
    evtest \
"


