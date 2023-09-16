package com.example.task_17_hometask_fragment

import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("/superhero-api/api/all.json") //
    //fun getSuperHero(): Single<SuperHeroResponse>
    fun getSuperHero(): Single<List<SuperHero>>


}