package andrey.chernikovich.data.net.rest.service

import andrey.chernikovich.data.net.entity.token.TokenResponse
import andrey.chernikovich.data.net.rest.service.base.BaseRestService
import io.reactivex.Observable

class RestServiceToken(apiUrl: String) : BaseRestService(apiUrl) {
    fun getToken(namespace: String,
                 locale: String,
                 access_token: String): Observable<TokenResponse> {
        return restApiToken.getToken(namespace, locale, access_token)
    }
}