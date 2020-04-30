DESCRIPTION = "Utility to flash boot loader in eMMC for Simpad/Linkbox plus boards"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit  python3native python3-dir
SRC_URI = 	" \
    file://mxxf1_hostname.py \
    file://mxxf1-hostname.service \
"
PR = "r0"

inherit systemd


S = "${WORKDIR}"
RDEPENDS_${PN} = "python3 eeprom-gen avahi-daemon"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/mxxf1_hostname.py ${D}${bindir}/mxxf1-hostname
    install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/mxxf1-hostname.service ${D}${systemd_unitdir}/system/mxxf1-hostname.service
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "${bindir}/*"


SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "mxxf1-hostname.service"
