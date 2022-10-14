package com.alphamiyal.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

//check Flickr's Api details
interface FlickrApi {
//    @GET("services/rest/?method=flickr.interestingness.getList" +
//        "&api_key=998d80af10bb90545eebde4365d1c00f" +
//        "&format=json" +
//        "&nojsoncallback=1" +
//        "&extras=url_s")
    @GET("services/rest/?method=flickr.interestingness.getList" +
        "&api_key=4f721bbafa75bf6d2cb5af54f937bb70" +
        "&format=json" +
        "&nojsoncallback=1" +
        "&extras=url_s")
    fun fetchPhotos(): Call<FlickrResponse>

    //parameterless get + @Url causes Retrofit to use URL passed to the fetchUrlBytes()
    @GET
    fun fetchUrlBytes(@Url url: String): Call<ResponseBody>
}