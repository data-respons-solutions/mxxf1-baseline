# Copyright (C) 2014 Data Respons AS

DESCRIPTION = "Target packages for DR Qt5 SDK"
LICENSE = "MIT"

inherit packagegroup



RDEPENDS:${PN} += " \
    lmsensors-libsensors-dev \
    protobuf-dev \
    util-linux-dev \
    alsa-lib-dev \
    kernel-dev \
    sysfsutils-dev \
    libpciaccess-dev \
    util-macros-dev \
    rpm-dev \
    rpm-build \
    parted-dev \
"
