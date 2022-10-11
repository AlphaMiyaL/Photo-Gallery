package com.alphamiyal.api

import retrofit2.Call
import retrofit2.http.GET

//check Flickr's Api details
interface FlickrApi {
    @GET("services/rest/?method=flickr.interestingness.getList" +
        "&api_key=998d80af10bb90545eebde4365d1c00f" +
        "&format=json" +
        "&nojsoncallback=1" +
        "&extras=url_s")
    fun fetchPhotos(): Call<FlickrResponse>
}