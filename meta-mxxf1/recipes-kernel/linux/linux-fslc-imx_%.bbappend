# Copyright (C) DATA RESPONS
# Released unFILESEXTRAPATHS:prepend := "${THISDIR}/${PN}_${PV}:"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS += "lzop-native"

SRC_URI:append:dr-imx6-mc = " \
	file://defconfig \
	file://0001-Add-pwm-and-function-mux.patch \
	file://0002-Add-mxxf1-DT-boards.patch \
	file://0003-soc-imx-Add-boot-config-info.patch \
"
DR_PATCH_VERSION = "2.1"
LINUX_VERSION_EXTENSION = "-dr-pl-${DR_PATCH_VERSION}"
