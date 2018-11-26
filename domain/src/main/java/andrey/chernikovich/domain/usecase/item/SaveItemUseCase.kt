package andrey.chernikovich.domain.usecase.item

import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.GroupItemRepository
import andrey.chernikovich.domain.repository.ItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Completable

class SaveItemUseCase(postExecutorThread: PostExecutorThread,
                      private val groupItemRepository: GroupItemRepository) : BaseUseCase(postExecutorThread), ItemUseCase {
    fun saveItem(item: BaseItem){
        groupItemRepository.saveItem(item)
//                .observeOn(postExecutorThread)
//                .subscribeOn(workExecutorThread)
    }
}