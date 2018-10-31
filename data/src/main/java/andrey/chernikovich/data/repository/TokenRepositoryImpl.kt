package andrey.chernikovich.data.repository

import andrey.chernikovich.data.entity.transformToDomain
import andrey.chernikovich.data.net.RestServiceToken
import andrey.chernikovich.domain.entity.Token
import andrey.chernikovich.domain.repository.TokenRepository
import io.reactivex.Observable

class TokenRepositoryImpl(private val restService: RestServiceToken) : TokenRepository {
    override fun getTokenEu(): Observable<Token> {
        return restService.getTokenEu()
            .map {
                it.transformToDomain()
            }
    }

    override fun getTokenUs(): Observable<Token> {
        return restService.getTokenUs()
                .map {
                    it.transformToDomain()
                }
    }

}