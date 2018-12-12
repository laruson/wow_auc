package andrey.chernikovich.data.db.dao

import andrey.chernikovich.data.db.entity.GroupItemDb
import android.arch.persistence.room.*
import io.reactivex.Flowable

@Dao
interface GroupItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(item: GroupItemDb)

    @Query("SELECT * FROM groupItems")
    fun getItems():Flowable<List<GroupItemDb>>

    @Delete
    fun deleteItem(item:GroupItemDb)
}