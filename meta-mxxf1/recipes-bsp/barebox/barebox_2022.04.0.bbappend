
SRC_URI += " \
    file://0001-Add-DR-MXXF1-board-and-fix-LVDS-bridge.patch \
"
#BAREBOX_IMAGES ?= "*.imximg"

DR_PATCH_VERSION = "1.0"
BAREBOX_VERSION_EXTENSION = "-dr-pl-${DR_PATCH_VERSION}"
