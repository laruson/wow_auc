package andrey.chernikovich.domain.usecase.realm

import andrey.chernikovich.domain.entity.realm.Realm
import io.reactivex.Flowable

interface RealmUseCase {
    fun getRealms(): Flowable<List<Realm>>
}