package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.Token
import io.reactivex.Observable

interface TokenRepository : BaseRepository {
    fun getTokenEu():Observable<Token>
    fun getTokenUs():Observable<Token>
}