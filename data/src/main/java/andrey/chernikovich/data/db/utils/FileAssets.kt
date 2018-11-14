package andrey.chernikovich.data.db.utils

import andrey.chernikovich.data.db.entity.ItemDB
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import java.util.concurrent.Executors
import kotlin.collections.ArrayList

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()
val items = Collections.synchronizedList(ArrayList<ItemDB>())
val alphabet = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0')
fun ioThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}

fun items(context: Context) {
    ioThread {
        val gson = Gson()
        val reader = BufferedReader(InputStreamReader(context.assets.open("items")))
        var line = reader.readLine()

        while (line != null) {
            val item = gson.fromJson(line, ItemDB::class.java)

            items.add(item)
            line = reader.readLine()
        }
        Log.e("AA", "complite")

        reader.close()

    }
}