DESCRIPTION = "Memory tester"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r1"

SRC_URI = " \
	file://memtest.service \
"

S = "${WORKDIR}"

RDEPENDS_${PN} = "memtester"

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/memtest.service ${D}${systemd_unitdir}/system/
}

inherit allarch  systemd

PACKAGE_ARCH = "${MACHINE_ARCH}"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "memtest.service"
