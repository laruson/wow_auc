package andrey.chernikovich.domain.usecase.group

import andrey.chernikovich.domain.entity.item.BaseItem
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.GroupItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class GetGroupItemUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                                              private val groupItemRepository: GroupItemRepository) : BaseUseCase(postExecutorThread), GroupItemUseCase {
    fun getGroupItems(): Flowable<List<BaseItem>> {
        return groupItemRepository.getItems().take(1)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}