package andrey.chernikovich.domain.usecase.group

import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.GroupItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import andrey.chernikovich.domain.usecase.item.ItemUseCase
import io.reactivex.Flowable

class GetGroupItemUseCase (postExecutorThread: PostExecutorThread,
                           private val groupItemRepository: GroupItemRepository) : BaseUseCase(postExecutorThread), GroupItemUseCase {
    fun getGroupItems(): Flowable<List<BaseItem>> {
        return groupItemRepository.getItems().take(1)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}