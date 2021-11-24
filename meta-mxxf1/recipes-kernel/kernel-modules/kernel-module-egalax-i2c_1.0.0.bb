# Copyright 2020-2021 NXP

DESCRIPTION = "Kernel loadable module for Egalax I2C touch conrtoller"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

inherit module

SRCREV ?= "b476a80f1a238bf9dece64e829cc457223e77e6e"
SRC_URI = "git://git@github.com/data-respons-solutions/kernel-module-egalax-i2c.git;protocol=ssh;branch=master"

S = "${WORKDIR}/git"
