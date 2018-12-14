package andrey.chernikovich.domain.entity.realm

import andrey.chernikovich.domain.entity.DomainEntity

data class Realm(val name:String,
                 val id: String,
                 val slug:String) : DomainEntity