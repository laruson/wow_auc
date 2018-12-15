package andrey.chernikovich.domain.usecase.item

import andrey.chernikovich.domain.entity.item.BaseItem
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.ItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                                          private val itemRepository: ItemRepository) : BaseUseCase(postExecutorThread) {
    fun getItems(): Flowable<List<BaseItem>> {
        return itemRepository.getItems().take(1)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}