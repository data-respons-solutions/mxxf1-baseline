DESCRIPTION = "FUSE the MAC address from VPD if needed"
SECTION = "base"
DEPENDS = "libpciaccess util-linux"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit  python3native python3-dir

SRC_URI = "file://fuse_eth_from_eeprom.py"

S = "${WORKDIR}"

PR = "r0"

RDEPENDS_${PN} = "python3 eeprom-gen"

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/fuse_eth_from_eeprom.py ${D}${sbindir}
}


FILES_${PN} = "${sbindir}/fuse_eth_from_eeprom.py"

PACKAGE_ARCH = "${MACHINE_ARCH}"
