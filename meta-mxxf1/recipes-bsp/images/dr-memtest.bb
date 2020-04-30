DESCRIPTION = "Data Respons RRM10 Production Test image with X11"

IMAGE_FEATURES += "ssh-server-openssh package-management hwcodecs debug-tweaks"
inherit core-image dr-image-info

BAD_RECOMMENDATIONS += "busybox-syslog"
NETWORK_MANAGER = "systemd"

ROOTFS_POSTPROCESS_COMMAND =+ "autostart_x;"

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    packagegroup-core-tools-debug \
    packagegroup-core-eclipse-debug \
    packagegroup-core-full-cmdline \
    packagegroup-dr-extra \
    packagegroup-mxxf1 \
    memtester \
    lmbench \
    tinymembench \
    networkmanager \
"


