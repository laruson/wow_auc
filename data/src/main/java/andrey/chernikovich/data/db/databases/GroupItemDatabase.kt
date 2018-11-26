package andrey.chernikovich.data.db.databases

import andrey.chernikovich.data.db.dao.GroupItemDao
import andrey.chernikovich.data.db.entity.GroupItemDb
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [GroupItemDb::class], version = 1)
abstract class GroupItemDatabase : RoomDatabase() {
    abstract fun groupItemDao(): GroupItemDao

    companion object {
        const val DATABASE_NAME: String = "groupItemsDatabase"

        fun getInstance(context: Context): GroupItemDatabase {
            return Room
                    .databaseBuilder(context, GroupItemDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
}