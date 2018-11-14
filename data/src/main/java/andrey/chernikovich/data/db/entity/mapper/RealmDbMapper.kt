package andrey.chernikovich.data.db.entity.mapper

import andrey.chernikovich.data.db.entity.RealmDb
import andrey.chernikovich.domain.entity.Realm

fun RealmDb.transformtoDomain(): Realm {
    return Realm(name = name, slug = slug)
}