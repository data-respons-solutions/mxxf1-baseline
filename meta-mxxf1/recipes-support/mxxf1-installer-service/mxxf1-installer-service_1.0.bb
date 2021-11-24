DESCRIPTION = "Start the Installer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r1"

SRC_URI = " \
	file://mxxf1-installer.service \
"

S = "${WORKDIR}"

RDEPENDS:${PN} = "mxxf1-installer qt5-eglfs-mxxf1"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/mxxf1-installer.service ${D}${systemd_unitdir}/system/
}

inherit allarch systemd


PACKAGE_ARCH = "${MACHINE_ARCH}"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "mxxf1-installer.service"
