#!/bin/sh

if [ "$#" -ne 3 ]; then 
	echo "Usage: $0 <mmc device> <SPL> <u-boot image>"
	exit 1
fi

echo "Erasing u-boot SPI env"
mtd_debug erase /dev/mtd0 0xc0000 0x10000
echo "Writing to mmc"
dd of=$1 if=$2 bs=1k seek=1
dd of=$1 if=$3 bs=1k seek=256
echo "Done"
