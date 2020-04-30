DESCRIPTION = "Button backlight control for RRM10"
SECTION = "base"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV ?= "cc6cbf8838a99a7013072450330170d0a7684da7"
SRC_URI = "${DR_GIT_MIRROR}/oem-rrm10.git;protocol=ssh;branch=master"

SRC_URI += " \
    file://button-daemon.service \
    file://button-daemon.conf \
"

S = "${WORKDIR}/git/ButtonsDeamon"

PR = "r0"
PV = "0.1"

inherit systemd

#DEPENDS += "lmsensors"

EXTRA_OEMAKE = "'CXX=${CXX}' 'RANLIB=${RANLIB}' 'AR=${AR}' \
'CXXFLAGS=${CXXFLAGS} -I${S}/include -DWITHOUT_XATTR' 'BUILDDIR=${S}'"


do_install () {
	oe_runmake install PREFIX=${D}/usr
	install -d ${D}${systemd_unitdir}/system
	install -d ${D}${sysconfdir}/default
	install -m 0644 ${WORKDIR}/button-daemon.service ${D}${systemd_unitdir}/system/
	install -m 0644 ${WORKDIR}/button-daemon.conf   ${D}${sysconfdir}/default/button-daemon
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "button-daemon.service"

PACKAGE_ARCH = "${MACHINE_ARCH}"