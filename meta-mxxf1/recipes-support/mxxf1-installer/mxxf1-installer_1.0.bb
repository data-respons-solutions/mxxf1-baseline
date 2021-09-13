DESCRIPTION = "Installer Image for MXXF1"
SECTION = "base"
HOMEPAGE = "https://datarespons.com/solutions"
LICENSE = "BSD"
#SECTION = "x11/apps"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

SRCREV ?= "8925a299495c94b59a0167e6d43d83b7a43e1cfc"
SRC_URI = "git://git@github.com/data-respons-solutions/oem-mxxf1-installer.git;protocol=ssh;branch=master"
S = "${WORKDIR}/git"

PV = "1.0.0+git${SRCPV}"

#EXTRA_OEMAKE = "'CXX=${CXX}' 'RANLIB=${RANLIB}' 'AR=${AR}'
#'CXXFLAGS=${CXXFLAGS} -I${S}/include -DWITHOUT_XATTR' 'BUILDDIR=${S}'"

require recipes-qt/qt5/qt5.inc

DEPENDS = "qtdeclarative"
RDEPENDS_${PN} = "parted qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins flash-uboot"


#inherit qt4x11 pkgconfig
#EXTRA_QMAKEVARS_PRE += "PREFIX=/usr"

do_configure() {
    ${OE_QMAKE_QMAKE} ${S}/Installer.pro
}

do_install() {
    oe_runmake INSTALL_ROOT=${D} install
}

FILES_${PN} = "\
    /opt/Installer/* \
    "

FILES_${PN}-dbg = "\
    /opt/Installer/bin/.debug \
    "
FILES_${PN}-dev = "\
    /usr/src/debug \
    "
    
PACKAGE_ARCH = "${MACHINE_ARCH}"
