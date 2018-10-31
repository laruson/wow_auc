package andrey.chernikovich.data.net

import andrey.chernikovich.data.entity.ItemResponse
import andrey.chernikovich.data.entity.TokenResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestApi {

    @GET("/{id}?format=json&apiKey=hAkf3v5YsC1w9DuEmnSQRRAAVetuR-qb")
    fun getItemById(@Path("id") id: String): Observable<ItemResponse>

    //  https://eu.api.battle.net/data/wow/token/?namespace=dynamic-eu&locale=en_GB&access_token=tcnryg8fyvwqngza5m4b4xyc
    @GET("/data/wow/token/?namespace=dynamic-eu&locale=en_GB&access_token=tcnryg8fyvwqngza5m4b4xyc")
    fun getTokenEu(): Observable<TokenResponse>

    //    https://us.api.battle.net/data/wow/token/?namespace=dynamic-us&locale=en_US&access_token=tcnryg8fyvwqngza5m4b4xyc
    @GET("/data/wow/token/?namespace=dynamic-us&locale=en_US&access_token=tcnryg8fyvwqngza5m4b4xyc")
    fun getTokenUs(): Observable<TokenResponse>
}