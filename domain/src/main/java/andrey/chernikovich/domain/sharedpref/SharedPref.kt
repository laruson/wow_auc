package andrey.chernikovich.domain.sharedpref

interface SharedPref {
    fun setValue(const:String, value:String)
    fun getAccessToken(): String?
    fun getLocale(): String?
    fun getNameSpace(): String?
    fun getRegion(): String?
}