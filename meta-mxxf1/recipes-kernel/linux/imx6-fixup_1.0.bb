SUMMARY = "Kernel fixes"

AUTHOR = "Hans Christian Lonstad <hcl@datarespons.no>"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://imx6.conf \
"


do_install() {
	install -d ${D}${sysconfdir}/modprobe.d
	install -m 0644 ${WORKDIR}/imx6.conf ${D}${sysconfdir}/modprobe.d/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
