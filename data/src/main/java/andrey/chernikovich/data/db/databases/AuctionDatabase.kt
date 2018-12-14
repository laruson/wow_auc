package andrey.chernikovich.data.db.databases

import andrey.chernikovich.data.db.dao.GroupItemDao
import andrey.chernikovich.data.db.dao.ItemDao
import andrey.chernikovich.data.db.dao.PetDao
import andrey.chernikovich.data.db.dao.RealmDao
import andrey.chernikovich.data.db.entity.*
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

@Database(entities = [
    ItemDB::class,
    GroupItemDb::class,
    RealmDb::class,
    PetDb::class], version = 1, exportSchema = false)
@TypeConverters(Convertor::class)
abstract class AuctionDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME: String = "auctionDatabase"

        fun getInstance(context: Context): AuctionDatabase {
            return Room
                    .databaseBuilder(context, AuctionDatabase::class.java, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }


    abstract fun itemDao(): ItemDao

    abstract fun groupItemDao(): GroupItemDao

    abstract fun realmDao(): RealmDao

    abstract fun petDao(): PetDao
}