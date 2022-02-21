package com.nahlasamir244.newsapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class News(

    @SerializedName("slug_name") var slugName: String? = null,
    @SerializedName("section") var section: String? = null,
    @SerializedName("subsection") var subsection: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("abstract") var abstract: String? = null,
    @SerializedName("uri") var uri: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("byline") var byline: String? = null,
    @SerializedName("thumbnail_standard") var thumbnailStandard: String? = null,
    @SerializedName("item_type") var itemType: String? = null,
    @SerializedName("source") var source: String? = null,
    @SerializedName("updated_date") var updatedDate: String? = null,
    @SerializedName("created_date") var createdDate: String? = null,
    @SerializedName("published_date") var publishedDate: String? = null,
    @SerializedName("first_published_date") var firstPublishedDate: String? = null,
    @SerializedName("multimedia") var multimedia: @RawValue ArrayList<Multimedia> = arrayListOf()

): Parcelable