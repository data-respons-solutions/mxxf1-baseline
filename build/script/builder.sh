#!/bin/sh

die() {
	echo $1
	exit 1	
}

if [ "$#" -lt "1" ]; then
echo "Usage: $0 <topsrc>  [artifact] [sign_top]"
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

if [ "$#" -eq "3" ]; then
	fakeroot $3/linux64/bin/dr_signer.py --rfsout `basename $2`-signed ./tmp-glibc/deploy/images/cargotec-gw/$2-cargotec-gw.tar.bz2
fi
