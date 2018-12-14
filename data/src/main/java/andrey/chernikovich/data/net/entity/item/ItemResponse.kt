package andrey.chernikovich.data.net.entity.item

import andrey.chernikovich.data.net.entity.NetEntity


data class ItemResponse(
        val Id: String,
        val Name: String,
        val Level: String,
        val Class: String,
        val SubClass: String,
        val VendorBuy: String,
        val VendorSell: String,
        val MarketValue: String,
        val MinBuyout: String,
        val Quantity: String,
        val NumAuctions: String,
        val HistoricalPrice: String,
        val RegionMarketAvg: String,
        val RegionMinBuyoutAvg: String,
        val RegionQuantity: String,
        val RegionHistoricalPrice: String,
        val RegionSaleAvg: String,
        val RegionAvgDailySold: String,
        val RegionSaleRate: String,
        val Url: String,
        val LastUpdated: String) : NetEntity
