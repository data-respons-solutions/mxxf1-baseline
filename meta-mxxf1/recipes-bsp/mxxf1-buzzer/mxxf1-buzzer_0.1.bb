DESCRIPTION = "Wrapper for sysfs controlled buzzer"
SECTION = "base"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = "file://buzzer"

S = "${WORKDIR}"

PR = "r0"


do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/buzzer ${D}${bindir}
}


FILES_${PN} = "${bindir}/buzzer"

PACKAGE_ARCH = "${MACHINE_ARCH}"
