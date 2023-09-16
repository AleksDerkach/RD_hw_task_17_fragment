package com.example.task_17_hometask_fragment

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MyRecycleViewAdapter(private val items:List<SuperHero>): RecyclerView.Adapter<MyRecycleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecycleViewHolder {
        val listItemViewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_layout, parent, false)
        return MyRecycleViewHolder(listItemViewHolder)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyRecycleViewHolder, position: Int) {
        holder.title.text = items[position].name
        holder.gender.text = items[position].appearance.gender
        Glide.with(holder.itemView)
            .load(items[position].images.xs)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            val mainActivity = it!!.context as AppCompatActivity
            val detFr = mainActivity.supportFragmentManager.findFragmentById(R.id.details) as? DetailsFragment

            mainActivity.getResources().getConfiguration().orientation

            if(detFr != null && mainActivity.getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE){
                detFr.setSuperHero(items[position])
                detFr.show()
            } else {
                val detFr = DetailsFragment()
                detFr.setSuperHero(items[position])
                mainActivity.supportFragmentManager.beginTransaction()
                    .add(R.id.list, detFr)
                    .addToBackStack("Details_Fragment")
                    .commit()
            }
        }
//        Glide.with(holder.imageView.context)
//            .asBitmap()
//            .load("your url")
//            .into(object : BitmapImageViewTarget(holder.imageView) {
//                override fun setResource(resource: Bitmap?) {
//                    holder.imageView.setImageBitmap(resource)
//                    super.setResource(resource)
//                }
//            })

//        GlideApp.with(holder.itemView)
//            .load(items[position].images.sm)
//            .placeholder(Android.drawable.boy_32)
//            .into(holder.imageView);

    }


}

class MyRecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title:TextView = itemView.findViewById(R.id.tvName)
    val imageView:ImageView = itemView.findViewById(R.id.image)
    val gender:TextView = itemView.findViewById(R.id.tvGender)
}


