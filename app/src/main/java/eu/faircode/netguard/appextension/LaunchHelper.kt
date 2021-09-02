package eu.faircode.netguard.appextension

import android.content.Context
import androidx.preference.PreferenceManager
import eu.faircode.netguard.ServiceSinkhole

object LaunchHelper {

    private const val KEY_ENABLED = "enabled"
    private const val KEY_PREPARED = "prepared"

    fun startVPN(context: Context) {
        switchDataGuard(context, true)
        val uri = getContentUri(AppExtensionState.START.id)
        context.contentResolver.insert(uri, null)
    }

    fun stopVPN(context: Context) {
        switchDataGuard(context, false)
        val uri = getContentUri(AppExtensionState.STOP.id)
        context.contentResolver.insert(uri, null)
    }

    fun getCurrentExtensionState(context: Context): String {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val isEnabled = prefs.getBoolean(KEY_ENABLED, false)
        return if (isEnabled) AppExtensionState.START.id else AppExtensionState.STOP.id
    }

    private fun switchDataGuard(context: Context, isEnabled: Boolean) {
        if (isEnabled) {
            ServiceSinkhole.start(KEY_PREPARED, context)
        } else {
            ServiceSinkhole.stop(KEY_PREPARED, context, false)
        }

        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().putBoolean(KEY_ENABLED, isEnabled).apply()
    }
}