package andrey.chernikovich.domain.usecase.pet

import andrey.chernikovich.domain.entity.pet.Pet
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.PetRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

class GetPetsUseCase(postExecutorThread: PostExecutorThread,
                     private val petRepository: PetRepository) : BaseUseCase(postExecutorThread), PetUseCase {
    fun getPetsRest(): Flowable<List<Pet>> {
        return petRepository.getPetsRest()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }

    fun getPetsDao():Flowable<List<Pet>>{
        return petRepository.getPetsDao()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}