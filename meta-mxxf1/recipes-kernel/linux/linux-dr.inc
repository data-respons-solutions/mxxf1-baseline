# Copyright (C) 2012, 2014 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

inherit kernel

PROVIDES = "virtual/kernel"

# Put a local version until we have a true SRCREV to point to
LOCALVERSION ?= "+dr"
SCMVERSION ?= "y"

S = "${WORKDIR}/git"

#KERNEL_CONFIG_COMMAND ?= "oe_runmake_call -C ${S} O=${B} ${MACHINE_KERNEL_CONFIG}"
