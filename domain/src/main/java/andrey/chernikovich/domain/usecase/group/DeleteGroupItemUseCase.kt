package andrey.chernikovich.domain.usecase.group

import andrey.chernikovich.domain.entity.item.BaseItem
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.GroupItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import javax.inject.Inject

class DeleteGroupItemUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                              private val groupItemRepository: GroupItemRepository) : BaseUseCase(postExecutorThread), GroupItemUseCase {
    fun deleteItem(item: BaseItem){
        return groupItemRepository.deleteItem(item)
    }
}