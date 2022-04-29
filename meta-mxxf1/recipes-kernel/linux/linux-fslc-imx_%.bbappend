# Copyright (C) DATA RESPONS
# Released unFILESEXTRAPATHS:prepend := "${THISDIR}/${PN}_${PV}:"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:dr-imx6-mc = " \
	file://defconfig \
	file://0001-mx6q-Add-GPIO-and-WD-parser.patch \
	file://0002-Add-misc-devices.patch \
	file://0003-Add-mxxf1-DT-files.patch \
	file://0004-Add-PWM-Buzzer.patch \
"
DR_PATCH_VERSION = "1.7"
LINUX_VERSION_EXTENSION = "-dr-pl-${DR_PATCH_VERSION}"
