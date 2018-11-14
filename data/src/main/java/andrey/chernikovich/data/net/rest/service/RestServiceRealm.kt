package andrey.chernikovich.data.net.rest.service

import andrey.chernikovich.data.net.entity.RealmResponse
import andrey.chernikovich.data.net.rest.service.base.BaseRestService
import io.reactivex.Flowable
import io.reactivex.Observable

class RestServiceRealm(apiUrl: String) : BaseRestService(apiUrl)  {
    fun getRealmEu(): Flowable<List<RealmResponse>> {
        return restApiRealm.getRealmEu()
    }

    fun getRealmEu(slug:String): Observable<RealmResponse> {
        return restApiRealm.getRealmEu(slug)
    }

    fun getRealmUs(): Flowable<List<RealmResponse>> {
        return restApiRealm.getRealmUs()
    }

    fun getRealmUs(slug:String): Observable<RealmResponse>{
        return restApiRealm.getRealmUs(slug)
    }
}