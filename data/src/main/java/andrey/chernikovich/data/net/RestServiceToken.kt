package andrey.chernikovich.data.net

import andrey.chernikovich.data.entity.ItemResponse
import andrey.chernikovich.data.entity.TokenResponse
import io.reactivex.Observable

class RestServiceToken(apiUrl: String) : BaseRestService(apiUrl) {

    fun getTokenEu(): Observable<TokenResponse> {
        return restApi.getTokenEu()
    }

    fun getTokenUs(): Observable<TokenResponse> {
        return restApi.getTokenUs()
    }


}