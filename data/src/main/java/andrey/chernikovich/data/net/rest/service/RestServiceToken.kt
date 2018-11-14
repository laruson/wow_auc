package andrey.chernikovich.data.net.rest.service

import andrey.chernikovich.data.net.entity.TokenResponse
import andrey.chernikovich.data.net.rest.service.base.BaseRestService
import io.reactivex.Observable

class RestServiceToken(apiUrl: String) : BaseRestService(apiUrl) {
    fun getTokenEu(): Observable<TokenResponse> {
        return restApiToken.getTokenEu()
    }

    fun getTokenUs(): Observable<TokenResponse> {
        return restApiToken.getTokenUs()
    }
}