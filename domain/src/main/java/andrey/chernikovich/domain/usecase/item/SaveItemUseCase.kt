package andrey.chernikovich.domain.usecase.item

import andrey.chernikovich.domain.entity.item.BaseItem
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.ItemRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import javax.inject.Inject

class SaveItemUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                                          private val itemRepository: ItemRepository) : BaseUseCase(postExecutorThread), ItemUseCase {
    fun saveItem(item: List<BaseItem>){
        itemRepository.saveItems(item)
    }
}