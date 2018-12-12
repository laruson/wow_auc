package andrey.chernikovich.data.db.entity.mapper

import andrey.chernikovich.data.db.entity.RealmDb
import andrey.chernikovich.data.net.entity.RealmResponse
import andrey.chernikovich.domain.entity.Realm

fun RealmDb.transformToDomain(): Realm {
    return Realm(id = id,name = name, slug = slug)
}

fun RealmDb.transformToResponse(): RealmResponse {
    return RealmResponse(id = id,name = name, slug = slug)
}