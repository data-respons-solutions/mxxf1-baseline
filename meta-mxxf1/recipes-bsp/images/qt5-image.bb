DESCRIPTION = "Data Respons RRM10  Qt5 image"

IMAGE_FEATURES += "ssh-server-openssh package-management hwcodecs debug-tweaks"
inherit core-image dr-image-info

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    packagegroup-core-tools-debug \
    packagegroup-core-eclipse-debug \
    packagegroup-core-full-cmdline \
    packagegroup-dr-qt5 \
    packagegroup-dr-extra \
    packagegroup-mxxf1 \
    networkmanager \
    networkmanager-nmcli \
    networkmanager-bash-completion \
    stressapptest \
    flash-uboot \
    eeprom-gen-generate \
    barebox \
"
