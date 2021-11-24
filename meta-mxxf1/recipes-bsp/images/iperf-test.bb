DESCRIPTION = "Data Respons RRM10  Qt5 image"

IMAGE_FEATURES += "ssh-server-openssh package-management hwcodecs debug-tweaks"
inherit core-image

NETWORK_MANAGER = "systemd"

ROOTFS_POSTPROCESS_COMMAND:append = " uboot_mod;"

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    packagegroup-core-tools-debug \
    packagegroup-core-eclipse-debug \
    packagegroup-core-full-cmdline \
    packagegroup-dr-qt5 \
    packagegroup-dr-extra \
    packagegroup-mxxf1 \
    network-config-iperf \
    stressapptest \
    memtester \
    tinymembench \
"
uboot_mod () {
    echo "fdt_addr=0x18000000" > ${IMAGE_ROOTFS}/boot/boot.txt
}
