package andrey.chernikovich.data.db.entity.mapper

import andrey.chernikovich.data.db.entity.ItemDB
import andrey.chernikovich.domain.entity.BaseItem

fun ItemDB.transformToBaseItem(): BaseItem{
    return BaseItem(id=id,name = name,image = "https://wow.zamimg.com/images/wow/icons/large/$icon.jpg")
}