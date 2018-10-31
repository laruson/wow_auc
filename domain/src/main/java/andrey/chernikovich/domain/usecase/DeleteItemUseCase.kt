package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.ItemRepository
import io.reactivex.Completable

//class DeleteItemUseCase(postExecutorThread : PostExecutorThread,
//                        private val itemRepository: ItemRepository) : BaseUseCase(postExecutorThread) {
//    fun delete(itemId : String) : Completable {
//        return itemRepository.delete(itemId)
//    }
//}