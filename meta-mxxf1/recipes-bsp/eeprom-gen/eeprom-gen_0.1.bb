DESCRIPTION = "VPD EEPROM support for DATARESPONS boards"
SECTION = "base"
DEPENDS = "libpciaccess util-linux"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV ?= "${AUTOREV}"
SRC_URI = "${DR_GIT_MIRROR}/oem-rrm10.git;protocol=ssh;branch=master"

S = "${WORKDIR}/git/eeprom"

PR = "r0"
PV = "1.0.0+git${SRCPV}"

EXTRA_OEMAKE = "'CXX=${CXX}' 'RANLIB=${RANLIB}' 'AR=${AR}' \
'CXXFLAGS=${CXXFLAGS} -I${S}/include -DWITHOUT_XATTR' 'BUILDDIR=${S}'"


do_install () {
	oe_runmake install PREFIX=${D}/usr
}


PACKAGES =+ "${PN}-generate"

FILES_${PN} = "${bindir}/vpdget"
FILES_${PN}-generate = "${bindir}/vpdgenerate"


PACKAGE_ARCH = "${MACHINE_ARCH}"
