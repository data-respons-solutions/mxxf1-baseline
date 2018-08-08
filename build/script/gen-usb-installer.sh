#!/bin/sh


die() {
	echo $1
	exit 1	
}

if [ "$#" -lt "3" ]; then
echo "Usage: $0 <disk drive> <rootfs tar file> [payload image] [signed payload digest]"
	exit 1
fi

drive=$1
p1=$drive"1"
p2=$drive"2"

echo "Disk $drive using $p1 and $p2"

parted --script $1 mklabel msdos || die "Unable to create partition table on $1"
parted --script $1 mkpart primary 4 1000 || die "Unable to create partition 1 on $1"
parted --script $1 mkpart primary 1000 2000 || die "Unable to create partition 2 on $1"
echo "Creating ext4 on $p1"
mkfs.ext4 $p1 -L install || die "Unable to create FS on $p1"
echo "Creating ext4 on $p2"
mkfs.ext4 $p2 -L payload || die "Unable to create FS on $p2"

d=`mktemp -d`
mount $p1 $d || die "Unable to mount $p1 on $d"
echo "extract $2 on $p1"
tar -C $d -xf $2 || die "Tar failure"
umount $d

if [ "$#" = "5" ]; then
	mount $p2 $d || die "Unable to mount $p2 on $d"
	echo "Copy $3 and $4"
	mkdir -p $d/image
	cp $3 $d/image/image.bz2
	cp $4 $d/image/image-digest.signed
	umount $d
fi
echo "Done"
