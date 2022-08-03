DESCRIPTION = "VPD EEPROM support for DATARESPONS boards"
SECTION = "base"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV ?= "${DR_OEMSW_SHA}"
SRC_URI = "git://git@github.com/data-respons-solutions/mxxf1-oem-sw.git;protocol=ssh;branch=master"

S = "${WORKDIR}/git/eeprom"

PACKAGES =+ "${PN}-generate"

DEPENDS += "libgpiod libpciaccess util-linux"
RDEPENDS:${PN} = "libgpiod-python"

EXTRA_OEMAKE = "'CXX=${CXX}' 'RANLIB=${RANLIB}' 'AR=${AR}' \
'CXXFLAGS=${CXXFLAGS} -I${S}/include -DWITHOUT_XATTR' 'BUILDDIR=${S}'"

do_install () {
	oe_runmake install PREFIX=${D}/usr
}

FILES:${PN} = "${bindir}/vpdget"
FILES:${PN}-generate = "${bindir}/vpdgenerate"

PACKAGE_ARCH = "${MACHINE_ARCH}"
