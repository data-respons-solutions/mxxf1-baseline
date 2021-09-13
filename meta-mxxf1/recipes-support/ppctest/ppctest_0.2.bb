DESCRIPTION = "Manufacturer test for RRM10"
SECTION = "base"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV ?= "85c7b44fe3a85fad680618a9f7ad2fe144f24e31"
SRC_URI = "git://git@github.com/data-respons-solutions/mxxf1-oem-sw.git;protocol=ssh;branch=master"

S = "${WORKDIR}/git/PpcTest"

require recipes-qt/qt5/qt5.inc

DEPENDS += "lmsensors qtbase"

do_configure() {
	${OE_QMAKE_QMAKE} ${S}/PpcTest.pro
}

do_install () {
	oe_runmake INSTALL_ROOT=${D} install
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
