package pe.edu.cibertec.t2.retrofit.api

import pe.edu.cibertec.t2.retrofit.response.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET

interface IRecipeService {
    @GET("recipes")
    fun obtenerRecetas(): Call<RecipeResponse>
}