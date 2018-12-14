package andrey.chernikovich.domain.usecase.item

import andrey.chernikovich.domain.entity.item.BaseItem
import andrey.chernikovich.domain.entity.item.ItemSearch
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.ItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Flowable

class SearchItemUseCase(postExecutorThread: PostExecutorThread,
                        private val itemRepository: ItemRepository) : BaseUseCase(postExecutorThread), ItemUseCase {
    fun search(search: ItemSearch): Flowable<List<BaseItem>> {
        return itemRepository.search(search)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}