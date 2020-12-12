package com.example.ookbeetest.data.repository.auth.datasourceImpl

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.ookbeetest.MY_PREFS_KEY_TOKEN
import com.example.ookbeetest.data.repository.auth.datasource.AuthDataSource


class AuthDataSourceImpl(private val context: Context) :
    AuthDataSource {

    var masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    var sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
        "secret_shared_prefs",
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override fun saveToken(token: String) {
        // use the shared preferences and editor as you normally would
        var editor = sharedPreferences.edit()
        editor.putString(MY_PREFS_KEY_TOKEN, token)
        editor.apply()
    }

    override fun getToken(): String {
        val token =
            sharedPreferences.getString(MY_PREFS_KEY_TOKEN, "") ?: ""
        return token
    }


}