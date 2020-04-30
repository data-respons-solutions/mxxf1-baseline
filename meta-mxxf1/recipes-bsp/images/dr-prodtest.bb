DESCRIPTION = "Data Respons RRM10 Production Test image"

inherit core-image dr-image-info
IMAGE_FEATURES += "ssh-server-openssh package-management hwcodecs empty-root-password"

VOLATILE_LOG_DIR = "no"

ROOT_KEY = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCuzVgNYsqU33Zx7D8LGwqcD6T+R8iQkqKSXuK7V7o6cNE7CsAsPlAdd4A+79cUxpZlXnY8ou/8nRB4N1b0JACZ+Qno80kfjbN0OwN4Vd2fdKeDBNokUe1c5uPnnlVACT9QfrC7RsFjQIWTu6wgAik5/OOgqz0mwbdpqXwxZTZjwfz1b1859AzV0axrSrs0Em13t6CjG0WgzjbS/oA1TOq5d5FmkvampxAlu9er/5/Sh40wbyhw7lLgXuuySrZxGQZV7lXvStjRFv4Nuq4bwz3aexkUCMJx4uTgho3Fxjm3h36yZKNJiSCFGBW7CQwT4/tySigza39O9CYvUm7I5wwF root@mxxf1"

ROOTFS_POSTPROCESS_COMMAND_append = " add_ssh_root_key;"

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    packagegroup-core-tools-debug \
    packagegroup-core-eclipse-debug \
    dbus \
    packagegroup-core-full-cmdline-libs \
    packagegroup-core-full-cmdline-utils \
    packagegroup-core-full-cmdline-extended \
    packagegroup-core-full-cmdline-dev-utils \
    packagegroup-core-full-cmdline-multiuser \
    packagegroup-dr-qt5 \
    packagegroup-dr-extra \
    packagegroup-mxxf1 \
    packagegroup-mxxf1-prod \
    tiff \
    memtester \
    lmbench \
    flash-uboot \
    udisks-automounter \
    connman \
    connman-client \
"

add_ssh_root_key () {
    install -d -m 700 ${IMAGE_ROOTFS}/home/root/.ssh
    echo ${ROOT_KEY} > ${IMAGE_ROOTFS}/home/root/.ssh/authorized_keys
    chmod 0600  ${IMAGE_ROOTFS}/home/root/.ssh/authorized_keys
}
