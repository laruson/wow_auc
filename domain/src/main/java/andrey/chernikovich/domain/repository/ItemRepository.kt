package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.entity.Item
import andrey.chernikovich.domain.entity.ItemSearch
import io.reactivex.Completable
import io.reactivex.Observable

interface ItemRepository : BaseRepository {

    fun getItems(): Observable<List<BaseItem>>

    fun search(search: ItemSearch): Observable<List<BaseItem>>

}