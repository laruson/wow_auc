package andrey.chernikovich.data.repository

import andrey.chernikovich.data.net.entity.mapper.transformToDomain
import andrey.chernikovich.data.net.rest.service.RestServiceToken
import andrey.chernikovich.domain.entity.Token
import andrey.chernikovich.domain.repository.TokenRepository
import andrey.chernikovich.domain.sharedpref.SharedPref
import io.reactivex.Observable

class TokenRepositoryImpl(private val restService: RestServiceToken,
                          private val shadow: SharedPref) : TokenRepository {

    override fun getToken(): Observable<Token> {
        return restService
                .getToken(shadow.getNameSpace()!!,
                        shadow.getLocale()!!,
                        shadow.getAccessToken()!!)
                .map {
                    it.transformToDomain()
                }
    }
}