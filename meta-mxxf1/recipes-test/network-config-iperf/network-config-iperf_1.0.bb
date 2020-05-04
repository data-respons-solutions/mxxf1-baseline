DESCRIPTION = "Basic Network setup"
SECTION = "base"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"
SRC_URI = " \
	file://80-eth0.network \
	file://81-eth1.network \
	file://iperftest.service \
"

S = "${WORKDIR}"

inherit systemd

RDEPENDS_${PN} = "iperf3"

do_install() {
	install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/80-eth0.network ${D}${sysconfdir}/systemd/network/
    install -m 0644 ${WORKDIR}/81-eth1.network ${D}${sysconfdir}/systemd/network/
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/iperftest.service ${D}${systemd_unitdir}/system/
}
SYSTEMD_PACKAGES = "${PN}"
PACKAGE_ARCH = "${MACHINE_ARCH}"
SYSTEMD_SERVICE_${PN} = "iperftest.service"
