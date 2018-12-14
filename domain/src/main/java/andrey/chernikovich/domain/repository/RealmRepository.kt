package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.realm.Realm
import io.reactivex.Flowable

interface RealmRepository : BaseRepository {
    fun getRealms() : Flowable<List<Realm>>
}