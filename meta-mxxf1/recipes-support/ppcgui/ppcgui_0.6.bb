DESCRIPTION = "Manufacturer test for RRM10"
SECTION = "base"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV ?= "da9f2abbd88c629af76d6ef3901e31202be540b9"
BRANCH ?= "master"
SRC_URI = "git://git@github.com/data-respons-solutions/mxxf1-oem-sw.git;protocol=ssh;branch=${BRANCH}"
S = "${WORKDIR}/git/PpcGui"

require recipes-qt/qt5/qt5.inc

DEPENDS = "qtdeclarative"
RDEPENDS:${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"

do_configure() {
	${OE_QMAKE_QMAKE} ${S}/rr.pro
}

do_install() {
	oe_runmake INSTALL_ROOT=${D} install
}

FILES:${PN} = "\
	/opt/rr/bin/rr \
	/opt/rr/qml* \
	"

FILES:${PN}-dbg = "\
	/opt/rr/bin/.debug \
	"
FILES:${PN}-dev = "\
	/usr/src/debug \
	"
	
PACKAGE_ARCH = "${MACHINE_ARCH}"
