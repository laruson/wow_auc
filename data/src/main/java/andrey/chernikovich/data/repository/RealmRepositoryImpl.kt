package andrey.chernikovich.data.repository

import andrey.chernikovich.data.db.dao.RealmDao
import andrey.chernikovich.data.net.entity.mapper.transformToDb
import andrey.chernikovich.data.net.entity.mapper.transformToDomain
import andrey.chernikovich.data.net.rest.service.RestServiceRealm
import andrey.chernikovich.domain.entity.Realm
import andrey.chernikovich.domain.repository.RealmRepository
import andrey.chernikovich.domain.sharedpref.SharedPref
import io.reactivex.Flowable

class RealmRepositoryImpl(private val restService: RestServiceRealm,
                          private val realmDao: RealmDao,
                          private val shared: SharedPref) : RealmRepository {

    override fun getRealms(): Flowable<List<Realm>> {

        return restService.getRealm(shared.getNameSpace()!!, shared.getLocale()!!, shared.getAccessToken()!!)
                .doOnNext {
                    it.realms.map {
                        realmDao.insert(it.transformToDb())
                    }
                }
                .map {
                    it.realms.map {
                        it.transformToDomain()
                    }
                }
    }
}