package andrey.chernikovich.domain.usecase.item

import andrey.chernikovich.domain.entity.Item
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.ItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Observable

class GetItemByIdUseCase(postExecutorThread: PostExecutorThread,
                         private val itemRepository: ItemRepository) : BaseUseCase(postExecutorThread), ItemUseCase {
    fun getItemById(id: Int): Observable<Item> {
        return itemRepository.getItemById(id)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}