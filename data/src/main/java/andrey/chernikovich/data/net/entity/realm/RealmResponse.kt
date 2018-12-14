package andrey.chernikovich.data.net.entity.realm

import andrey.chernikovich.data.net.entity.NetEntity

data class RealmResponse(val name:String,
                         val id:String,
                         val slug:String) : NetEntity