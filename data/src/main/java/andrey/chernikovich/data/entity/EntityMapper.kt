package andrey.chernikovich.data.entity

import andrey.chernikovich.domain.entity.BaseItem
import andrey.chernikovich.domain.entity.Item
import andrey.chernikovich.domain.entity.Token

fun TokenResponse.transformToDomain(): Token {
    return Token(price = price, lastUpdate = last_updated_timestamp)
}

fun ItemResponse.transformToDomain(): Item {
    return Item(id = Id,
            name = Name,
            minimumBuyout = MinBuyout,
            marketValue = MarketValue,
            historicalPrice = HistoricalPrice,
            quantity = Quantity)
}

fun BaseItemResponse.transformToDomain() : BaseItem{
    return BaseItem(id = id, name = name, image = "https://wow.zamimg.com/images/wow/icons/large/$icon.jpg")
}