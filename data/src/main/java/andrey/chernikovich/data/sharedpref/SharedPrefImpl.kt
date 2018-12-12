package andrey.chernikovich.data.sharedpref

import andrey.chernikovich.domain.sharedpref.SharedPref
import android.content.SharedPreferences

class SharedPrefImpl(private val shadow: SharedPreferences) : SharedPref {


    override fun setValue(const: String, value: String) {
        shadow.edit()
                .putString(const, value)
                .apply()
    }

    override fun getAccessToken(): String? {
        return shadow.getString(ACCESS_TOKEN, "")
    }

    override fun getLocale(): String? {
        return shadow.getString(LOCALE, "")
    }

    override fun getNameSpace(): String? {
        return shadow.getString(NAMESPACE, "")
    }

    override fun getRegion(): String? {
        return shadow.getString(REGION, "")
    }


}