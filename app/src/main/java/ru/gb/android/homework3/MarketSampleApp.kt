package ru.gb.android.homework3

import android.app.Application
import ru.gb.android.homework3.presentation.product.DaggerProductComponent
import ru.gb.android.homework3.presentation.product.ProductComponent
import ru.gb.android.homework3.presentation.promo.DaggerPromoComponent
import ru.gb.android.homework3.presentation.promo.PromoComponent

class MarketSampleApp: Application() {

    val promoComponent: PromoComponent by lazy {
        DaggerPromoComponent.builder()
            .build()
    }

    val productComponent: ProductComponent by lazy {
        DaggerProductComponent.builder()
            .build()
    }


    init {
        instance = this
    }

    companion object {
        private var instance: MarketSampleApp? = null
        fun getInstance(): MarketSampleApp = instance!!
    }
}
