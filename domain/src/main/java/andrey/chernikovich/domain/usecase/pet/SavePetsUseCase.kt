package andrey.chernikovich.domain.usecase.pet

import andrey.chernikovich.domain.entity.pet.Pet
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.PetRepository
import andrey.chernikovich.domain.usecase.BaseUseCase

class SavePetsUseCase(postExecutorThread: PostExecutorThread,
                      private val petRepository: PetRepository) : BaseUseCase(postExecutorThread), PetUseCase {
    fun savePets(pet: Pet){
        return petRepository.savePets(pet)
    }
}