package andrey.chernikovich.data.sharedpref

import andrey.chernikovich.domain.sharedpref.SharedPref
import android.content.SharedPreferences

class SharedPrefImpl(private val shared: SharedPreferences) : SharedPref {
    override fun getValue(const: String, value: String) : String {
        return shared.getString(const, value)!!
    }

    override fun setValue(const: String, value: String) {
        shared.edit()
                .putString(const, value)
                .apply()
    }
}