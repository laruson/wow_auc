package andrey.chernikovich.data.db.dao

import andrey.chernikovich.data.db.entity.ItemDB
import andrey.chernikovich.data.db.entity.PetDb
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface PetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pet: PetDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pets: List<PetDb>)

    @Query("SELECT * FROM pets")
    fun getPets(): Flowable<List<PetDb>>

    @Query("SELECT * FROM pets LIMIT :count")
    fun getPets(count: Int): Flowable<List<PetDb>>

    @Query("SELECT * FROM pets WHERE name LIKE :search || '%' LIMIT 100")
    fun searchPet(search: String): Flowable<List<PetDb>>
}