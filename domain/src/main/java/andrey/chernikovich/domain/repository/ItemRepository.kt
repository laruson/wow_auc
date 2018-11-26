package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.entity.Item
import andrey.chernikovich.domain.entity.ItemSearch
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

interface ItemRepository : BaseRepository {

    fun getItems(): Flowable<List<BaseItem>>

    fun getItems(count:Int): Flowable<List<BaseItem>>

    fun search(search: ItemSearch): Flowable<List<BaseItem>>

    fun getItemById(id:String):Observable<Item>
}