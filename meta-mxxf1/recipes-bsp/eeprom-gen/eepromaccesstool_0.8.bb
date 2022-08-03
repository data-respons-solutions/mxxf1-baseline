DESCRIPTION = "I210 EEPROM support for DATARESPONS boards"
SECTION = "base"
HOMEPAGE = "http://www.datarespons.no"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV ?= "${DR_OEMSW_SHA}"
BRANCH ?= "master"
SRC_URI = "git://git@github.com/data-respons-solutions/mxxf1-oem-sw.git;protocol=ssh;branch=${BRANCH}"

S = "${WORKDIR}/git/eepromaccesstool"

#DEPENDS += "libgpiod libpciaccess util-linux"

EXTRA_OEMAKE = "'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}' \
'CFLAGS=${CFLAGS} -I${S}/include -DWITHOUT_XATTR' 'LDFLAGS=${LDFLAGS}' 'BUILDDIR=${S}'"

do_install () {
	oe_runmake install PREFIX=${D}/usr
	install -d ${D}${datadir}/${PN}
    install -m 0755 ${S}/hex_files/*.HEX ${D}${datadir}/${PN}
}

FILES:${PN} = "${bindir}/EepromAccessTool ${datadir}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
