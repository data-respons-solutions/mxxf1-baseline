# Copyright (C) 2014 DATA RESPONS AS.

SUMMARY = "RRM10 Collection"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    eeprom-gen-generate \
    flash-uboot \
    bzip2 \
    stressapptest \
    mmc-utils \
    prodtest \
"
