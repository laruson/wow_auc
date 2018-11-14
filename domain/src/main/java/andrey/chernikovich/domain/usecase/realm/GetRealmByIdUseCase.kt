package andrey.chernikovich.domain.usecase.realm

import andrey.chernikovich.domain.entity.Realm
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.RealmRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Flowable

class GetRealmByIdUseCase (postExecutorThread: PostExecutorThread,
                           private val realmRepository: RealmRepository) : BaseUseCase(postExecutorThread), RealmUseCase {

    fun getRealmById(id:Int): Flowable<Realm> {
        return realmRepository.getRealmById(id)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}