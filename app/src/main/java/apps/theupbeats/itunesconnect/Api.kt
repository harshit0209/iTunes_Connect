package apps.theupbeats.itunesconnect

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/search?term=jack+johnson")
    fun getArtist(): Call<DataModel>
}