package com.ddorocare.brand_audit.model

import com.google.gson.annotations.SerializedName


data class GraphDetailResponse(

    @field:SerializedName("residub3")
    val residub3: Int? = null,

    @field:SerializedName("lokasi")
    val lokasi: String? = null,

    @field:SerializedName("total_sampah")
    val totalSampah: Int? = null,

    @field:SerializedName("daur_ulang_multi_layer")
    val daurUlangMultiLayer: Int? = null,

    @field:SerializedName("residu")
    val residu: Int? = null,

    @field:SerializedName("daur_ulang_single_layer")
    val daurUlangSingleLayer: Int? = null,

    @field:SerializedName("e_waste")
    val eWaste: Int? = null
)
