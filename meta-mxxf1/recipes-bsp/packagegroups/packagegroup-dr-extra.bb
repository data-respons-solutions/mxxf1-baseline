# Copyright (C) 2014 DATA RESPONS AS.

SUMMARY = "DR Extra Collection"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
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
    dhcp-client \
    fontconfig \
    fontconfig-utils \
    liberation-fonts \
    ttf-bitstream-vera \
    builtin-users \
"
