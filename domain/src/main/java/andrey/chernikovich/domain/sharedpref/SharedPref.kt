package andrey.chernikovich.domain.sharedpref

interface SharedPref {

    fun setValue(const:String, value:String)

    fun getValue(const: String, value:String="empty") : String
}