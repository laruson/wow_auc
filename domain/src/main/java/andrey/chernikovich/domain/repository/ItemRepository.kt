package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.item.BaseItem
import andrey.chernikovich.domain.entity.item.Item
import andrey.chernikovich.domain.entity.item.ItemSearch
import io.reactivex.Flowable
import io.reactivex.Observable

interface ItemRepository : BaseRepository {

    fun saveItems(items: List<BaseItem>)

    fun getItems(): Flowable<List<BaseItem>>

    fun getItems(count:Int): Flowable<List<BaseItem>>

    fun search(search: ItemSearch): Flowable<List<BaseItem>>

    fun getItemById(id:String):Observable<Item>
}