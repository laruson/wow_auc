package andrey.chernikovich.data.sharedpref

import andrey.chernikovich.domain.sharedpref.SharedPref
import android.content.SharedPreferences

class SharedPrefImpl(private val shared: SharedPreferences) : SharedPref {

    override fun putValueBoolean(const: String, value: Boolean) {
        shared.edit()
                .putBoolean(const, value)
                .apply()
    }

    override fun getValueBoolean(const: String, value: Boolean): Boolean {
        return shared.getBoolean(const, value)
    }

    override fun getValue(const: String, value: String): String {
        return shared.getString(const, value)!!
    }

    override fun putValue(const: String, value: String) {
        shared.edit()
                .putString(const, value)
                .apply()
    }
}