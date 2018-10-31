package andrey.chernikovich.domain.entity

data class Item(val id: String,
                val name: String,
                val minimumBuyout: Int,
                val marketValue: Int,
                val historicalPrice: Int,
                val quantity: Int) : DomainEntity