require barebox.inc

SRC_URI += " \
    file://0001-USB-dwc3-Add-power-up-delay.patch \
    file://0002-IPUV3-Fix-LVDS-bridge.patch \
    file://0003-Add-mxxf1-board.patch \
    file://0004-mxxf1-Only-ctl-c-should-halt-boot-add-version-info.patch \
    file://0005-MXXF1-DDR3-corrections.patch \
"
#BAREBOX_IMAGES ?= "*.imximg"

DR_PATCH_VERSION = "1.4"
BAREBOX_BUILDSYSTEM_VERSION = "${PV}-dr-pl-${DR_PATCH_VERSION}"
SRC_URI[sha256sum] = "3c5cd5cc1dade3a19c805a9bd28d916fb2a0401eb25e3625e4b2a7ab8d7be39c"
