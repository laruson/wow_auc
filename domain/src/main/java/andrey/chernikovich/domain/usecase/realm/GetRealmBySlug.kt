package andrey.chernikovich.domain.usecase.realm

import andrey.chernikovich.domain.entity.Realm
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.RealmRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Observable

class GetRealmBySlug(postExecutorThread: PostExecutorThread,
                     private val realmRepository: RealmRepository) : BaseUseCase(postExecutorThread), RealmUseCase {

    fun getRealmBySlugEu(slug: String): Observable<Realm> {
        return realmRepository.getRealmsBySlugEu(slug)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }

    fun getRealmBySlugUs(slug: String): Observable<Realm> {
        return realmRepository.getRealmsBySlugUs(slug)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}