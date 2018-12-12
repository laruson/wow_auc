package andrey.chernikovich.data.net.rest.service.base

import andrey.chernikovich.data.net.rest.api.RestApiItem
import andrey.chernikovich.data.net.rest.api.RestApiRealm
import andrey.chernikovich.data.net.rest.api.RestApiToken
import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseRestService(apiUrl: String) : BaseService {
    protected val restApiItem: RestApiItem
    protected val restApiRealm: RestApiRealm
    protected val restApiToken: RestApiToken
    init {
        val okHttpBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)

        okHttpBuilder.addInterceptor(HttpLoggingInterceptor())

        val gson = GsonBuilder()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(apiUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpBuilder.build())
                .build()

        Log.e("AA", apiUrl)
        restApiItem = retrofit.create(RestApiItem::class.java)
        restApiRealm = retrofit.create(RestApiRealm::class.java)
        restApiToken = retrofit.create(RestApiToken::class.java)
    }
}