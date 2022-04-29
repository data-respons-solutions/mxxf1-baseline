DESCRIPTION = "Utility to flash boot loader"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=b97a012949927931feb7793eee5ed924"

inherit  python3native python3-dir
SRC_URI = 	"file://flash-uboot.py \
		 "

RDEPENDS:${PN} = "python3"

S = "${WORKDIR}"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/flash-uboot.py ${D}${bindir}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
