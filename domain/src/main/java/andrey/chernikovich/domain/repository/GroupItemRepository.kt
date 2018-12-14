package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.item.BaseItem
import io.reactivex.Flowable

interface GroupItemRepository : BaseRepository {

    fun saveItem(item: BaseItem)

    fun getItems():Flowable<List<BaseItem>>

    fun deleteItem(item: BaseItem)
}