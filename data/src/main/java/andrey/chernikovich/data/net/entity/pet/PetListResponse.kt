package andrey.chernikovich.data.net.entity.pet

import andrey.chernikovich.data.net.entity.NetEntity

data class PetListResponse(val pets: List<PetResponse>) : NetEntity