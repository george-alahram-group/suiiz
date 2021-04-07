package com.suiiz.util

import android.content.res.Resources
import com.suiiz.R
import com.suiiz.model.*

object DummyData {


    fun mainCategoryList(res: Resources) = mutableListOf(
        Section(
            0,
            res.getString(R.string.vehicle),
            "250",
            "https://www.freeiconspng.com/thumbs/car-icon-png/car-icon-png-25.png"
        ),
        Section(
            1,
            res.getString(R.string.oil_products),
            "250",
            "https://img.icons8.com/ios/452/oil-industry.png"
        ),
        Section(
            2,
            res.getString(R.string.buildings),
            "250",
            "https://img.pngio.com/building-icon-svg-png-icon-free-download-384110-building-icon-png-980_908.png"
        ), Section(
            3,
            res.getString(R.string.buildings),
            "250",
            "https://www.freeiconspng.com/thumbs/car-icon-png/car-icon-png-25.png"
        ), Section(
            4,
            res.getString(R.string.buildings),
            "250",
            "https://img.icons8.com/ios/452/oil-industry.png"
        ), Section(
            5,
            res.getString(R.string.buildings),
            "250",
            "https://img.pngio.com/building-icon-svg-png-icon-free-download-384110-building-icon-png-980_908.png"
        ), Section(
            6,
            res.getString(R.string.buildings),
            "250",
            "https://www.freeiconspng.com/thumbs/car-icon-png/car-icon-png-25.png"
        ), Section(
            7,
            res.getString(R.string.buildings),
            "250",
            "https://img.icons8.com/ios/452/oil-industry.png"
        ), Section(
            8,
            res.getString(R.string.buildings),
            "250",
            "https://img.pngio.com/building-icon-svg-png-icon-free-download-384110-building-icon-png-980_908.png"
        )
    )

    fun vehicleList(res: Resources) = mutableListOf(
        Section(
            0,
            res.getString(R.string.cars),
            "250",
            "https://www.freeiconspng.com/uploads/transport-car-icon--6.png"
        ),
        Section(
            1,
            res.getString(R.string.motorcycle),
            "250",
            "https://secure.webtoolhub.com/static/resources/icons/set73/a130719f.png"
        ),
        Section(
            2,
            res.getString(R.string.micro_buses),
            "250",
            "https://static.thenounproject.com/png/363187-200.png"
        ),
        Section(
            3,
            res.getString(R.string.buses),
            "250",
            "https://www.pinclipart.com/picdir/big/29-292323_bus-icon-png-clipart-bus-computer-icons-clip.png"
        ),
        Section(
            4,
            res.getString(R.string.mini_trucks),
            "250",
            "https://cdn.iconscout.com/icon/free/png-256/open-truck-462232.png"
        ),
        Section(
            5,
            res.getString(R.string.trucks),
            "250",
            "https://image.flaticon.com/icons/png/512/45/45880.png"
        ),
        Section(
            5,
            res.getString(R.string.tructors),
            "250",
            "https://lh3.googleusercontent.com/proxy/_fsOQpr3XuMvevTf3LNdsQvPBaThavviNmizrXZPsC14ICvKqj-TCYxwEaejRkXp-MzQIKxyBlTxikhw8TgyUx-Rz-5ZJMXFJH2v1kL_nTQvQyum5cuz"
        )
    )

