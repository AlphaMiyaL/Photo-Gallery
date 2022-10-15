package com.alphamiyal.photogallery

import android.app.Application
import androidx.lifecycle.*
import retrofit2.http.Query

//AndroidViewModel allows ViewModel to have access to the context
class PhotoGalleryViewModel(private val app: Application): AndroidViewModel(app) {
    val galleryItemLiveData: LiveData<List<GalleryItem>>

    private val flickrFetchr = FlickrFetchr()
    private val mutableSearchTerm = MutableLiveData<String>()

    val searchTerm: String
        get() = mutableSearchTerm.value ?: ""

    init {
        mutableSearchTerm.value = QueryPreferences.getStoredQuery(app)

        galleryItemLiveData = Transformations.switchMap(mutableSearchTerm){
            searchTerm ->
            if(searchTerm.isNullOrBlank()){
                flickrFetchr.fetchPhotos()
            }
            else{
                flickrFetchr.searchPhotos(searchTerm)
            }
        }
    }

    fun fetchPhotos(query: String = ""){
        QueryPreferences.setStoredQuery(app,query)
        mutableSearchTerm.value = query
    }
}