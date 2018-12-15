package andrey.chernikovich.data.repository

import andrey.chernikovich.data.net.entity.mapper.transformToDomain
import andrey.chernikovich.data.net.rest.service.RestServiceToken
import andrey.chernikovich.data.sharedpref.ACCESS_TOKEN
import andrey.chernikovich.data.sharedpref.LOCALE
import andrey.chernikovich.data.sharedpref.NAMESPACE
import andrey.chernikovich.domain.entity.token.Token
import andrey.chernikovich.domain.repository.TokenRepository
import andrey.chernikovich.domain.sharedpref.SharedPref
import io.reactivex.Observable
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(private val restService: RestServiceToken,
                                              private val shared: SharedPref) : TokenRepository {

    override fun getToken(): Observable<Token> {
        return restService
                .getToken(
                        shared.getValue(NAMESPACE),
                        shared.getValue(LOCALE),
                        shared.getValue(ACCESS_TOKEN))
                .map {
                    it.transformToDomain()
                }
    }
}