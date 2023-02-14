package com.mario.zara.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import assertk.Assert
import assertk.assertions.support.expected
import assertk.assertions.support.fail
import assertk.assertions.support.show
import com.mario.zara.domain.Result
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

internal inline fun <reified T> Assert<Any>.isInstanceOf(): Assert<T> =
    transform(name) { actual ->
        if (actual is T) {
            actual
        } else {
            expected("instance of:${show(T::class)} but class of:${show(actual::class)}")
        }
    }

internal fun <T> Assert<Result.Success<T>>.isDataEqualTo(expected: T) =
    given { actual ->
        if (actual.data == expected) return
        fail(expected, actual)
    }

@Throws(InterruptedException::class)
internal fun <T> LiveData<T>.getOrAwaitValue(timeout: Long = 1): T? {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(newValue: T?) {
            data = newValue
            latch.countDown()
            removeObserver(this)
        }
    }
    observeForever(observer)
    latch.await(timeout, TimeUnit.MILLISECONDS)
    removeObserver(observer)

    return data
}
