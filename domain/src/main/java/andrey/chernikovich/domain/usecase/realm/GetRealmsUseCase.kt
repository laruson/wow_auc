package andrey.chernikovich.domain.usecase.realm

import andrey.chernikovich.domain.entity.realm.Realm
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.RealmRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class GetRealmsUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                                           private val realmRepository: RealmRepository)
    : BaseUseCase(postExecutorThread), RealmUseCase {
    override fun getRealms(): Flowable<List<Realm>> {
        return realmRepository.getRealms()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}