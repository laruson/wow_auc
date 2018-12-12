package andrey.chernikovich.domain.usecase.token

import andrey.chernikovich.domain.entity.Token
import andrey.chernikovich.domain.executor.PostExecutorThread
import andrey.chernikovich.domain.repository.TokenRepository
import andrey.chernikovich.domain.usecase.BaseUseCase
import io.reactivex.Observable

class GetTokenUseCase(postExecutorThread: PostExecutorThread,
                      private val tokenRepository: TokenRepository)
    : BaseUseCase(postExecutorThread), TokenUseCase {
    override fun getToken(): Observable<Token> {
        return tokenRepository.getToken()
                .observeOn(postExecutorThread)
                .subscribeOn(workExecutorThread)
    }
}