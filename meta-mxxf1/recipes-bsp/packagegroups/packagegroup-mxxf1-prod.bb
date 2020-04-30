# Copyright (C) 2014 DATA RESPONS AS.

SUMMARY = "RRM10 Collection"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
    eeprom-gen-generate \
    prodtest \
    flash-uboot \
    bzip2 \
    stressapptest \
"
