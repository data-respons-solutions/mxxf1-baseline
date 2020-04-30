SUMMARY = "Qt Virtual Keyboard"
DESCRIPTION = "Srceen/touch based input"
require recipes-qt/qt5/qt5.inc

LICENSE = "GFDL-1.3 & BSD & (LGPL-2.1 & The-Qt-Company-Qt-LGPL-Exception-1.1 | LGPL-3.0)"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

#SRCREV ?= "${AUTOREV}"
SRCREV = "68c30e00b0d9850643611d5ba9c29a247ccd44ec"

#SRC_URI = "git://code.qt.io/qt/qtvirtualkeyboard.git;protocol=git;branch=5.6"
SRC_URI = "git://code.qt.io/qt/qtvirtualkeyboard.git;protocol=http;branch=5.6"
DEPENDS += "qtdeclarative"

RDEPENDS_${PN}-dev = ""

S = "${WORKDIR}/git/"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_QML}/*/*/*/*/.debug \
"
