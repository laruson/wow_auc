package andrey.chernikovich.domain.sharedpref

interface SharedPref {

    fun putValue(const:String, value:String)

    fun getValue(const: String, value:String="empty") : String

    fun putValueBoolean(const:String, value:Boolean)

    fun getValueBoolean(const: String, value:Boolean=false) : Boolean
}