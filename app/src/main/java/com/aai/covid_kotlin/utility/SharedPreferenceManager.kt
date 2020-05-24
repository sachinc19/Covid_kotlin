package com.aai.covid_kotlin.utility

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import java.lang.reflect.Array.*


/*object SharedPreferenceManager {


    fun defaultPrefs(context: Context): SharedPreferences
            = PreferenceManager.getDefaultSharedPreferences(context)

    fun customPrefs(context: Context, name: String): SharedPreferences
            = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    *//**
     * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
     *//*
    operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String? -> edit({ it.putString(key, value) })
            is Int -> edit({ it.putInt(key, value) })
            is Boolean -> edit({ it.putBoolean(key, value) })
            is Float -> edit({ it.putFloat(key, value) })
            is Long -> edit({ it.putLong(key, value) })
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    *//**
     * finds value on given key.
     * [T] is the type of value
     * @param defaultValue optional default value - will take null for strings, false for bool and -1 for numeric values if [defaultValue] is not specified
     *//*
    operator inline fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as? String) as T?
            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

}*/
///////
/*class SharedPreferenceManager  // private static final String DASH_BOARD = "dashBoard";
protected constructor() {
    val allPrefs: Map<String, *>
        get() = sharedPreferences!!.all

    fun setBooleanValue(key: String?, value: Boolean?) {
        prefEdit = sharedPreferences!!.edit()
        prefEdit.putBoolean(key, value!!)
        prefEdit.commit()
    }

    fun getBooleanValue(key: String?, defaultvalue: Boolean?): Boolean {
        return sharedPreferences!!.getBoolean(key, defaultvalue!!)
    }

    fun setStringValue(key: String?, value: String?) {
        prefEdit = sharedPreferences!!.edit()
        prefEdit.putString(key, value)
        prefEdit.commit()
    }

    fun getStringValue(key: String?, defaultvalue: String?): String? {
        return sharedPreferences!!.getString(key, defaultvalue)
    }

    fun setIntegerValue(key: String?, value: Int) {
        prefEdit = sharedPreferences!!.edit()
        prefEdit.putInt(key, value)
        prefEdit.commit()
    }

    fun getIntegerValue(key: String?, defaultvalue: Int): Int {
        return sharedPreferences!!.getInt(key, defaultvalue)
    }

    fun setLongValue(key: String?, value: Long) {
        prefEdit = sharedPreferences!!.edit()
        prefEdit.putLong(key, value)
        prefEdit.commit()
    }

    fun getLongValue(key: String?, defaultvalue: Long): Long {
        return sharedPreferences!!.getLong(key, defaultvalue)
    }

    fun setFloatValue(key: String?, value: Float) {
        prefEdit = sharedPreferences!!.edit()
        prefEdit.putFloat(key, value)
        prefEdit.commit()
    }

    fun getFloatValue(key: String?, defaultvalue: Float): Float {
        return sharedPreferences!!.getFloat(key, defaultvalue)
    }

    fun onLogOut(
        booleanKey: String?, isRemember: Boolean?,
        stringKey: String?, userName: String?
    ) {
        prefEdit = sharedPreferences!!.edit()
        prefEdit.putBoolean(booleanKey, isRemember!!)
        prefEdit.putString(stringKey, userName)
        prefEdit.commit()
    }

    fun setConsumerProfile(jsonObject: JSONObject?) {
        prefEdit = sharedPreferences!!.edit()
        //Set the values
//Gson gson = new Gson();
//String json = gson.toJson(user);
        if (jsonObject != null) { //String json = gson.toJson(list);
            prefEdit.putString(
                Constant.CONSUMERPROFILE,
                jsonObject.toString()
            )
        } else {
            prefEdit.putString(Constant.CONSUMERPROFILE, null)
        }
        prefEdit.commit()
    }

    fun setPassengerDetails(jsonObject: JSONObject?) {
        prefEdit = sharedPreferences!!.edit()
        //Set the values
//Gson gson = new Gson();
//String json = gson.toJson(user);
        if (jsonObject != null) { //String json = gson.toJson(list);
            prefEdit.putString(
                Constant.PASSENGER_DETAILS,
                jsonObject.toString()
            )
        } else {
            prefEdit.putString(Constant.PASSENGER_DETAILS, null)
        }
        prefEdit.commit()
    }

    //Get the values
    val travellerDetails: TravellerDetails_saveDto
        get() {
            var travellerDetails_saveDto = TravellerDetails_saveDto()
            //Get the values
            val gson = Gson()
            val json =
                sharedPreferences!!.getString(Constant.PASSENGER_DETAILS, null)
            return if (json != null) {
                try {
                    travellerDetails_saveDto =
                        gson.fromJson(json, TravellerDetails_saveDto::class.java)
                    travellerDetails_saveDto
                } catch (e: Exception) {
                    travellerDetails_saveDto
                }
            } else {
                travellerDetails_saveDto
            }
        }

    companion object {
        var instance: SharedPreferenceManager? = null
            private set
        private var context: Context? = null
        var sharedPreferences: SharedPreferences? = null
            private set
        private var prefEdit: SharedPreferences.Editor? = null

        fun InitializeSharedPreferences(_context: Context?): SharedPreferenceManager? {
            if (instance == null) {
                instance = SharedPreferenceManager()
                context = _context
                sharedPreferences =
                    PreferenceManager.getDefaultSharedPreferences(context)
            }
            return instance
        }
    }
}*/

