package andrey.chernikovich.data.db.entity

import andrey.chernikovich.domain.entity.pet.PetStats
import android.arch.persistence.room.TypeConverter

class Convertor {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromPetStats(value: PetStats): String {
            return value.toString()
        }

        @TypeConverter
        @JvmStatic
        fun toPetStats(value: String): PetStats {
            val split = value.replace("PetStats(", "").split(", ")
            return PetStats(
                    split[0].split("=")[1].toInt(),
                    split[1].split("=")[1].toInt(),
                    split[2].split("=")[1].toInt(),
                    split[3].split("=")[1].toInt(),
                    split[4].split("=")[1].toInt(),
                    split[5].split("=")[1].toInt(),
                    split[6].split("=")[1].replace(")", "").toInt())
        }

        @TypeConverter
        @JvmStatic
        fun fromList(list: List<String>): String {
            var str = ""
            for (i in 0 until list.size)
                str += list[i] + ","
            return str
        }

        @TypeConverter
        @JvmStatic
        fun toList(str: String): List<String> {
            val split = str.split(",")
            val list = mutableListOf<String>()
            for (i in 0 until split.size)
                list.add(split[i])
            return list
        }
    }
}