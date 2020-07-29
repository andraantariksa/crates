package io.github.andraantariksa.cratesio.ui

import androidx.lifecycle.ViewModel
import io.github.andraantariksa.cratesio.data.repository.CratesRepository
import kotlinx.coroutines.*

fun <T> lazyDeffered(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}

class CratesViewModel(
    private val cratesRepository: CratesRepository
) : ViewModel() {
    val crateSummary by lazyDeffered {
        cratesRepository.getCrateSummary()
    }
}
