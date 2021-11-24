# Copyright (C) DATA RESPONS
# Released unFILESEXTRAPATHS:prepend := "${THISDIR}/${PN}_${PV}:"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://defconfig \
	file://0001-mx6q-Add-GPIO-and-WD-parser.patch \
	file://0002-Add-misc-devices.patch \
	file://0003-Add-mxxf1-DT-files.patch \
	file://0004-mxxf1-Split-out-versions.patch \
"
DR_PATCH_VERSION = "1.1"
LINUX_VERSION_EXTENSION = "-dr-pl-${DR_PATCH_VERSION}"
#PV = "${LINUX_VERSION}-dr-${DR_PATCH_VERSION}"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"