package com.farshidabz.squarerepo.data.mapper

import com.farshidabz.squarerepo.helpers.Constants.FAKE_REPO_NETWORK_MODEL
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class DomainToDataMapperKtTest {

    @Test
    fun `give fake repo model convert to local model return model`() {
        val localModel = FAKE_REPO_NETWORK_MODEL.toLocalEntity(true)
        assertThat(localModel, `is`(notNullValue()))
        assertThat(localModel.id, `is`(1L))
    }

    @Test
    fun `give fake repo model convert to local set bookmark true return model`() {
        val localModel = FAKE_REPO_NETWORK_MODEL.toLocalEntity(true)
        assertThat(localModel, `is`(notNullValue()))
        assertThat(localModel.isBookmarked, `is`(true))
    }

    @Test
    fun `give fake repo model convert to local set bookmark false return model`() {
        val localModel = FAKE_REPO_NETWORK_MODEL.toLocalEntity(false)
        assertThat(localModel, `is`(notNullValue()))
        assertThat(localModel.isBookmarked, `is`(false))
    }
}