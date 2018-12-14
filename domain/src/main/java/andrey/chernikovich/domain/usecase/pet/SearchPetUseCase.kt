package andrey.chernikovich.domain.usecase.pet

import andrey.chernikovich.domain.entity.pet.Pet
import andrey.chernikovich.domain.entity.pet.SearchPet
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.PetRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Flowable

class SearchPetUseCase(postExecutorThread: PostExecutorThread,
                       private val petRepository: PetRepository) : BaseUseCase(postExecutorThread), PetUseCase {
    fun searchPets(searchPet: SearchPet): Flowable<List<Pet>> {
        return petRepository.searchPet(searchPet)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}