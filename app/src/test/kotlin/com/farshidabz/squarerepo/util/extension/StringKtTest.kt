package com.farshidabz.squarerepo.util.extension

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StringKtTest {

    private val notNullString = "some characters"
    private val emptyString = ""
    private val nullString: String? = null
    private val notEmptyNullString: String = "null"

    @Test
    fun `give non null string check is not null or empty then return true`() {
        val result = notNullString.isNotNullOrEmpty()
        assertThat(result, `is`(true))
    }

    @Test
    fun `give empty string string check is not null or empty then return false`() {
        val result = emptyString.isNotNullOrEmpty()
        assertThat(result, `is`(false))
    }

    @Test
    fun `give null string check is not null or empty then return false`() {
        val result = nullString.isNotNullOrEmpty()
        assertThat(result, `is`(false))
    }

    @Test
    fun `give not empty null string check is not null or empty then return false`() {
        val result = notEmptyNullString.isNotNullOrEmpty()
        assertThat(result, `is`(false))
    }

}