    fun carsBrandList(res: Resources) = mutableListOf(
        Section(
            0, "NISSAN", "250",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Nissan-logo.svg/1189px-Nissan-logo.svg.png"
        ),
        Section(
            0, "HYUNDAI", "250",
            "https://w7.pngwing.com/pngs/646/703/png-transparent-hyundai-logo-hyundai-motor-company-car-kia-motors-logo-hyundai-emblem-car-material.png"
        ),
        Section(
            0, "RENAULT", "250",
            "https://www.vhv.rs/dpng/d/353-3532922_renault-logo-png-renault-logo-transparent-png.png"
        ),
        Section(
            0, "PEUGEOT", "250",
            "https://c0.klipartz.com/pngpicture/500/331/gratis-png-peugeot-bicicleta-logo-herramienta-peugeot.png"
        ),
        Section(
            0, "FIAT", "250",
            "https://lh3.googleusercontent.com/proxy/aTCDSHyK7cJjwFvV0XWbnSDuG0SH2KtoW3C-MnKO_AMCGUBsIVvqk9gmVLRe4r07adZJ66pQ6rgobkQ0ui7rONzqeymH1t63vET_BTaS34MvgM4KiEpMvp7JP40"
        ),
        Section(
            0, "LAND ROVER", "250",
            "https://www.carlogos.org/car-logos/land-rover-logo.png"
        ),
        Section(
            0, "BMW", "250",
            "https://logodownload.org/wp-content/uploads/2014/04/bmw-logo-2.png"
        )
    )

    fun loopVpList() = arrayListOf<String>(
        "https://www.fia.com/sites/default/files/styles/content_details/public/news/main_image/2017_concept_1.jpg?itok=MJSFw833",
        "https://drivetribe.imgix.net/Fn0CvExKT02WNCO_Rz51Tw?w=600&h=338&fm=jpe&auto=compress&fit=crop&crop=faces",
        "https://www.topgear.com/sites/default/files/styles/16x9_1280w/public/images/news-article/2018/01/d3a0a38bf9212fa4e4bef1f40ead0e7f/duinmwixkaatair.jpg?itok=BLdGISce"
    )

    fun servicesList(res: Resources) = mutableListOf(
        Section(
            0,
            res.getString(R.string.public_services),
            "250",
            "https://icons-for-free.com/iconfiles/png/512/customer+finance+money+service+icon-1320086608272712746.png"
        ),
        Section(
            1,
            res.getString(R.string.local_services),
            "250",
            "https://icons-for-free.com/iconfiles/png/512/customer+finance+money+service+icon-1320086608272712746.png"
        ),
        Section(
            2,
            res.getString(R.string.suiiz_services),
            "250",
            "https://icons-for-free.com/iconfiles/png/512/customer+finance+money+service+icon-1320086608272712746.png"
        )
    )


    fun favoriteList(res: Resources) = mutableListOf(
        Favorite(
            0,
            "Title_A",
            "this content is provided by a dumy data an this is not real",
            3.6f,
            "2000",
            "2500",
            true,
            "https://www.wautom.com/wp-content/uploads/2013/01/motor.jpg",
            "",
            "Cairo - Egypt",
            "Al_Ahram Group",
            "12-12-2020"
        ),
        Favorite(
            1,
            "Title_B",
            "this content is provided by a dumy data an this is not real",
            4.5f,
            "7000",
            "8500",
            true,
            "https://spectrum.ieee.org/image/MzM5ODEzNg.jpeg",
            "",
            "Alexandria - Egypt",
            "Al_Ahram Group",
            "12-12-2020"
        ),
        Favorite(
            0,
            "Title_A",
            "this content is provided by a dumy data an this is not real",
            3.6f,
            "2000",
            "2500",
            true,
            "https://www.wautom.com/wp-content/uploads/2013/01/motor.jpg",
            "",
            "Cairo - Egypt",
            "Al_Ahram Group",
            "12-12-2020"
        ),
        Favorite(
            1,
            "Title_B",
            "this content is provided by a dumy data an this is not real",
            4.5f,
            "7000",
            "8500",
            true,
            "https://spectrum.ieee.org/image/MzM5ODEzNg.jpeg",
            "",
            "Alexandria - Egypt",
            "Al_Ahram Group",
            "12-12-2020"
        ),
        Favorite(
            0,
            "Title_A",
            "this content is provided by a dumy data an this is not real",
            3.6f,
            "2000",
            "2500",
            true,
            "https://www.wautom.com/wp-content/uploads/2013/01/motor.jpg",
            "",
            "Cairo - Egypt",
            "Al_Ahram Group",
            "12-12-2020"
        ),
        Favorite(
            1,
            "Title_B",
            "this content is provided by a dumy data an this is not real",
            4.5f,
            "7000",
            "8500",
            true,
            "https://spectrum.ieee.org/image/MzM5ODEzNg.jpeg",
            "",
            "Alexandria - Egypt",
            "Al_Ahram Group",
            "12-12-2020"
        )

    )

