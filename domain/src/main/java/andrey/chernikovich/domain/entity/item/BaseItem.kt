package andrey.chernikovich.domain.entity.item

import andrey.chernikovich.domain.entity.DomainEntity

data class BaseItem(val id:String,
                    val name:String,
                    val image:String,
                    val quality:String,
                    val itemClass:String="",
                    val itemSubClass:String="",
                    val itemLevel:String="",
                    val requiredLevel:String="") : DomainEntity