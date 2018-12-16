package andrey.chernikovich.data.net.rest.service

import andrey.chernikovich.data.net.entity.pet.PetAbilityResponse
import andrey.chernikovich.data.net.entity.pet.PetListResponse
import andrey.chernikovich.data.net.entity.pet.PetResponse
import andrey.chernikovich.data.net.entity.pet.PetSpeciesResponse
import andrey.chernikovich.data.net.rest.service.base.BaseRestService
import android.util.Log
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class RestServicePet @Inject constructor(apiUrl: String) : BaseRestService(apiUrl) {
    fun getPets(locale: String,
                access_token: String): Flowable<PetListResponse> {
        return restApiPet.getPets(locale, access_token)
    }

    fun getPetAbilityInfo(abilityId: Int,
                          locale: String,
                          access_token: String): Observable<PetAbilityResponse> {
        return restApiPet.getPetAbilityInfo(abilityId, locale, access_token)
    }

    fun getPetSpecies(speciesId: String,
                      locale: String,
                      access_token: String): Observable<PetSpeciesResponse> {
        return restApiPet.getPetSpecies(speciesId, locale, access_token)
    }
}