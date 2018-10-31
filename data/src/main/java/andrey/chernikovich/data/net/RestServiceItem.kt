package andrey.chernikovich.data.net

import andrey.chernikovich.data.entity.BaseItemResponse
import android.util.Log
import com.google.gson.Gson
import io.reactivex.Observable
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class RestServiceItem(apiUrl: String) : BaseRestService(apiUrl) {

    fun getItems(): Observable<List<BaseItemResponse>> {
        return restApi.getItems()
    }

}