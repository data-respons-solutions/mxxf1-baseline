DESCRIPTION = "Manufacturer test for RRM10"
SECTION = "base"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV ?= "0e65d9837020d0e1542fc4cd41b7cffc6657285a"
BRANCH ?= "master"
SRC_URI = "git://git@github.com/data-respons-solutions/mxxf1-oem-sw.git;protocol=ssh;branch=${BRANCH}"
S = "${WORKDIR}/git/PpcGui"

require recipes-qt/qt5/qt5.inc

DEPENDS = "qtdeclarative"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"

do_configure() {
	${OE_QMAKE_QMAKE} ${S}/rr.pro
}

do_install() {
	oe_runmake INSTALL_ROOT=${D} install
}

FILES_${PN} = "\
	/opt/rr/bin/rr \
	/opt/rr/qml* \
	"

FILES_${PN}-dbg = "\
	/opt/rr/bin/.debug \
	"
FILES_${PN}-dev = "\
	/usr/src/debug \
	"
	
PACKAGE_ARCH = "${MACHINE_ARCH}"
