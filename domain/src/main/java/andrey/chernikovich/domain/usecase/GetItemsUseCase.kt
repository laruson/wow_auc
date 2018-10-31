package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.entity.Item
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.ItemRepository
import io.reactivex.Observable

class GetItemsUseCase (postExecutorThread : PostExecutorThread,
                       private val itemRepository: ItemRepository) : BaseUseCase(postExecutorThread) {
    fun getItems(): Observable<List<BaseItem>> {
        return itemRepository.getItems()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}