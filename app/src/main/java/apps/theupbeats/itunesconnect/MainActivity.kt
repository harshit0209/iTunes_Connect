package apps.theupbeats.itunesconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatingActionButton.setOnClickListener{
         //   showSearchDialog(it)
            temp()
        }

    }
    fun showSearchDialog(v:View)
    {
        val inflater = layoutInflater
        val inflate_view= inflater.inflate(R.layout.search_dialog,null)

        val artist_EditText=inflate_view.findViewById(R.id.artist_name) as EditText

        val btn=inflate_view.findViewById(R.id.searchBtn) as Button
        btn.setOnClickListener{
            Toast.makeText(this@MainActivity,""+artist_EditText.text,Toast.LENGTH_SHORT).show()}
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Search Track on iTunes")
        dialog.setView(inflate_view)
        dialog.setCancelable(true)


        val dia=dialog.create()
        dia.window.attributes.windowAnimations=R.anim.zoom_in
        dia.show()
    }
    fun temp()//retrofit here
    {
        val retrofit = Retrofit.Builder()

            .baseUrl("https://itunes.apple.com")
           .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api=retrofit.create(Api::class.java)
        api.getArtist().enqueue(object: Callback<DataModel>{
            override fun onFailure(call: Call<DataModel>, t: Throwable) {

                d("tagkotout","got error $t")
            }

            override fun onResponse(
                call: Call<DataModel>,
                response: Response<DataModel>
            ) {
                show(response.body()!!)
                d("tagkotout","got response ")

            }
        })

    }
    fun show(songs: DataModel)
    {
         val list=songs.results

        list.forEach{d("skde",""+it)}


    }
}
