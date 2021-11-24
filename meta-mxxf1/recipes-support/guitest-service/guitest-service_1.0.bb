DESCRIPTION = "Memory tester"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r1"

SRC_URI = " \
	file://guitest.service \
"

S = "${WORKDIR}"

RDEPENDS:${PN} = "cinematicexperience"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/guitest.service ${D}${systemd_unitdir}/system/
}

inherit allarch  systemd

PACKAGE_ARCH = "${MACHINE_ARCH}"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "guitest.service"
