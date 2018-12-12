package andrey.chernikovich.domain.usecase.group

import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.GroupItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase

class SaveGroupItemUseCase(postExecutorThread: PostExecutorThread,
                           private val groupItemRepository: GroupItemRepository) : BaseUseCase(postExecutorThread), GroupItemUseCase {
    fun saveGroupItem(item: BaseItem) {
        groupItemRepository.saveItem(item)
    }
}