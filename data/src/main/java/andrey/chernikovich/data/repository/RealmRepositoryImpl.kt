package andrey.chernikovich.data.repository

import andrey.chernikovich.data.db.dao.RealmDao
import andrey.chernikovich.data.db.entity.mapper.transformToDomain
import andrey.chernikovich.data.net.entity.mapper.transformToDb
import andrey.chernikovich.data.net.entity.mapper.transformToDomain
import andrey.chernikovich.data.net.rest.service.RestServiceRealm
import andrey.chernikovich.data.sharedpref.ACCESS_TOKEN
import andrey.chernikovich.data.sharedpref.LOCALE
import andrey.chernikovich.data.sharedpref.NAMESPACE
import andrey.chernikovich.domain.entity.realm.Realm
import andrey.chernikovich.domain.repository.RealmRepository
import andrey.chernikovich.domain.sharedpref.SharedPref
import io.reactivex.Flowable
import io.reactivex.rxkotlin.subscribeBy

class RealmRepositoryImpl(private val restService: RestServiceRealm,
                          private val dao: RealmDao,
                          private val shared: SharedPref) : RealmRepository {

    override fun getRealms(): Flowable<List<Realm>> {


        return restService.getRealm(
                shared.getValue(NAMESPACE),
                shared.getValue(LOCALE),
                shared.getValue(ACCESS_TOKEN))
                .map {
                    it.realms.map {
                        it.transformToDomain()
                    }
                }
    }
}