package andrey.chernikovich.data.net

import andrey.chernikovich.data.entity.ItemResponse
import andrey.chernikovich.data.entity.TokenResponse
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestService(apiUrl: String) {
    private val restApi: RestApi
    private val gson : Gson

    init {
        val okHttpBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)

        okHttpBuilder.addInterceptor(HttpLoggingInterceptor())

        gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
                .baseUrl(apiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpBuilder.build())
                .build()

        restApi = retrofit.create(RestApi::class.java)
    }

    fun getItemById(id:String):Observable<ItemResponse>{
        return restApi.getItemById(id)
    }

    fun getTokenEu():Observable<TokenResponse>{
        return restApi.getTokenEu()
    }
    fun getTokenUs():Observable<TokenResponse>{
        return restApi.getTokenUs()
    }


}