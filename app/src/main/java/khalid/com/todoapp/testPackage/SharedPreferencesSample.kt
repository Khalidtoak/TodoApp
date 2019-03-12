package khalid.com.todoapp.testPackage

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by ${KhalidToak} on 3/7/2019.
*/
private const val key = "key"
private const val defaultValue = "default"
class SharedPreferencesSample{
    companion object {
        fun saveSomethingWithSharedPreferences(context: Context, whatIsToBeSaved : String){
            val sharedPreferences = initializeSharedPreferences(context)
            val editor = sharedPreferences.edit().apply {
                putString(key, whatIsToBeSaved)
            }.apply()

        }

        private fun initializeSharedPreferences(context: Context): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(context)
        }

        fun getSavedStringPreferences(context: Context) : String?{
            val sharedPreferences = initializeSharedPreferences(context)
           return sharedPreferences.getString(key, defaultValue)
        }
    }
}