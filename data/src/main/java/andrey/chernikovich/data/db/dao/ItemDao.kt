package andrey.chernikovich.data.db.dao

import andrey.chernikovich.data.db.entity.ItemDB
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
interface ItemDao {
    @Insert
    fun insert(vararg item: ItemDB)

    @Insert
    fun insert(items: List<ItemDB>)

    @Query("SELECT * FROM items")
    fun getItems(): Flowable<List<ItemDB>>

    @Query("SELECT * FROM items LIMIT :count")
    fun getItems(count: Int): Flowable<List<ItemDB>>

    @Query("SELECT * FROM items WHERE name LIKE :search || '%'")
    fun searchItem(search: String): Flowable<List<ItemDB>>

    @Query("DELETE FROM items")
    fun deleteAll()

    @Query("SELECT * FROM items WHERE id=:id LIMIT 1")
    fun getById(id: Int): ItemDB

    @Query("SELECT COUNT(*) FROM items")
    fun sizeDb(): Int

}