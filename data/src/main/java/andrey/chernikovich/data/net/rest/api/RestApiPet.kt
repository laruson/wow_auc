package andrey.chernikovich.data.net.rest.api

import andrey.chernikovich.data.net.entity.pet.PetAbilityResponse
import andrey.chernikovich.data.net.entity.pet.PetListResponse
import andrey.chernikovich.data.net.entity.pet.PetSpeciesResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestApiPet {
    //pet
    //https://us.api.blizzard.com/wow/pet/?locale=en_US&access_token=USt4bd4huAL6Rvn11K4vAwBhDBxtcufsfg
    @GET("/wow/pet/")
    fun getPets(@Query("locale") locale: String,
                @Query("access_token") access_token: String): Flowable<PetListResponse>

    //pet ability
    //https://us.api.blizzard.com/wow/pet/ability/640?locale=en_US&access_token=USt4bd4huAL6Rvn11K4vAwBhDBxtcufsfg
    @GET("/wow/pet/ability/{abilityID}")
    fun getPetAbilityInfo(@Path("abilityID") abilityID: Int,
                          @Query("locale") locale: String,
                          @Query("access_token") access_token: String): Observable<PetAbilityResponse>

    //pet species
    //https://us.api.blizzard.com/wow/pet/species/2047?locale=en_US&access_token=USt4bd4huAL6Rvn11K4vAwBhDBxtcufsfg
    @GET("/wow/pet/species/{speciesID}")
    fun getPetSpecies(@Path("speciesID") speciesID: String,
                      @Query("locale") locale: String,
                      @Query("access_token") access_token: String): Observable<PetSpeciesResponse>
}