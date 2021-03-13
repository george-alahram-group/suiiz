package com.suiiz.util

import android.content.res.Resources
import com.suiiz.R
import com.suiiz.model.Section

object DumyData {

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
        ),Section(
            3,
            res.getString(R.string.buildings),
            "250",
            "https://www.freeiconspng.com/thumbs/car-icon-png/car-icon-png-25.png"
        ),Section(
            4,
            res.getString(R.string.buildings),
            "250",
            "https://img.icons8.com/ios/452/oil-industry.png"
        ),Section(
            5,
            res.getString(R.string.buildings),
            "250",
            "https://img.pngio.com/building-icon-svg-png-icon-free-download-384110-building-icon-png-980_908.png"
        ),Section(
            6,
            res.getString(R.string.buildings),
            "250",
            "https://www.freeiconspng.com/thumbs/car-icon-png/car-icon-png-25.png"
        ),Section(
            7,
            res.getString(R.string.buildings),
            "250",
            "https://img.icons8.com/ios/452/oil-industry.png"
        ),Section(
            8,
            res.getString(R.string.buildings),
            "250",
            "https://img.pngio.com/building-icon-svg-png-icon-free-download-384110-building-icon-png-980_908.png"
        )
    )

}