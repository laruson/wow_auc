package andrey.chernikovich.domain.entity

data class Item(val id: String,
                val name: String,
                val minimumBuyout: String,
                val regionMinimumBuyout: String,
                val marketValue: String,
                val regionMarketValue: String,
                val historicalPrice: String,
                val regionHistoricalPrice: String,
                val quantity: String,
                val regionQuantity: String) : DomainEntity