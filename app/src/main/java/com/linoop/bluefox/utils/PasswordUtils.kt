package com.linoop.bluefox.utils

import android.util.Base64
import java.io.UnsupportedEncodingException
import java.nio.charset.StandardCharsets

object PasswordUtils {
    fun encryptPassword(password: String): String {
        var data = ByteArray(0)
        try {
            data = (password).toByteArray(charset("UTF-8"))
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        return Base64.encodeToString(data, Base64.NO_WRAP)
    }

    fun decryptPassword(base64Password: String): String {
        val data1 = Base64.decode(base64Password, Base64.DEFAULT)
        return String(data1, StandardCharsets.UTF_8)
    }
}