DESCRIPTION = "Button backlight control for RRM10"
SECTION = "base"
HOMEPAGE = "https://datarespons.com/solutions"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV ?= "0e65d9837020d0e1542fc4cd41b7cffc6657285a"
SRC_URI = "git://git@github.com/data-respons-solutions/mxxf1-oem-sw.git;protocol=ssh;branch=master"

SRC_URI += " \
    file://button-daemon.service \
    file://button-daemon.conf \
"

S = "${WORKDIR}/git/ButtonsDeamon"

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
