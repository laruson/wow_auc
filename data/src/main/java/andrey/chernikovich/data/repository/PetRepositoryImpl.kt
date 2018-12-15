package andrey.chernikovich.data.repository

import andrey.chernikovich.data.db.dao.PetDao
import andrey.chernikovich.data.db.entity.mapper.transformToDomain
import andrey.chernikovich.data.db.entity.mapper.transformToPetDb
import andrey.chernikovich.data.net.entity.mapper.transformToDomain
import andrey.chernikovich.data.net.entity.mapper.transformToPetDb
import andrey.chernikovich.data.net.rest.service.RestServicePet
import andrey.chernikovich.data.sharedpref.ACCESS_TOKEN
import andrey.chernikovich.data.sharedpref.LOCALE
import andrey.chernikovich.domain.entity.pet.*
import andrey.chernikovich.domain.repository.PetRepository
import andrey.chernikovich.domain.sharedpref.SharedPref
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class PetRepositoryImpl @Inject constructor(private val restService: RestServicePet,
                                            private val dao: PetDao,
                                            private val shared: SharedPref) : PetRepository {
    override fun getPetsDao(): Flowable<List<Pet>> {
        return dao.getPets().map { pets ->
            if (pets.isEmpty()) {
                restService.getPets(shared.getValue(LOCALE), shared.getValue(ACCESS_TOKEN))
                        .subscribeBy(
                                onNext = {
                                    val list = it.pets.map {
                                        it.transformToPetDb()
                                    }
                                    dao.insert(list)
                                },
                                onError = {

                                }
                        )
            }
            return@map pets.map {
                it.transformToDomain()
            }
        }
    }

    override fun searchPet(searchPet: SearchPet): Flowable<List<Pet>> {
        return dao.searchPet(searchPet.name).map {
            it.map {
                it.transformToDomain()
            }
        }
    }

    override fun savePets(pet: Pet) {
        dao.insert(pet.transformToPetDb())
    }

    override fun getPetAbilityInfo(abilityId: Int): Observable<PetAbility> {
        return restService.getPetAbilityInfo(abilityId,
                shared.getValue(LOCALE),
                shared.getValue(ACCESS_TOKEN))
                .map {
                    it.transformToDomain()
                }
    }

    override fun getPetSpecies(speciesId: Int): Observable<PetSpecies> {
        return restService.getPetSpecies(speciesId,
                shared.getValue(LOCALE),
                shared.getValue(ACCESS_TOKEN))
                .map {
                    it.transformToDomain()
                }
    }
}