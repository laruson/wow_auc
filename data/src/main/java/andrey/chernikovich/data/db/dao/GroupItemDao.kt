package andrey.chernikovich.data.db.dao

import andrey.chernikovich.data.db.entity.GroupItemDb
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface GroupItemDao {
    @Insert
    fun save(item: GroupItemDb)

    @Query("SELECT * FROM groupItems")
    fun getItems():Flowable<List<GroupItemDb>>
}