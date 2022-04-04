do_install:append () {
    sed -i "s|publish-workstation=no|publish-workstation=yes|g" ${D}${sysconfdir}/avahi/avahi-daemon.conf
}
