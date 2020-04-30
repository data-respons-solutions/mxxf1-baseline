DESCRIPTION = "Data Respons RRM10 Production Test image with X11"

IMAGE_FEATURES += "x11-base ssh-server-openssh package-management hwcodecs"
inherit core-image dr-image-info

BAD_RECOMMENDATIONS += "busybox-syslog"
NETWORK_MANAGER = "systemd"

ROOTFS_POSTPROCESS_COMMAND =+ "autostart_x;"

autostart_x () {
#    ln -s ${IMAGE_ROOTFS}/lib/systemd/system/xserver-nodm.service ${IMAGE_ROOTFS}${sysconfdir}/systemd/system/multi-user.target.wants/.
    ln -sf /var/run/systemd/network/resolv.conf ${IMAGE_ROOTFS}${sysconfdir}/resolv.conf
}


IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    gpu-viv-bin-mx6q \
    packagegroup-core-tools-debug \
    packagegroup-core-eclipse-debug \
    packagegroup-core-x11-xserver \
    packagegroup-core-full-cmdline \
    packagegroup-dr-qt5 \
    packagegroup-dr-extra \
    packagegroup-mxxf1 \
    eglinfo-x11 \
  	xf86-input-mouse \
    xf86-input-keyboard \
    xf86-input-evdev \
    xcb-util-wm \
    tiff \
    memorytest-service \
    lmbench \
    guitest-service \
"


