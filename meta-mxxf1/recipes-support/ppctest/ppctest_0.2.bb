DESCRIPTION = "Manufacturer test for RRM10"
SECTION = "base"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV ?= "5869ea6e20c3b5967d05b1e036685dfc1cbf8e87"
SRC_URI = "git://git@github.com/data-respons-solutions/mxxf1-oem-sw.git;protocol=ssh;branch=master"

S = "${WORKDIR}/git/PpcTest"

require recipes-qt/qt5/qt5.inc

DEPENDS += "lmsensors qtbase"

do_configure() {
	${OE_QMAKE_QMAKE} ${S}/PpcTest.pro
}

do_install () {
	oe_runmake INSTALL_ROOT=${D} install
	install -d ${D}/opt
	install -m 0644 ${S}/bltable.cal ${D}/opt
}

FILES_${PN}_append = " /opt"
PACKAGE_ARCH = "${MACHINE_ARCH}"
