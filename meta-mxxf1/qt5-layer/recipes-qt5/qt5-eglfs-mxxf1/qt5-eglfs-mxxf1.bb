SUMMARY = "Setup the screen size for Qt5 EGLFS"

AUTHOR = "Hans Christian Lonstad <hcl@datarespons.no>"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://qt5-eglfs-env.sh \
    file://qt5env \
    file://mxxf1.json \
    "


do_install() {
	install -d ${D}${sysconfdir}/profile.d/
	install -m 0755 ${WORKDIR}/qt5-eglfs-env.sh ${D}${sysconfdir}/profile.d/
	install -d ${D}${sysconfdir}/default/
    install -m 0755 ${WORKDIR}/qt5env ${D}${sysconfdir}/default
    install -m 0755 ${WORKDIR}/mxxf1.json ${D}${sysconfdir}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
