package andrey.chernikovich.data.entity

import andrey.chernikovich.data.entity.utils.Links

data class TokenResponse(val links: Links,
                         val last_updated_timestamp:String,
                         val price:String):DataEntity
