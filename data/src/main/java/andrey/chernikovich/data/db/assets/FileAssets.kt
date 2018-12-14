package andrey.chernikovich.data.db.assets

import andrey.chernikovich.data.db.entity.ItemDB
import andrey.chernikovich.data.sharedpref.IS_LOAD_COMPLITE
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Observable
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.concurrent.Executors

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

val items = mutableListOf<ItemDB>()

fun ioThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}


fun loadItems(context: Context, sharedPreferences: SharedPreferences) : Boolean {

    ioThread {
        val gson = Gson()
        val reader = BufferedReader(InputStreamReader(context.assets.open("items")))
        var line = reader.readLine()
        sharedPreferences.edit().putBoolean(IS_LOAD_COMPLITE, false).apply()
        while (line != null) {
            val item = gson.fromJson(line, ItemDB::class.java)
            items.add(item)
            line = reader.readLine()
        }
        sharedPreferences.edit().putBoolean(IS_LOAD_COMPLITE, true).apply()
        reader.close()
    }
    return true
}