package andrey.chernikovich.domain.usecase.item

import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.ItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Flowable

class GetItemsUseCase(postExecutorThread: PostExecutorThread,
                      private val itemRepository: ItemRepository) : BaseUseCase(postExecutorThread), ItemUseCase {
    fun getItems(): Flowable<List<BaseItem>> {
        return itemRepository.getItems()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }

    fun getItems(count:Int): Flowable<List<BaseItem>> {
        return itemRepository.getItems(count)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}