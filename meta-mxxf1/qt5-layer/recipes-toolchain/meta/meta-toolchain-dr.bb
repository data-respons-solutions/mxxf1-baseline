SUMMARY = "Meta package for building an installable Qt5 toolchain and SDK"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit populate_sdk populate_sdk_qt5

TOOLCHAIN_TARGET_TASK += "packagegroup-dr"
TOOLCHAIN_HOST_TASK += "nativesdk-packagegroup-dr-host"
