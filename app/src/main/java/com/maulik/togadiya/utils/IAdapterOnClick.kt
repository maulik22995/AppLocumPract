/*
 * Copyright © 2020 Tag-B Parking . All rights reserved.
 */

package com.maulik.togadiya.utils

import android.view.View

/**
 * ClickEvent Listener for Adapter
 * Callback of click event
 */
interface IAdapterOnClick {
    /**
     * Click event for getting callBack from adapter
     */
    fun onClick(view : View?, item: Any, position: Int)
}
