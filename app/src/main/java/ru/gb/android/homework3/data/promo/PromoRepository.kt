package ru.gb.android.homework3.data.promo

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PromoRepository(
    private val promoLocalDataSource: PromoLocalDataSource,
    private val promoRemoteDataSource: PromoRemoteDataSource,
    private val promoDataMapper: PromoDataMapper,
    private val dispatcher: CoroutineDispatcher,
) {
    private val scope = CoroutineScope(SupervisorJob() + dispatcher)

    fun consumePromos(): Flow<List<PromoEntity>> {
        scope.launch(Dispatchers.IO) {
            val promos = promoRemoteDataSource.getPromos()
            promoLocalDataSource.savePromos(
                promos.map(promoDataMapper::toEntity)
            )
        }
        return promoLocalDataSource.consumePromos()
    }
}
