package andrey.chernikovich.data.net.entity

data class ItemResponse(val Id:String,
                        val Name : String,
                        val Level : Int,
                        val Class : String,
                        val SubClass : String,
                        val VendorBuy:Int,
                        val VendorSell:Int,
                        val MarketValue:Int,
                        val MinBuyout:Int,
                        val Quantity:Int,
                        val NumAuctions:Int,
                        val HistoricalPrice:Int,
                        val RegionMarketAvg:Int,
                        val RegionMinBuyoutAvg:Int,
                        val RegionQuantity:Int,
                        val RegionHistoricalPrice:Int,
                        val RegionSaleAvg:Int,
                        val RegionAvgDailySold:Int,
                        val RegionSaleRate:Int,
                        val Url:String,
                        val LastUpdated:Int) : NetEntity