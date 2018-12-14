package andrey.chernikovich.data.net.entity.mapper

import andrey.chernikovich.data.net.entity.token.TokenResponse
import andrey.chernikovich.domain.entity.token.Token

fun TokenResponse.transformToDomain(): Token {
    return Token(price = price, lastUpdate = last_updated_timestamp)
}