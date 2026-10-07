package pe.edu.cibertec.t2.retrofit

import okhttp3.OkHttpClient
import pe.edu.cibertec.t2.retrofit.api.IRecipeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ClienteRetrofit {

    private var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val recipeService: IRecipeService by lazy {
        buildRetrofit().create(IRecipeService::class.java)
    }
}