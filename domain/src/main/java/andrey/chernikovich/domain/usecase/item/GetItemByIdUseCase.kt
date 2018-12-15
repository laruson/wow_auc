package andrey.chernikovich.domain.usecase.item

import andrey.chernikovich.domain.entity.item.Item
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.ItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetItemByIdUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                                             private val itemRepository: ItemRepository) : BaseUseCase(postExecutorThread), ItemUseCase {
    fun getItemById(id: String): Observable<Item> {
        return itemRepository.getItemById(id)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}