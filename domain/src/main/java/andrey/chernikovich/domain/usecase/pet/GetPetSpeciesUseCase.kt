package andrey.chernikovich.domain.usecase.pet

import andrey.chernikovich.domain.entity.pet.PetSpecies
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.PetRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetPetSpeciesUseCase @Inject constructor(postExecutorThread: PostExecutorThread,
                                               private val petRepository: PetRepository) : BaseUseCase(postExecutorThread), PetUseCase {
    fun getPetSpecies(speciesId: String): Observable<PetSpecies> {
        return petRepository.getPetSpecies(speciesId)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}