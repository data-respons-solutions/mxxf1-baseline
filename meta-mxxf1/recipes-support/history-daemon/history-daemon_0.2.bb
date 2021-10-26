DESCRIPTION = "Logger Service for MXXF1"
SECTION = "base"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

SRCREV ?= "0e65d9837020d0e1542fc4cd41b7cffc6657285a"
SRC_URI = "git://github.com/data-respons-solutions/mxxf1-oem-sw.git;protocol=ssh;branch=master"

SRC_URI += "file://history-daemon.service"

S = "${WORKDIR}/git/HistoryDeamon"


inherit systemd

require recipes-qt/qt5/qt5.inc

DEPENDS += "lmsensors qtbase"

do_configure() {
    ${OE_QMAKE_QMAKE} ${S}/HistoryDaemon.pro
}

do_install () {
	oe_runmake INSTALL_ROOT=${D} install
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/history-daemon.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} = "\
    /usr/bin/* \
"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "history-daemon.service"

PACKAGE_ARCH = "${MACHINE_ARCH}"
