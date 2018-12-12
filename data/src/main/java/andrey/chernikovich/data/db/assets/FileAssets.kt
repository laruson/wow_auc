package andrey.chernikovich.data.db.assets

import andrey.chernikovich.data.db.entity.ItemDB
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Observable
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.concurrent.Executors

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

val items = mutableListOf<ItemDB>()
var isLoadComplite=false

fun ioThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}


fun loadItems(context: Context) : Boolean {

    ioThread {
        val gson = Gson()
        val reader = BufferedReader(InputStreamReader(context.assets.open("items.txt")))
        var line = reader.readLine()

        while (line != null) {
            val item = gson.fromJson(line, ItemDB::class.java)
            Log.e("AAA", items.size.toString())
            items.add(item)
            line = reader.readLine()
        }
        Log.e("AA", "complite")
        reader.close()
    }
    return true
}