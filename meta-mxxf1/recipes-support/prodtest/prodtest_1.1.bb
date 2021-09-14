DESCRIPTION = "startup for production test rrm10"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://ppctest.service \
	file://ppcgui.service \
"

S = "${WORKDIR}"

RDEPENDS_${PN} = "ppctest ppctest-tools ppcgui eeprom-gen eeprom-gen-generate qt5-eglfs-mxxf1"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/ppctest.service ${D}${systemd_unitdir}/system/
	install -m 0644 ${WORKDIR}/ppcgui.service ${D}${systemd_unitdir}/system/
}

inherit allarch  systemd


PACKAGE_ARCH = "${MACHINE_ARCH}"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "ppctest.service ppcgui.service"
