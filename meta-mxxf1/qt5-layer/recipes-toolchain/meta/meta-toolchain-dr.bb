SUMMARY = "Meta package for building an installable Qt5 toolchain and SDK"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit populate_sdk populate_sdk_qt5

TOOLCHAIN_TARGET_TASK += "packagegroup-dr"
TOOLCHAIN_HOST_TASK += "nativesdk-packagegroup-dr-host"
