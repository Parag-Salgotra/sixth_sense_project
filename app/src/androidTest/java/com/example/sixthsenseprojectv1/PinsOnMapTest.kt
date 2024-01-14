package com.example.sixthsenseprojectv1

import android.content.Context
import android.content.Intent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.core.content.ContextCompat.startActivity
import androidx.test.platform.app.InstrumentationRegistry
import com.example.sixthsenseprojectv1.ui.theme.SixthSenseProjectV1Theme
import kotlinx.coroutines.awaitAll
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PinsOnMapTest {
    @get:Rule
    val composeRule = createComposeRule()

    private lateinit var context: Context

    @Before
    fun setUp() {
        context = InstrumentationRegistry.getInstrumentation().targetContext
    }
}