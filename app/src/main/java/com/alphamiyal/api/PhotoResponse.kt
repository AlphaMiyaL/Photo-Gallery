package com.alphamiyal.api

import com.alphamiyal.photogallery.GalleryItem
import com.google.gson.annotations.SerializedName

//map photo objects from JSON data
class PhotoResponse {
    @SerializedName("photo")
    lateinit var galleryItems: List<GalleryItem>
}