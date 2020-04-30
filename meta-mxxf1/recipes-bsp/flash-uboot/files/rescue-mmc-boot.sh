#!/bin/sh

if [ "$#" -lt 2 ]; then
    echo "Usage $0 <SPL> <u-boot.img> [-w]"
    exit 1
fi

if [ ! -e $1 ]; then
    echo "$1 not found - aborting"
    exit 1;
fi

p1start=`fdisk -l /dev/mmcblk0 | grep mmcblk0p1 | gawk -F" " '{ print $2 }'`
echo "First partition at $p1start"

if [ `expr $p1start \< 2048` = "1" ] ; then
    echo "No room on mmc for bootloader - aborting"
    exit 1
fi

if [ "$3" = "-w" ]; then

    echo "Erasing SPI boot parameters"
    echo 0 > /sys/class/gpio/gpio171/value
    mtd_debug erase /dev/mtd0 0xC0000 0x10000 || mtd_debug erase /dev/mtd1 0x0 0x10000
    echo 1 > /sys/class/gpio/gpio171/value
fi

echo "Writing SPL to MMC"
dd if=$1 of=/dev/mmcblk0 bs=1k seek=1
echo "Writing UBOOT to MMC"
dd if=$2 of=/dev/mmcblk0 bs=1k seek=256
echo "Done, may reboot now"



