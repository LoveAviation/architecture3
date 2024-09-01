package ru.gb.android.homework3.presentation.promo

import dagger.Module
import dagger.Provides
import ru.gb.android.homework3.ServiceLocator

@Module
class PromoModule {
    @Provides
    fun provideViewModel(): PromoListViewModel {
        return PromoListViewModel(
            promoStateFactory = providePromoStateFactory(),
            consumePromosUseCase = ServiceLocator.provideConsumePromosUseCase(),
        )
    }

    @Provides
    fun providePromoStateFactory(): PromoStateFactory {
        return PromoStateFactory()
    }
}