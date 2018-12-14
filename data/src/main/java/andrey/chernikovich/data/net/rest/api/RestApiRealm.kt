package andrey.chernikovich.data.net.rest.api

import andrey.chernikovich.data.net.entity.realm.RealmsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApiRealm {
    //https://us.api.blizzard.com/data/wow/realm/?namespace=dynamic-us&locale=en_US&access_token=USvCWr4Qt3pHhkXRrHqv0n8puNyKYK1ItR
    @GET("/data/wow/realm/")
    fun getRealm(@Query("namespace") namespace: String,
                 @Query("locale") locale: String,
                 @Query("access_token") access_token: String): Flowable<RealmsResponse>


}