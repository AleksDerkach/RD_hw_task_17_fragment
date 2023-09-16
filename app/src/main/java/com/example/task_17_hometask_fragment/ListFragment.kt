package com.example.task_17_hometask_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list: RecyclerView = view.findViewById(R.id.RecyclerView)
        val client = ApiClient.client.create(ApiInterface::class.java)
        client.getSuperHero()

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                //if (it.isNotEmpty()) {
                    val items = it
                    val myAdapter = MyRecycleViewAdapter(items)
                    list.adapter = myAdapter

                //}
            }, {
//                {
//                Toast.makeText(this, "Error $it", Toast.LENGTH_LONG).show()
                Log.d("TAG", "Error $it")
            }
            )
        list.layoutManager = LinearLayoutManager(requireContext())
    }
}

data class SuperHero(
    var id: Int = 0,
    var name: String = "",
    var slug: String = "",
    var powerstats: PowerStats,
    var appearance: Appearance,
    var biography: Biography,
    var work: Work,
    var connections: Connections,
    var images: Images
)

data class Appearance(
    var gender: String = "",
    var race: String = "",
    var height: List<String>,
    var weight: List<String>,
    var eyeColor: String = "",
    var hairColor: String = ""
)

data class Biography(
    var fullName: String = "",
    var alterEgos: String = "",
    var aliases: List<String>,
    var placeOfBirth: String = "",
    var firstAppearance: String = "",
    var publisher: String = "",
    var alignment: String = ""
)

data class Connections(
    var groupAffiliation: String = "",
    var relatives: String = ""
)

data class Images(
    var xs: String = "",
    var sm: String = "",
    var md: String = "",
    var lg: String = ""
)

data class PowerStats(
    var intelligence: Int = 0,
    var strength: Int = 0,
    var speed: Int = 0,
    var durability: Int = 0,
    var power: Int = 0,
    var combat: Int = 0
)

data class Work(
    var occupation: String = "",
    var base: String = ""
)