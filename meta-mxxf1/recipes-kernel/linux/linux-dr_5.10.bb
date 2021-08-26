# Copyright (C) 2021 Data Respons Solutions
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by NXP"
DESCRIPTION = "Linux Kernel provided and supported by NXP with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"




require recipes-kernel/linux/linux-dr.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "lf-5.10.y"
LOCALVERSION = "-lts-5.10.y"
KERNEL_SRC ?= "git://source.codeaurora.org/external/imx/linux-imx.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"

SRC_URI_append = " \
	file://kernelconf \
    file://0001-mach-imx6q-Add-check-for-running-watchdog.-Add-DT-GP.patch \
    file://0002-Add-mxxf1-DT-files.patch \
"

SRCREV = "ef3f2cfc6010c13feb40cfb7fd7490832cf86f45"

LINUX_VERSION = "5.10.35"
PL = "0.1"
KBUILD_DEFCONFIG = "kernelconf"

FILES_${KERNEL_PACKAGE_NAME}-base += "${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.builtin.modinfo "

#KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

DEFAULT_PREFERENCE = "1"
LINUX_VERSION_EXTENSION = "-mxxf1-pl-${PL}"

do_configure_prepend () {
    install -d ${B}
    mkdir -p ${B}
    cp ${WORKDIR}/${KBUILD_DEFCONFIG} ${B}/.config
    echo "CONFIG_LOCALVERSION="\"${LINUX_VERSION_EXTENSION}\" >> ${B}/.config
}

#KERNEL_VERSION_SANITY_SKIP="1"
COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
