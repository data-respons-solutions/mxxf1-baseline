# Copyright (C) DATA RESPONS
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
BRANCH = "lm-5.4.y"

SRC_URI = " \
	${DR_BITBUCKET_MIRROR_IMX}kernel-upstream.git;protocol=ssh;branch=${BRANCH} \
"
require recipes-kernel/linux/linux-dr.inc

DEPENDS += "lzop-native bc-native"
PROVIDES = "virtual/kernel"

COMPATIBLE_MACHINE = "(mxs|mx5|mx6|vf|use-mainline-bsp)"

SRCREV ?= "2de05e600370bfb676c65b747e6ae4bc1e3d0db6"
LOCALVERSION = "-${BRANCH}"
