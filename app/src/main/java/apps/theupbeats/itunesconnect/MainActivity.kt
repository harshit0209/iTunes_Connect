package apps.theupbeats.itunesconnect

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var dia:AlertDialog?=null
    val animals: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addAnimals()






        val imgV=findViewById(R.id.imageView) as ImageView
        Picasso.with(this@MainActivity).load("https://is2-ssl.mzstatic.com/image/thumb/Music118/v4/24/46/97/24469731-f56f-29f6-67bd-53438f59ebcb/source/100x100bb.jpg").
            into(imgV)

        floatingActionButton.setOnClickListener{
          showSearchDialog(it)

        }

    }fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")
    }
    fun showSearchDialog(v:View)
    {
        val inflater = layoutInflater
        val inflate_view= inflater.inflate(R.layout.search_dialog,null)

        val artist_EditText=inflate_view.findViewById(R.id.artist_name) as EditText

        val btn=inflate_view.findViewById(R.id.searchBtn) as Button
        btn.setOnClickListener{

            var url:String=artist_EditText.text.toString()
            if(url.contains(" "))
                url=url.replace(" ","+")
            temp(url)


            Toast.makeText(this@MainActivity,"Searching.",Toast.LENGTH_SHORT).show()}
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Search Track on iTunes")
        dialog.setView(inflate_view)
        dialog.setCancelable(true)



        val dia=dialog.create()
        dia.window.attributes.windowAnimations=R.anim.zoom_in
        dia.show()
        this.dia=dia


    }
    fun temp(url:String)//retrofit here
    {
        dia?.dismiss()

        val retrofit = Retrofit.Builder()

            .baseUrl("https://itunes.apple.com")
           .addConverterFactory(GsonConverterFactory.create())
            .build()


        val api=retrofit.create(Api::class.java)

        api.getArtist("/search?term=$url").enqueue(object: Callback<DataModel>{
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
         val list=songs.results as ArrayList
        recyclerview.layoutManager=GridLayoutManager(this,2)
        recyclerview.adapter=TestAda(this,list)

        list.forEach{d("skde",""+it)}


    }
}