    fun cartList(res: Resources): MutableList<Cart> {
        val list = mutableListOf<Cart>()
        for (i in 0..10) {
            list.add(
                Cart(
                    0,
                    "Item A",
                    "https://spectrum.ieee.org/image/MzM5ODEzNg.jpeg",
                    "Motors",
                    500,
                    "Al_Ahram Group",
                    1
                )
            )
        }
        return list
    }

    fun modelsList(res: Resources): MutableList<BrandModel> {
        val list = mutableListOf<BrandModel>()
        for (i in 0..10) {
            list.add(
                BrandModel(
                    0,
                    "https://ymimg1.b8cdn.com/resized/car_version/21540/pictures/6193914/mobile_listing_main_13800_st1280_089.jpg",
                    4,
                    listOf("sDrive35i", "xDrive35i", "xDrive50i", "M"),
                    listOf("2017", "2018", "2019", "2020", "2021")
                )
            )
        }
        return list
    }

    fun partsList(res: Resources): MutableList<Part> {
        val list = mutableListOf<Part>()
        for (i in 0..10) {
            list.add(
                Part(
                    0,
                    "PART ${i + 1}",
                    "https://www.nicepng.com/png/detail/334-3342222_car-auto-parts-png.png",
                )
            )
        }
        return list
    }

    fun bestSellerList(res: Resources): MutableList<BestSeller> {
        val list = mutableListOf<BestSeller>()
        for (i in 0..4) {
            list.add(
                BestSeller(
                    i,
                    "Seller ${i + 1}",
                    "Engine",
                    "https://spectrum.ieee.org/image/MzM5ODEzNg.jpeg",
                    "PARTS",
                    199.99f * (i+1),
                    2.8f,
                    35 - i
                )
            )
        }
        return list
    }

    fun wantedStoresList(): MutableList<String> {
        val list = mutableListOf<String>()
        for (i in 0..4)
            list.add("https://centaur-wp.s3.eu-central-1.amazonaws.com/designweek/prod/content/uploads/2018/01/19151152/FORMULA-1%C2%AE-UNLEASHES-NEW-BRAND-IDENTITY-INSPIRED-BY-ITS-FANS-OPTION-2.jpg")
        return list
    }

    fun partsDetailedList(): MutableList<SubPart> {
        val list = mutableListOf<SubPart>()
        for (i in 0..9)
            list.add(SubPart(
                i+1,
                "Part ${i+1}",
                "https://www.nicepng.com/png/detail/334-3342222_car-auto-parts-png.png",
                "Publisher",
                2000f,
                if (i%2 == 0) (i+2)*2500.99f else (i*200)/2500.99f,
                "Cairo - Egypt",
                "https://www.jacksonimmuno.com/img/static-pages/flag-egypt.png",
                "30-12-2020",
                2.5f,
                "",
                i%2 != 0
            ))
        return list
    }

    fun productDetailsImagesList () = mutableListOf(
        "https://purepng.com/public/uploads/large/purepng.com-engine-motorsenginemotorcar-enginemechanical-energyburnfuel-1701527503050fde0n.png",
        "https://img2.pngio.com/car-engine-png-hd-transparent-car-engine-hdpng-images-pluspng-engines-png-1004_893.png",
        "https://freepikpsd.com/wp-content/uploads/2020/11/car-motor-png-5.png"
    )

}