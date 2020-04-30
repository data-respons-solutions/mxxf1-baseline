SUMMARY = "Burn uboot to MMC"

AUTHOR = "Hans Christian Lonstad <hcl@datarespons.no>"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RDEPENDS_${PN} = "mtd-utils"

SRC_URI += "file://mmc-uboot.sh"


do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/mmc-uboot.sh ${D}${bindir}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
