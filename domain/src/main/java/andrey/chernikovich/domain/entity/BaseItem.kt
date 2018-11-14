package andrey.chernikovich.domain.entity

data class BaseItem(val id:Int,
                    val name:String,
                    val image:String) : DomainEntity {
}