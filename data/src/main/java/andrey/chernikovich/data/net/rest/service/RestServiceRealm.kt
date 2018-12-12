package andrey.chernikovich.data.net.rest.service

import andrey.chernikovich.data.net.entity.RealmResponse
import andrey.chernikovich.data.net.entity.RealmsResponse
import andrey.chernikovich.data.net.rest.service.base.BaseRestService
import io.reactivex.Flowable

class RestServiceRealm(apiUrl: String) : BaseRestService(apiUrl) {
    fun getRealm(namespace: String,
                 locale: String,
                 access_token: String): Flowable<RealmsResponse> {
        return restApiRealm.getRealm(namespace, locale, access_token)
    }


}