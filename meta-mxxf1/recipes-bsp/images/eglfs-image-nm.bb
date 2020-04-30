DESCRIPTION = "Data Respons RRM10  Qt5 image"

IMAGE_FEATURES += "ssh-server-openssh package-management hwcodecs"
inherit core-image

BAD_RECOMMENDATIONS += "busybox-syslog"
NETWORK_MANAGER = "systemd"

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    packagegroup-core-tools-debug \
    packagegroup-core-eclipse-debug \
    packagegroup-core-full-cmdline \
    packagegroup-dr-qt5 \
    packagegroup-mxxf1 \
    iperf3 \
    bash-completion \
    e2fsprogs-resize2fs \
    networkmanager \
    networkmanager-tests \
    networkmanager-bash-completion \
    libnmutil \
    libnmglib \
    libnmglib-vpn \
    iftop \
    htop \
    python-pyserial \
    netcat \
    dosfstools \
    rsync \
    avahi-daemon \
    avahi-utils \
    ldd \
    lsof \
    cpufrequtils \
    protobuf \
    localedef \
    gstreamer1.0 \
    libsysfs \
    mtd-utils \
    parted \
    python \
    dhcp-client \
    fontconfig \
    builtin-users \
"


