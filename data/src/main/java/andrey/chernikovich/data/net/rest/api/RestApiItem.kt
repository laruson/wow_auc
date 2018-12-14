package andrey.chernikovich.data.net.rest.api

import andrey.chernikovich.data.net.entity.item.ItemResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface RestApiItem {
    //    http://api.tradeskillmaster.com/v1/item/EU/aegwynn/33470?format=json&apiKey=hAkf3v5YsC1w9DuEmnSQRRAAVetuR-qb

    @Headers("Content-Type:application/json")
    @GET("/v1/item/EU/aegwynn/{id}?format=json&apiKey=hAkf3v5YsC1w9DuEmnSQRRAAVetuR-qb")
    fun getItemById(@Path("id") id:String): Observable<ItemResponse>

}