package apps.theupbeats.itunesconnect

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface Api {
    @GET
    fun getArtist(@Url url:String): Call<DataModel>
}