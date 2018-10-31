package andrey.chernikovich.domain.entity

data class BaseItem(val id:String,
                    val name:String,
                    val image:String) : DomainEntity {
}