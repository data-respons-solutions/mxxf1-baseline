FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://kernelconf \
    file://0001-Add-OTP-driver-for-IMX6-fuses.patch \
    file://0002-mach-imx6q-Add-check-for-running-watchdog.-Add-DT-GP.patch \
    file://0003-Add-mxxf1-DT-files.patch \
"

addtask override_kernelconf after do_copy_defconfig before do_kernel_localversion
do_override_kernelconf () {
    mkdir -p ${B}
    cp ${WORKDIR}/kernelconf ${B}/.config
}
