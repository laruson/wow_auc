package andrey.chernikovich.data.net.rest.api

import andrey.chernikovich.data.net.entity.TokenResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface RestApiToken {
    //  https://eu.api.battle.net/data/wow/token/?namespace=dynamic-eu&locale=en_GB&access_token=tcnryg8fyvwqngza5m4b4xyc
    @GET("/data/wow/token/?namespace=dynamic-eu&locale=en_GB&access_token=tcnryg8fyvwqngza5m4b4xyc")
    fun getTokenEu(): Observable<TokenResponse>

    //    https://us.api.battle.net/data/wow/token/?namespace=dynamic-us&locale=en_US&access_token=tcnryg8fyvwqngza5m4b4xyc
    @GET("/data/wow/token/?namespace=dynamic-us&locale=en_US&access_token=tcnryg8fyvwqngza5m4b4xyc")
    fun getTokenUs(): Observable<TokenResponse>
}