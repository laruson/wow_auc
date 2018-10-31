package andrey.chernikovich.data.repository

import andrey.chernikovich.data.entity.BaseItemResponse
import android.util.Log
import com.google.gson.Gson
import io.reactivex.Observable
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class AllItemsRepository {
    private val src = "https://raw.githubusercontent.com/laruson/wow_auc/master/items.txt"

    fun getAllItems(): Observable<ArrayList<BaseItemResponse>>{
        val url = URL(src)
        val connect = url.openConnection() as HttpURLConnection

        val list = ArrayList<BaseItemResponse>()
        try {
            connect.requestMethod = "GET";
            connect.connect()
            val reader = BufferedReader(InputStreamReader(connect.inputStream))
            val gson = Gson()
            list.add(gson.fromJson(reader, BaseItemResponse::class.java))
            reader.close()

        } finally {
            connect.disconnect()

        }
        return Observable.just(list)
    }
}