#!/bin/sh

die() {
	echo $1
	exit 1	
}

SCRIPT=$(readlink -f $BASH_SOURCE)
top=$(readlink -f $(dirname $SCRIPT)/../..)
echo top at $top
export TEMPLATECONF=$top/build/conf
echo template at $TEMPLATECONF
export DR_CM_COMMIT=`git -C $top describe --tags --long --dirty --always`
export DR_BUILD_PLAN="manual"
export BB_ENV_PASSTHROUGH_ADDITIONS="DR_BUILD_PLAN DR_BUILD_NO DR_CM_COMMIT"
source $top/poky/oe-init-build-env $1
