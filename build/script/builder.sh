#!/bin/sh

die() {
	echo $1
	exit 1	
}

if [ "$#" -lt "1" ]; then
echo "Usage: $0 <topsrc>  [artifact]"
	exit 1
fi

top=$1
export TEMPLATECONF=$top/build/conf
export DR_CM_COMMIT=`git -C $top describe --tags --long --dirty`
export DR_BUILD_PLAN="manual"
export BB_ENV_EXTRAWHITE="DR_BUILD_PLAN DR_BUILD_NO DR_CM_COMMIT"
source $top/oe-core/oe-init-build-env build $top/bitbake
if [ "$#" -gt "1" ]; then
	echo "Starting build of $2 "
	bitbake $2 || die "bitbake failed"
fi

