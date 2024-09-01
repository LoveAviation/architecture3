package ru.gb.android.homework3.presentation.promo

import dagger.Component

@Component(modules = [PromoModule::class])
interface PromoComponent {
    fun inject(fragment: PromoListFragment)
}