package com.farshidabz.squarerepo.data.mapper

import com.farshidabz.squarerepo.domain.model.persistence.RepositoryEntity
import com.farshidabz.squarerepo.helpers.Constants
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class LocalToUIMapperKtTest {

    @Test
    fun `give list of repo entity convert to ui model and return`() {
        val localEntity = listOf(Constants.FAKE_ENTITY_MODEL).toRepositoryUIModel()
        MatcherAssert.assertThat(localEntity, CoreMatchers.`is`(CoreMatchers.notNullValue()))
        MatcherAssert.assertThat(localEntity.size, CoreMatchers.`is`(1))
        MatcherAssert.assertThat(localEntity[0].id, CoreMatchers.`is`(1L))
    }

    @Test
    fun `give empy list of entity convert to ui model and return empty list`() {
        val localEntity = listOf<RepositoryEntity>().toRepositoryUIModel()
        MatcherAssert.assertThat(localEntity, CoreMatchers.`is`(CoreMatchers.notNullValue()))
        MatcherAssert.assertThat(localEntity.size, CoreMatchers.`is`(0))
    }
}