package andrey.chernikovich.data.db.entity.mapper

import andrey.chernikovich.data.db.entity.GroupItemDb
import andrey.chernikovich.data.db.entity.ItemDB
import andrey.chernikovich.domain.entity.item.BaseItem
import android.util.Log

fun ItemDB.transformToBaseItem(): BaseItem {
    return BaseItem(
            id = id,
            name = name,
            image = "https://wow.zamimg.com/images/wow/icons/large/$icon.jpg",
            itemClass = itemClass,
            itemSubClass = itemSubClass,
            itemLevel = itemLevel,
            quality = quality,
            requiredLevel = requiredLevel)
}

fun BaseItem.transformToItemDb(): ItemDB {
    return ItemDB(
            id = id,
            name = name,
            icon = image,
            itemClass = itemClass,
            itemSubClass = itemSubClass,
            itemLevel = itemLevel,
            quality = quality,
            requiredLevel = requiredLevel)
}

fun BaseItem.transformToGroupItemDb(): GroupItemDb {
    return GroupItemDb(
            id = id,
            name = name,
            icon = image,
            itemClass = itemClass,
            itemSubClass = itemSubClass,
            itemLevel = itemLevel,
            quality = quality,
            requiredLevel = requiredLevel)
}

fun GroupItemDb.transformToGroupItemDb(): BaseItem {
    return BaseItem(
            id = id,
            name = name,
            image = icon,
            itemClass = itemClass,
            itemSubClass = itemSubClass,
            itemLevel = itemLevel,
            quality = quality,
            requiredLevel = requiredLevel)
}