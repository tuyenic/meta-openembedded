SUMMARY = "free PDF library"
HOMEPAGE = "http://libharu.org"
DESCRIPTION = "libHaru is a library for generating PDF files. \
               It is free, open source, written in ANSI C and cross platform. "

LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://README;md5=3ee6bc1f64d9cc7907f44840c8e50cb1"

SRC_URI = "https://github.com/libharu/${BPN}/archive/RELEASE_${@d.getVar('PV').replace('.','_')}.tar.gz \
           file://libharu-RELEASE_2_3_0_cmake.patch \
	   "

SRC_URI[md5sum] = "4f916aa49c3069b3a10850013c507460"
SRC_URI[sha256sum] = "8f9e68cc5d5f7d53d1bc61a1ed876add1faf4f91070dbc360d8b259f46d9a4d2"

S = "${WORKDIR}/${BPN}-RELEASE_${@d.getVar('PV').replace('.','_')}"

inherit cmake
DEPENDS += "libpng zlib"

do_install_append() {
     mkdir -p ${D}/${datadir}/libharu
     mv ${D}/libharu ${D}/${datadir}
}
