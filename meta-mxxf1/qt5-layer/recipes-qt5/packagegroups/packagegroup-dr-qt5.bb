# Copyright (C) 2014 DATA RESPONS AS.

SUMMARY = "Qt5 Collection"
LICENSE = "MIT"

PACKAGE_ARCH = "${TUNE_PKGARCH}"
inherit packagegroup

RDEPENDS:${PN} = " \
    qtbase \
    qtdeclarative \
    qtdeclarative-qmlplugins \
    qtbase-plugins \
    qtmultimedia \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtlocation \
    qtlocation-plugins \
    qtlocation-qmlplugins \
    qt3d \
    qt3d-mkspecs \
    qt3d-qmlplugins \
    qt3d-plugins \
    qtconnectivity-mkspecs \
    qtconnectivity-qmlplugins \
    cinematicexperience \
    qt5everywheredemo \
"
RRECOMMENDS:${PN} += " \
    qtquickcontrols-qmlplugins \
"
