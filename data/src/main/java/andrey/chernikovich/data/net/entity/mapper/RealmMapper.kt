package andrey.chernikovich.data.net.entity.mapper

import andrey.chernikovich.data.db.entity.RealmDb
import andrey.chernikovich.data.net.entity.RealmResponse
import andrey.chernikovich.domain.entity.Realm

fun RealmResponse.transformToDomain(): Realm {
    return Realm(id = id, name = name, slug = slug)
}

fun RealmResponse.transformToDb(): RealmDb {
    return RealmDb(id = id,name = name, slug = slug)
}