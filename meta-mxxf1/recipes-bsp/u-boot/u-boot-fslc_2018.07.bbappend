FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI  += " \
	file://0001-Add-target-to-generate-initial-environment.patch \
	file://0001-mxxf1-Add-board-and-use-static-calibration-values.patch \
	file://0002-SUpport-newer-USB-disks.patch  \
	file://0003-mxxf1-Retarget-fdt-load-address-to-support-newer-ker.patch \
	file://0004-mxxf1-touch-update.patch \
    file://0005-mxxf1-Fix-RGMII-voltage-settings.patch \
    file://0006-Add-backlight-table-hack-Issue-1.patch \
	file://boot.txt \
"
EXTRA_OEMAKE += 'V=0'
LOCALVERSION = "+dr-1.4"

PV:append = "${LOCALVERSION}"

do_install:append () {
	install -d ${D}/boot
	install -m 0644 ${WORKDIR}/boot.txt ${D}/boot
}

FILES:${PN}:append = " /boot"
