# Copyright (C) 2014 DATA RESPONS AS.

SUMMARY = "DR Extra Collection"
LICENSE = "MIT"


inherit packagegroup

PACKAGE_ARCH = "${TUNE_PKGARCH}"

RDEPENDS:${PN} = " \
    dosfstools \
    rsync \
    avahi-daemon \
    avahi-utils \
    ldd \
    lsof \
    cpufrequtils \
    protobuf \
    localedef \
    gstreamer1.0 \
    sysfsutils \
    mtd-utils \
    parted \
    fontconfig \
    fontconfig-utils \
    liberation-fonts \
    ttf-bitstream-vera \
    builtin-users \
"
