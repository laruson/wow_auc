package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.Item
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.ItemRepository
import io.reactivex.Completable

//class AddItemUseCase (postExecutorThread : PostExecutorThread,
//                      private val itemRepository: ItemRepository) : BaseUseCase(postExecutorThread) {
//    fun update(item: Item) : Completable {
//        return itemRepository.update(item)
//    }
//}