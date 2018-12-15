package andrey.chernikovich.data.repository

import andrey.chernikovich.data.db.dao.GroupItemDao
import andrey.chernikovich.data.db.entity.mapper.transformToGroupItemDb
import andrey.chernikovich.domain.entity.item.BaseItem
import andrey.chernikovich.domain.repository.GroupItemRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GroupItemRepositoryImpl @Inject constructor(private val dao: GroupItemDao) : GroupItemRepository {

    override fun deleteItem(item: BaseItem) {
        dao.deleteItem(item.transformToGroupItemDb())
    }

    override fun saveItem(item: BaseItem) {
        dao.save(item.transformToGroupItemDb())
    }

    override fun getItems(): Flowable<List<BaseItem>> {
        return dao.getItems().map { list ->
            list.map {
                it.transformToGroupItemDb()
            }
        }
    }
}