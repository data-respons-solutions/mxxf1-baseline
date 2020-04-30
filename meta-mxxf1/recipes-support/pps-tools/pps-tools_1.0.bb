DESCRIPTION = "Linux PPS tools"
SECTION = "base"
HOMEPAGE = "http://github.com/ago/pps-tools"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

SRCREV ?= "${AUTOREV}"
SRC_URI = "git://github.com/ago/pps-tools.git"

S = "${WORKDIR}/git/"

PR = "r2"

#DEPENDS += "lmsensors"

EXTRA_OEMAKE = "'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}' \
'CFLAGS=${CFLAGS} -I${S}/include -I${S}/include/sys -DWITHOUT_XATTR' 'BUILDDIR=${S}'"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${includedir}
	install -d ${D}${includedir}/sys
	install -m 0644 timepps.h ${D}${includedir}
	install -m 0644 timepps.h ${D}${includedir}/sys
	install -m 0755 ppstest ${D}${bindir}
	install -m 0755 ppsctl ${D}${bindir}
	install -m 0755 ppswatch ${D}${bindir}
	install -m 0755 ppsfind ${D}${bindir}
	
}
BBCLASSEXTEND = "native nativesdk"

# PACKAGE_ARCH = "${MACHINE_ARCH}"
