package andrey.chernikovich.data.net.entity.mapper

import andrey.chernikovich.data.net.entity.RealmResponse
import andrey.chernikovich.domain.entity.Realm

fun RealmResponse.transformToDomain(): Realm {
    return Realm(name = name, slug = slug)
}