package com.example.task_17_hometask_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

//class DetailsFragment(private val itemHero:SuperHero): Fragment() {
class DetailsFragment(): Fragment() {

    private var itemHero:SuperHero? = null
    private var img: ImageView? = null
    private var tvName: TextView? = null
    private var tvFullName: TextView? = null
    private var tvGender: TextView? = null
    private var tvSlug: TextView? = null
    private var tvPlaceOfBirth: TextView? = null
    private var tvStrength: TextView? = null
    private var tvSpeed: TextView? = null
    private var tvPower: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
             img = view.findViewById(R.id.imageView)
            tvName = view.findViewById(R.id.tvName)
            tvFullName = view.findViewById(R.id.tvFullName)
            tvSlug = view.findViewById(R.id.tvSlug)
            tvGender = view.findViewById(R.id.tvGender)
            tvPlaceOfBirth = view.findViewById(R.id.tvPlaceOfBirth)
            tvStrength = view.findViewById(R.id.tvStrength)
            tvSpeed = view.findViewById(R.id.tvSpeed)
            tvPower = view.findViewById(R.id.tvPower)

            Glide.with(view)
                .load(itemHero?.images?.lg)
                .into(view.findViewById(R.id.imageView))
            tvName?.text = itemHero?.name
            tvFullName?.text = itemHero?.biography?.fullName
            tvSlug?.text = itemHero?.slug
            tvGender?.text = itemHero?.appearance?.gender
            tvPlaceOfBirth?.text = itemHero?.biography?.placeOfBirth
            tvStrength?.text = itemHero?.powerstats?.strength.toString()
            tvSpeed?.text = itemHero?.powerstats?.speed.toString()
            tvPower?.text = itemHero?.powerstats?.power.toString()
  }

    fun setSuperHero(newHero:SuperHero):Unit{
        itemHero = newHero
    }

    fun show() {
        Glide.with(this)
            .load(itemHero?.images?.lg)
            .into(this.img!!)
        tvName?.text = itemHero?.name
        tvFullName?.text = itemHero?.biography?.fullName
        tvSlug?.text = itemHero?.slug
        tvGender?.text = itemHero?.appearance?.gender
        tvPlaceOfBirth?.text = itemHero?.biography?.placeOfBirth
        tvStrength?.text = itemHero?.powerstats?.strength.toString()
        tvSpeed?.text = itemHero?.powerstats?.speed.toString()
        tvSpeed?.text = itemHero?.powerstats?.speed.toString()
        tvPower?.text = itemHero?.powerstats?.power.toString()
    }
}