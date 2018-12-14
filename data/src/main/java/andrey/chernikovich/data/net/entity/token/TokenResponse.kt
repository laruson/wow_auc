package andrey.chernikovich.data.net.entity.token

import andrey.chernikovich.data.net.entity.NetEntity


data class TokenResponse(val last_updated_timestamp:String,
                         val price:String): NetEntity
