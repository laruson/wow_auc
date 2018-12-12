package andrey.chernikovich.data.repository

import andrey.chernikovich.data.db.assets.items
import andrey.chernikovich.data.db.dao.ItemDao
import andrey.chernikovich.data.db.entity.mapper.transformToBaseItem
import andrey.chernikovich.data.db.entity.mapper.transformToItemDb
import andrey.chernikovich.data.net.entity.mapper.transformToDomain
import andrey.chernikovich.data.net.rest.service.RestServiceItem
import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.entity.Item
import andrey.chernikovich.domain.entity.ItemSearch
import andrey.chernikovich.domain.repository.ItemRepository
import io.reactivex.Flowable
import io.reactivex.Observable

class ItemRepositoryImpl(private val restService: RestServiceItem,
                         private val itemDao: ItemDao) : ItemRepository {

    override fun saveItems(items: List<BaseItem>) {
        itemDao.insert(items.map {
            it.transformToItemDb()
        })
    }

    override fun getItemById(id: String): Observable<Item> {
        return restService.getItemById(id).map { ItemResponse ->
            ItemResponse.transformToDomain()
        }
    }

    override fun getItems(): Flowable<List<BaseItem>> {
        return itemDao.getItems().map { list ->
            if(list.isEmpty()){
                itemDao.insert(items)
            }
            list.map { itemDB ->
                itemDB.transformToBaseItem()
            }


        }
    }

    override fun getItems(count: Int): Flowable<List<BaseItem>> {
        return itemDao.getItems(count).map { list ->
            list.map { itemDB ->
                itemDB.transformToBaseItem()
            }
        }
    }

    override fun search(search: ItemSearch): Flowable<List<BaseItem>> {
        return itemDao.searchItem(search.name).map { list ->
            list.map { itemDB ->
                itemDB.transformToBaseItem()
            }
        }
    }
}