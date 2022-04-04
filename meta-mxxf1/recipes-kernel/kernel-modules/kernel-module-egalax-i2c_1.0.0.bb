# Copyright 2020-2021 NXP

DESCRIPTION = "Kernel loadable module for Egalax I2C touch conrtoller"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

inherit module

SRCREV ?= "6cd840668292e452e4b24ca505e196139ce5e650"
SRC_URI = "git://git@github.com/data-respons-solutions/kernel-module-egalax-i2c.git;protocol=ssh;branch=master"

S = "${WORKDIR}/git"
