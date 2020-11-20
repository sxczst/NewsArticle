package org.sxczst.toutiao.news.utils

import android.content.Context

/**
 * @Author      :sxczst
 * @Date        :Created in 2020/11/20 19:59
 * @Description :
 */
object SharedPreferencesUtils {
    private val TOKEN_STR = "save_token"

    fun saveToken(context: Context, key: String, value: String): Boolean {
        val sharedPreferences = context.getSharedPreferences(
            TOKEN_STR,
            Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        return editor.commit()
    }

    fun getSaveToken(context: Context, key: String): String? {
        val sharedPreferences = context.getSharedPreferences(
            TOKEN_STR,
            Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(key, null)
    }
}