DESCRIPTION = "Utility to flash boot loader"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=b97a012949927931feb7793eee5ed924"

inherit  python3native python3-dir
SRC_URI = 	"file://flash-uboot.py \
		 	file://erase-uboot-env.py \
		 	file://rescue-mmc-boot.sh \
		 "
PR = "r0"

RDEPENDS_${PN} = "python3"

S = "${WORKDIR}"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/flash-uboot.py ${D}${bindir}
    install -m 0755 ${WORKDIR}/erase-uboot-env.py ${D}${bindir}
    install -m 0755 ${WORKDIR}/rescue-mmc-boot.sh ${D}${bindir}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
