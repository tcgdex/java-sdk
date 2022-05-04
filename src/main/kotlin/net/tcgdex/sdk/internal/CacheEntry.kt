package net.tcgdex.sdk.internal

import java.time.LocalDateTime

data class CacheEntry <T> (
    val value: T,
    val time: LocalDateTime = LocalDateTime.now()
)
