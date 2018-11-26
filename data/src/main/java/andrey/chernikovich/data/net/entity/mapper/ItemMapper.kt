package andrey.chernikovich.data.net.entity.mapper

import andrey.chernikovich.data.net.entity.ItemResponse
import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.entity.Item

fun ItemResponse.transformToDomain(): Item {
    return Item(id = Id.toString(),
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

