package andrey.chernikovich.data.repository

import andrey.chernikovich.data.entity.transformToDomain
import andrey.chernikovich.data.net.RestService
import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.entity.Item
import andrey.chernikovich.domain.entity.ItemSearch
import andrey.chernikovich.domain.repository.ItemRepository
import io.reactivex.Completable
import io.reactivex.Observable

class ItemRepositoryImpl : ItemRepository {

    override fun getItems(): Observable<List<BaseItem>> {
        val allItem = AllItemsRepository().getAllItems()
        val listItem = allItem.map { baseItemList ->
            baseItemList.map { baseItem ->
                baseItem.transformToDomain()
            }
        }
        return listItem

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