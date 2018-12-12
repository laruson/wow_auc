package andrey.chernikovich.data.db.dao

import andrey.chernikovich.data.db.entity.ItemDB
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface ItemDao {
    @Query("SELECT * FROM loadItems")
    fun getSaveItems(): Flowable<List<ItemDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(items: List<ItemDB>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(items: ItemDB)

    @Query("SELECT * FROM loadItems LIMIT 100")
    fun getItems(): Flowable<List<ItemDB>>

    @Query("SELECT * FROM loadItems LIMIT :count")
    fun getItems(count: Int): Flowable<List<ItemDB>>

    @Query("SELECT * FROM loadItems WHERE name LIKE :search || '%' LIMIT 100")
    fun searchItem(search: String): Flowable<List<ItemDB>>

    @Query("DELETE FROM loadItems")
    fun deleteAll()

    @Query("SELECT * FROM loadItems WHERE id=:id LIMIT 1")
    fun getById(id: Int): ItemDB

    @Query("SELECT COUNT(*) FROM loadItems")
    fun sizeDb(): Int

}