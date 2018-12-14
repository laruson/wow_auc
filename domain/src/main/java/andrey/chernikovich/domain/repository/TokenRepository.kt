package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.token.Token
import io.reactivex.Observable

interface TokenRepository : BaseRepository {
    fun getToken():Observable<Token>
}