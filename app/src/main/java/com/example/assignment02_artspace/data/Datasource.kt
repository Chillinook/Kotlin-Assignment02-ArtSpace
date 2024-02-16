package com.example.assignment02_artspace.data

import com.example.assignment02_artspace.R
import com.example.assignment02_artspace.model.Moto

class Datasource() {
    fun loadMoto(): List<Moto> {
        return listOf<Moto>(
            Moto(R.string.rider1,R.string.riderDate1,R.drawable.image1),
            Moto(R.string.rider2,R.string.riderDate2,R.drawable.image2),
            Moto(R.string.rider3,R.string.riderDate3,R.drawable.image3),
            Moto(R.string.rider4,R.string.riderDate4,R.drawable.image4),
            Moto(R.string.rider5,R.string.riderDate5,R.drawable.image5),
            Moto(R.string.rider6,R.string.riderDate6,R.drawable.image6),
           )
    }





}