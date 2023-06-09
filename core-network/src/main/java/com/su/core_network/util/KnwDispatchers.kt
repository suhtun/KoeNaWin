package com.su.core_network.util

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val knwDispatchers: KnwDispatchers)

enum class KnwDispatchers {
    IO
}