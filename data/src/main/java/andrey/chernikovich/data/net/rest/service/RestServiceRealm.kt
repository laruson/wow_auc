package andrey.chernikovich.data.net.rest.service

import andrey.chernikovich.data.net.entity.realm.RealmsResponse
import andrey.chernikovich.data.net.rest.service.base.BaseRestService
import android.util.Log
import io.reactivex.Flowable
import javax.inject.Inject

class RestServiceRealm @Inject constructor(apiUrl: String) : BaseRestService(apiUrl) {
    fun getRealm(namespace: String,
                 locale: String,
                 access_token: String): Flowable<RealmsResponse> {
        return restApiRealm.getRealm(namespace, locale, access_token)
    }


}