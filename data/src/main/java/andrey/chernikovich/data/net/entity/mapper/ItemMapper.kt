package andrey.chernikovich.data.net.entity.mapper

import andrey.chernikovich.data.net.entity.item.ItemResponse
import andrey.chernikovich.domain.entity.item.Item

fun ItemResponse.transformToDomain(): Item {
    return Item(id = Id,
            name = Name,
            minimumBuyout = MinBuyout,
            regionMinimumBuyout = RegionMinBuyoutAvg,
            marketValue = MarketValue,
            regionMarketValue = RegionMarketAvg,
            historicalPrice = HistoricalPrice,
            regionHistoricalPrice = RegionHistoricalPrice,
            quantity = Quantity,
            regionQuantity = RegionQuantity)
}

