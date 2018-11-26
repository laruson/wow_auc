package andrey.chernikovich.data.db.databases

import andrey.chernikovich.data.db.dao.ItemDao
import andrey.chernikovich.data.db.entity.ItemDB
import android.arch.persistence.room.*
import android.content.Context

@Database(entities = [ItemDB::class], version = 2)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        const val DATABASE_NAME: String = "itemsDatabase"

        fun getInstance(context: Context): ItemDatabase {
            return Room
                   .databaseBuilder(context, ItemDatabase::class.java, DATABASE_NAME)
                   .allowMainThreadQueries()
                   .fallbackToDestructiveMigration()
                   .build()
        }
    }


}