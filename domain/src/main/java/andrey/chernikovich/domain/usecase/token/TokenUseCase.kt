package andrey.chernikovich.domain.usecase.token

import andrey.chernikovich.domain.entity.Token
import io.reactivex.Observable

interface TokenUseCase {
    fun getToken(): Observable<Token>
}