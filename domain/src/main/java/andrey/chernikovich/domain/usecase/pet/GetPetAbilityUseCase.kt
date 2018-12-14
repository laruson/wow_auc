package andrey.chernikovich.domain.usecase.pet

import andrey.chernikovich.domain.entity.pet.PetAbility
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.PetRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Observable

class GetPetAbilityUseCase(postExecutorThread: PostExecutorThread,
                           private val petRepository: PetRepository) : BaseUseCase(postExecutorThread), PetUseCase {
    fun getPetAbility(abilityId: Int): Observable<PetAbility> {
        return petRepository.getPetAbilityInfo(abilityId)
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}