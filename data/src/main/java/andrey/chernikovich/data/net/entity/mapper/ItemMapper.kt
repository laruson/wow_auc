package andrey.chernikovich.data.net.entity.mapper

import andrey.chernikovich.data.net.entity.ItemResponse
import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.entity.Item

fun ItemResponse.transformToDomain(): Item {
    return Item(id = Id,
            name = Name,
            minimumBuyout = MinBuyout,
            marketValue = MarketValue,
            historicalPrice = HistoricalPrice,
            quantity = Quantity)
}

