package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.Realm
import io.reactivex.Flowable
import io.reactivex.Observable

interface RealmRepository : BaseRepository {
    fun getRealms() : Flowable<List<Realm>>
}