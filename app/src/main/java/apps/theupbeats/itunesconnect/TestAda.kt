package apps.theupbeats.itunesconnect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*


class TestAda(private val context: MainActivity, private val animals: ArrayList<String>) :
    RecyclerView.Adapter<TestAda.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
}
    override fun getItemCount(): Int {
    return animals.size
}
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    holder.chapterName?.text = animals.get(position)
        Picasso.with(context).load("https://is2-ssl.mzstatic.com/image/thumb/Music118/v4/24/46/97/24469731-f56f-29f6-67bd-53438f59ebcb/source/100x100bb.jpg").
        into(holder.imgV)
    holder.itemView.setOnClickListener {
        Toast.makeText(context, animals.get(position), Toast.LENGTH_LONG).show()
    }
}class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val chapterName = view.song
        val imgV=view.imageView2
}
}
