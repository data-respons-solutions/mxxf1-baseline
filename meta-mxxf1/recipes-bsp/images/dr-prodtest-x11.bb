DESCRIPTION = "Data Respons RRM10 Production Test image with X11"

IMAGE_FEATURES += "ssh-server-openssh package-management hwcodecs"
inherit core-image dr-image-info

BAD_RECOMMENDATIONS += "busybox-syslog udev-extraconf"
NETWORK_MANAGER = "systemd"

#ROOTFS_POSTPROCESS_COMMAND =+ "autostart_x;"

autostart_x () {
#    ln -s ${IMAGE_ROOTFS}/lib/systemd/system/xserver-nodm.service ${IMAGE_ROOTFS}${sysconfdir}/systemd/system/multi-user.target.wants/.
    ln -sf /var/run/systemd/network/resolv.conf ${IMAGE_ROOTFS}${sysconfdir}/resolv.conf
}


IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    packagegroup-core-tools-debug \
    packagegroup-core-eclipse-debug \
    dbus \
    packagegroup-core-full-cmdline \
    packagegroup-dr-qt5 \
    packagegroup-dr-extra \
    packagegroup-mxxf1 \
    packagegroup-x11 \
    packagegroup-mxxf1-prod \
    eglinfo-x11 \
    tiff \
    memtester \
    lmbench \
    flash-uboot \
    network-config \
    metacity \
    gnome-settings-daemon \
    gnome-backgrounds \
    udisks-automounter \
"

