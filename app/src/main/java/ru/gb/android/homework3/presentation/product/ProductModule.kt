package ru.gb.android.homework3.presentation.product

import dagger.Module
import dagger.Provides
import ru.gb.android.homework3.ServiceLocator

@Module
class ProductModule {

    @Provides
    fun provideViewModel(): ProductListViewModel {
        return ProductListViewModel(
            consumeProductsUseCase = ServiceLocator.provideConsumeProductsUseCase(),
            productStateFactory = provideProductVOFactory(),
            consumePromosUseCase = ServiceLocator.provideConsumePromosUseCase(),
        )
    }

    @Provides
    fun provideProductVOFactory(): ProductStateFactory {
        return ProductStateFactory(
            discountFormatter = ServiceLocator.provideDiscountFormatter(),
            priceFormatter = ServiceLocator.providePriceFormatter(),
        )
    }
}