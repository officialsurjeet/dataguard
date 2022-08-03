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

interface PurchaseServiceListener : BillingServiceListener {
    /**
     * Callback will be triggered upon obtaining information about product prices
     *
     * @param iapKeyPrices - a map with available products
     */
    override fun onPricesUpdated(iapKeyPrices: Map<String, DataWrappers.ProductDetails>)

    /**
     * Callback will be triggered when a product purchased successfully
     *
     * @param purchaseInfo - specifier of owned product
     */
    fun onProductPurchased(purchaseInfo: DataWrappers.PurchaseInfo)

    /**
     * Callback will be triggered upon owned products restore
     *
     * @param purchaseInfo - specifier of owned product
     */
    fun onProductRestored(purchaseInfo: DataWrappers.PurchaseInfo)
}