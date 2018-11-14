package andrey.chernikovich.data.net.rest.api

import andrey.chernikovich.data.net.entity.RealmResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApiRealm {

    @GET("data/wow/realm/?namespace=dynamic-eu&locale=en_GB&access_token=dx8pryjeuxpvkz48c2c2agzw")
    fun getRealmEu(): Flowable<List<RealmResponse>>

    @GET("data/wow/realm/{slug}?namespace=dynamic-eu&locale=en_GB&access_token=k9guqfp4gaevmczr7p2xthza")
    fun getRealmEu(@Path("slug") slug: String): Observable<RealmResponse>


    @GET("data/wow/realm/?namespace=dynamic-us&locale=en_US&access_token=k9guqfp4gaevmczr7p2xthza")
    fun getRealmUs(): Flowable<List<RealmResponse>>

    @GET("data/wow/realm/{slug}?namespace=dynamic-us&locale=en_US&access_token=k9guqfp4gaevmczr7p2xthza")
    fun getRealmUs(@Path("slug") slug: String): Observable<RealmResponse>


}