package andrey.chernikovich.domain.usecase.realm

import andrey.chernikovich.domain.entity.Realm
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.RealmRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Flowable

class GetRealmsUseCase(postExecutorThread: PostExecutorThread,
                       private val realmRepository: RealmRepository)
    : BaseUseCase(postExecutorThread), RealmUseCase {
    override fun getRealms(): Flowable<List<Realm>> {
        return realmRepository.getRealms()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}