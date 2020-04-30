# Copyright (C) 2014 DATA RESPONS AS.

SUMMARY = "Qt5 Collection"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
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
    qtsensors-qmlplugins \
    qtserialport-mkspecs \
    qtsvg-mkspecs \
    qtsvg-plugins \
    qt3d \
    qt3d-mkspecs \
    qt3d-qmlplugins \
    qt3d-plugins \
    qtsensors-mkspecs \
    qtsensors-plugins \
    qtsensors-qmlplugins \
    qtconnectivity-mkspecs \
    qtconnectivity-qmlplugins \
    cinematicexperience \
    qt5everywheredemo \
"
RRECOMMENDS_${PN} += " \
    qtquickcontrols-qmlplugins \
"
