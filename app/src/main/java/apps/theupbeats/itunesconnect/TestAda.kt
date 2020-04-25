package apps.theupbeats.itunesconnect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*


class TestAda(private val context: MainActivity, private val songs: ArrayList<Result>) :
    RecyclerView.Adapter<TestAda.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
}
    override fun getItemCount(): Int {
    return songs.size
}
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    holder.chapterName?.text = songs.get(position).trackName
        Picasso.with(context).load(songs.get(position).artworkUrl100).into(holder.imgV)

    holder.itemView.setOnClickListener {
        Toast.makeText(context, songs.get(position).releaseDate, Toast.LENGTH_LONG).show()
    }
}class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {//deals with view not arrylist
    val chapterName = view.song
        val imgV=view.imageView2
}
}
