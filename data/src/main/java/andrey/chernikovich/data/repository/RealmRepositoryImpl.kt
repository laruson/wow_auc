package andrey.chernikovich.data.repository

import andrey.chernikovich.data.db.dao.RealmDao
import andrey.chernikovich.data.db.entity.mapper.transformtoDomain
import andrey.chernikovich.data.net.entity.mapper.transformToDomain
import andrey.chernikovich.data.net.rest.service.RestServiceRealm
import andrey.chernikovich.domain.entity.Realm
import andrey.chernikovich.domain.repository.RealmRepository
import io.reactivex.Flowable
import io.reactivex.Observable

class RealmRepositoryImpl(private val restService: RestServiceRealm,
                          private val realmDao: RealmDao) : RealmRepository {
    override fun getRealmById(id: Int): Flowable<Realm> {
        return realmDao.getById(id).map { RealmDb ->
            RealmDb.transformtoDomain()
        }
    }

    override fun getRealmsEu(): Flowable<List<Realm>> {
        return restService.getRealmEu().map { list ->
            list.map { realmResponse ->
                realmResponse.transformToDomain()
            }
        }
    }

    override fun getRealmsBySlugEu(slug: String): Observable<Realm> {
        return restService.getRealmEu(slug).map { realmResponse ->
            realmResponse.transformToDomain()
        }
    }

    override fun getRealmsUs(): Flowable<List<Realm>> {
        return restService.getRealmUs().map { list ->
            list.map { realmResponse ->
                realmResponse.transformToDomain()
            }
        }
    }

    override fun getRealmsBySlugUs(slug: String): Observable<Realm> {
        return restService.getRealmUs(slug).map { realmResponse ->
            realmResponse.transformToDomain()
        }
    }
}