package com.nahlasamir244.newsapp.data.model

import com.google.gson.annotations.SerializedName


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
    @SerializedName("material_type_facet") var materialTypeFacet: String? = null,
    @SerializedName("kicker") var kicker: String? = null,
    @SerializedName("subheadline") var subheadLine: String? = null,
    @SerializedName("des_facet") var desFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("org_facet") var orgFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("per_facet") var perFacet: ArrayList<String> = arrayListOf(),
    @SerializedName("geo_facet") var geoFacet: String? = null,
    @SerializedName("related_urls") var relatedUrls: String? = null,
    @SerializedName("multimedia") var multimedia: ArrayList<Multimedia> = arrayListOf()

)