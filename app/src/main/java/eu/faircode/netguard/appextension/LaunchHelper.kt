/*
 * Copyright (c) 2022 FullDive
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package eu.faircode.netguard.appextension

import android.content.Context
import androidx.preference.PreferenceManager
import eu.faircode.netguard.ServiceSinkhole

object LaunchHelper {

    private const val KEY_ENABLED = "enabled"
    private const val KEY_PREPARED = "prepared"

    fun startVPN(context: Context) {
        switchDataGuard(context, true)
    }

    fun stopVPN(context: Context) {
        switchDataGuard(context, false)
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