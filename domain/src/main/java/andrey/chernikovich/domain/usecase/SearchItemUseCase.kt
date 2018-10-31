package andrey.chernikovich.domain.usecase

import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.entity.Item
import andrey.chernikovich.domain.entity.ItemSearch
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.ItemRepository
import io.reactivex.Observable

//class SearchItemUseCase (postExecutorThread : PostExecutorThread,
//                         private val itemRepository: ItemRepository) : BaseUseCase(postExecutorThread) {
//
//    fun search(searchStudent: ItemSearch): Observable<List<BaseItem>> {
//        return itemRepository.search(searchStudent)
//    }
//}