DESCRIPTION = "startup for production test rrm10"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r1"

SRC_URI = " \
	file://ppctest.service \
	file://ppcgui.service \
"

S = "${WORKDIR}"

RDEPENDS_${PN} = "ppctest ppcgui eeprom-gen eeprom-gen-generate qt5-eglfs-mxxf1"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/ppctest.service ${D}${systemd_unitdir}/system/
	install -m 0644 ${WORKDIR}/ppcgui.service ${D}${systemd_unitdir}/system/
}

inherit allarch  systemd


PACKAGE_ARCH = "${MACHINE_ARCH}"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "ppctest.service ppcgui.service"
