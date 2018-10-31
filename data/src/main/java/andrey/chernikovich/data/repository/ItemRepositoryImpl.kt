package andrey.chernikovich.data.repository

import andrey.chernikovich.data.entity.transformToDomain
import andrey.chernikovich.data.net.RestServiceItem
import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.entity.ItemSearch
import andrey.chernikovich.domain.repository.ItemRepository
import android.util.Log
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

class ItemRepositoryImpl(private val restService: RestServiceItem) : ItemRepository {

    override fun getItems(): Observable<List<BaseItem>> {

        return restService.getItems().map {
            it.map {
                it.transformToDomain()
            }
        }


    }

    override fun search(search: ItemSearch): Observable<List<BaseItem>> {
        val searchList = ArrayList<BaseItem>()
        getItems().map { list ->
            list.map { item ->
                if (item.name.toLowerCase().contains(search.name.toLowerCase()))
                    searchList.add(item)
            }
        }
        return Observable.just(searchList)
    }
}