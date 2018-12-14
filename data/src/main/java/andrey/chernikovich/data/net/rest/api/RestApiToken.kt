package andrey.chernikovich.data.net.rest.api

import andrey.chernikovich.data.net.entity.token.TokenResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApiToken {

    //https://us.api.blizzard.com/data/wow/token/?namespace=dynamic-us&locale=en_US&access_token=USvCWr4Qt3pHhkXRrHqv0n8puNyKYK1ItR
    @GET("/data/wow/token/?")
    fun getToken(@Query("namespace") namespace: String,
                 @Query("locale") locale: String,
                 @Query("access_token") access_token: String):Observable<TokenResponse>
}