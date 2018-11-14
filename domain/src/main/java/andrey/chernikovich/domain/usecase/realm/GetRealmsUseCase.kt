package andrey.chernikovich.domain.usecase.realm

import andrey.chernikovich.domain.entity.Realm
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.RealmRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Flowable

class GetRealmsUseCase(postExecutorThread: PostExecutorThread,
                       private val realmRepository: RealmRepository) : BaseUseCase(postExecutorThread), RealmUseCase {

    fun getRealmsEu(slug: String): Flowable<List<Realm>> {
        return realmRepository.getRealmsEu()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }

    fun getRealmsUs(slug: String): Flowable<List<Realm>> {
        return realmRepository.getRealmsUs()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}