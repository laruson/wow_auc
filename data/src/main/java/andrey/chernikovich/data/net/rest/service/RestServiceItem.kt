package andrey.chernikovich.data.net.rest.service

import andrey.chernikovich.data.net.entity.ItemResponse
import andrey.chernikovich.data.net.rest.service.base.BaseRestService
import io.reactivex.Observable

class RestServiceItem(apiUrl: String) : BaseRestService(apiUrl) {

    fun getItemById(id:Int):Observable<ItemResponse>{
        return restApiItem.getItemById(id)
    }
}