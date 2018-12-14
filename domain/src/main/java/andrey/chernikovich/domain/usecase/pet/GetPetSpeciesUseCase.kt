package andrey.chernikovich.domain.usecase.pet

import andrey.chernikovich.domain.entity.pet.PetSpecies
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.PetRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Observable

class GetPetSpeciesUseCase(postExecutorThread: PostExecutorThread,
                           private val petRepository: PetRepository) : BaseUseCase(postExecutorThread), PetUseCase {
    fun getPetAbility(speciesId: Int): Observable<PetSpecies> {
        return petRepository.getPetSpecies(speciesId)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}