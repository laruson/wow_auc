package andrey.chernikovich.data.net.rest.api

import andrey.chernikovich.data.net.entity.ItemResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApiItem{

    @GET("/{id}?format=json&apiKey=hAkf3v5YsC1w9DuEmnSQRRAAVetuR-qb")
    fun getItemById(@Path("id") id: Int): Observable<ItemResponse>

}