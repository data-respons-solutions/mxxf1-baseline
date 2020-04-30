DESCRIPTION = "Data Respons RRM10  Qt5 image"

IMAGE_FEATURES += "ssh-server-openssh package-management hwcodecs"
inherit core-image dr-image-info

BAD_RECOMMENDATIONS += "busybox-syslog udev-extraconf"
NETWORK_MANAGER = "systemd"

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    packagegroup-core-tools-debug \
    packagegroup-core-eclipse-debug \
    packagegroup-core-full-cmdline \
    packagegroup-dr-qt5 \
    packagegroup-dr-extra \
    network-config \
    udisks \
    u-boot-dr \
    udev-dr-extra \
    libsysfs \
    lmsensors-sensord \
    gstreamer1.0-plugins-imx \
    eglinfo-fb \
"


