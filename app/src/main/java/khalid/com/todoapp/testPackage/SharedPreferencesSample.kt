package khalid.com.todoapp.testPackage

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by ${KhalidToak} on 3/7/2019.
*/
class SharedPreferencesSample{

    companion object {
        const val defaultValue = "to be saved"
        const val key = "Key"
        fun saveSomethingWithSharedPreferences(context: Context, whatWeWantToSave : String)
                //call apply on the initialize method and put what we want to save using the key we created above
                =initializeSharedPreferences(context)!!.edit().apply{
                putString(key, whatWeWantToSave)
            }.apply()

//initialize the sharedPrefrences with the preference manager
        private fun initializeSharedPreferences(context: Context): SharedPreferences?
                = PreferenceManager.getDefaultSharedPreferences(context)

        fun getWhatWeSavedWithSharedPreferences(context: Context): String? =
            initializeSharedPreferences(context)!!.getString(key, defaultValue )
    }
}