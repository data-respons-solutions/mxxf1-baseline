# Simple initramfs image. Mostly used for live images.
DESCRIPTION = "Small image capable of booting a device. The kernel includes \
the Minimal RAM-based Initial Root Filesystem (initramfs), which finds the \
first 'init' program more efficiently."

IMAGE_INSTALL = "initramfs-live-boot busybox udev base-passwd e2fsprogs  initramfs-module-e2fs initramfs-module-udev"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""

export IMAGE_BASENAME = "dr-initramfs"
IMAGE_LINGUAS = ""

LICENSE = "MIT"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
inherit core-image

#IMAGE_ROOTFS_SIZE = "8192"

BAD_RECOMMENDATIONS += "busybox-syslog"
