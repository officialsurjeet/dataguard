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

package com.fulldive.iap

import com.android.billingclient.api.AccountIdentifiers

class DataWrappers {

    data class ProductDetails(
        val title: String?,
        val description: String?,
        val price: String?,
        val priceAmount: Double?,
        val priceCurrencyCode: String?,
    )

    data class PurchaseInfo(
        val purchaseState: Int,
        val developerPayload: String,
        val isAcknowledged: Boolean,
        val isAutoRenewing: Boolean,
        val orderId: String,
        val originalJson: String,
        val packageName: String,
        val purchaseTime: Long,
        val purchaseToken: String,
        val signature: String,
        val sku: String,
        val accountIdentifiers: AccountIdentifiers?
    )
}