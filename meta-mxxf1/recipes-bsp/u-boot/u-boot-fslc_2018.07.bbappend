FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI  += " \
	file://0001-mxxf1-Add-board-and-use-static-calibration-values.patch \
	file://0002-Delay-USB-scan-after-power.patch \
	file://0003-USB-storage-Reduce-max-blocks-in-transfer.patch \
	file://0001-Add-target-to-generate-initial-environment.patch \
	file://0004-Remove-unconditional-fix-for-ARM-ERRATA-845369.patch \
	file://0005-mxxf1-Retarget-fdt-load-address-to-support-newer-ker.patch \
	file://0006-mxxf1-Fix-RGMII-voltage-settings.patch \
"
EXTRA_OEMAKE += 'V=0'
LOCALVERSION = "+dr-1.3"

PV_append = "${LOCALVERSION}"
