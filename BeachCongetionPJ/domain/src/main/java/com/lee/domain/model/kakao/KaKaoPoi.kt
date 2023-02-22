package com.lee.domain.model.kakao

data class KaKaoPoi(
    val documents : ArrayList<Documents>,
    val meta : Meta
)

data class Documents(
    val addressName : String ,
    val categoryGroupCode : String ,
    val categoryGroupName : String ,
    val categoryName : String ,
    val distance : String ,
    val id : String ,
    val phone : String ,
    val placeName : String ,
    val placeURL : String ,
    val roadAddressName : String ,
    val longitude : String ,
    val latitude : String
)

data class Meta(
    val isEnd : Boolean,
    val pageableCount : Int,
    val sameName : SameName,
    val totalCount : Int
)

data class SameName(
    val keyword : String ,
    val region : MutableList<String> ,
    val selectedRegion : String?
)