package com.su.core_localstorage

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [23])
abstract class LocalDatabaseTest {
    lateinit var database: KoeNaWinDatabase

    @Before
    fun initDatabase(){
        database = Room.inMemoryDatabaseBuilder(getApplicationContext(), KoeNaWinDatabase::class.java)
            .allowMainThreadQueries().build()
    }

    @After
    fun closeDatabase(){
        database.close()
    }
}