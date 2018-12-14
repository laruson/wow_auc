package andrey.chernikovich.data.net.entity.pet

import andrey.chernikovich.data.net.entity.NetEntity

data class PetAbilityResponse(
        val slot: Int = 0,
        val order: Int = 0,
        val requiredLevel: Int = 1,
        val id: Int,
        val name: String,
        val icon: String,
        val cooldown: Int,
        val rounds: Int,
        val petTypeId: Int,
        val isPassive: Boolean,
        val hideHints: Boolean
) : NetEntity