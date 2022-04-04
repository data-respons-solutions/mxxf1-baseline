# How To Use

External recipe sources are included in the project as git submodules.
These modules need to be initialized on first use:

`git submodule update --init`

BitBake relies on the build environment providing a large
set of environment variables.  These are most easily set up by sourcing
the provided script:

`source $TOP/build/scripts/builder.sh`

And now you can build:

`DISTRO=dr-distro bitbake <image>`
