package andrey.chernikovich.data.repository

import andrey.chernikovich.data.db.dao.GroupItemDao
import andrey.chernikovich.data.db.entity.mapper.transformToGroupItemDb
import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.repository.GroupItemRepository
import io.reactivex.Flowable

class GroupItemRepositoryImpl(private val itemDao: GroupItemDao) : GroupItemRepository {

    override fun deleteItem(item: BaseItem) {
        itemDao.deleteItem(item.transformToGroupItemDb())
    }

    override fun saveItem(item: BaseItem) {
        itemDao.save(item.transformToGroupItemDb())
    }

    override fun getItems(): Flowable<List<BaseItem>> {
        return itemDao.getItems().map { list ->
            list.map {
                it.transformToGroupItemDb()
            }
        }
    }
}