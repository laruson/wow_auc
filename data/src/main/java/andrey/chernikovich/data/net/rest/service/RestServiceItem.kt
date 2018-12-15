package andrey.chernikovich.data.net.rest.service

import andrey.chernikovich.data.net.entity.item.ItemResponse
import andrey.chernikovich.data.net.rest.service.base.BaseRestService
import io.reactivex.Observable
import javax.inject.Inject

class RestServiceItem @Inject constructor(apiUrl: String) : BaseRestService(apiUrl) {

    fun getItemById(id:String):Observable<ItemResponse>{
        return restApiItem.getItemById(id)
    }
}