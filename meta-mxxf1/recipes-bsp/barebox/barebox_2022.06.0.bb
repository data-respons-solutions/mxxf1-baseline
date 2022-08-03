require barebox.inc

SRC_URI += " \
    file://0001-USB-dwc3-Add-power-up-delay.patch \
    file://0002-IPUV3-Fix-LVDS-bridge.patch \
    file://0003-Add-mxxf1-board.patch \
"
#BAREBOX_IMAGES ?= "*.imximg"

DR_PATCH_VERSION = "1.1"
BAREBOX_VERSION_EXTENSION = "-dr-pl-${DR_PATCH_VERSION}"

SRC_URI[sha256sum] = "264bd88ec910fec1361f9c06673ff902afdbab7377c246db8c247c367493d699"
