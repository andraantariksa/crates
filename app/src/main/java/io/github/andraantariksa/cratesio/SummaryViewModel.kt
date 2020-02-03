package io.github.andraantariksa.cratesio

import androidx.lifecycle.ViewModel
import io.github.andraantariksa.cratesio.data.repository.CrateSummaryRepository
import kotlinx.coroutines.*

fun <T> lazyDeffered(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}

class SummaryViewModel(
    private val crateSummaryRepository: CrateSummaryRepository
) : ViewModel() {
    val crateSummary by lazyDeffered {
        crateSummaryRepository.getSummary()
    }
}
