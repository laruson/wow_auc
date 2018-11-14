package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.Realm
import io.reactivex.Flowable
import io.reactivex.Observable

interface RealmRepository : BaseRepository {
    fun getRealmsEu() : Flowable<List<Realm>>

    fun getRealmsBySlugEu(slug:String) : Observable<Realm>

    fun getRealmsUs() : Flowable<List<Realm>>

    fun getRealmsBySlugUs(slug:String) : Observable<Realm>

    fun getRealmById(id:Int) : Flowable<Realm>
}