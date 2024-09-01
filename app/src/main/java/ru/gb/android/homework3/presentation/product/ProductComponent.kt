package ru.gb.android.homework3.presentation.product

import dagger.Component
import dagger.Subcomponent


@Component(modules = [ProductModule::class])
interface ProductComponent {
    fun inject(fragment: ProductListFragment)
}