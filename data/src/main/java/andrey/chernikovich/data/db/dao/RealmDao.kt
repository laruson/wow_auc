package andrey.chernikovich.data.db.dao

import andrey.chernikovich.data.db.entity.RealmDb
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface RealmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(realms: List<RealmDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg realm: RealmDb)

    @Query("SELECT * FROM realms WHERE name LIKE :search || '%' LIMIT 10")
    fun search(search: String) : Flowable<List<RealmDb>>

    @Query("SELECT * FROM realms WHERE id=:id")
    fun getById(id:Int): Flowable<RealmDb>

    @Query("SELECT * FROM realms")
    fun getRealms(): Flowable<List<RealmDb>>
}