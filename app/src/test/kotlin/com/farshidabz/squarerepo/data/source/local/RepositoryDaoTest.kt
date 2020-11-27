package com.farshidabz.squarerepo.data.source.local

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.farshidabz.squarerepo.BaseTest
import com.farshidabz.squarerepo.data.source.local.dao.RepositoryDao
import com.farshidabz.squarerepo.domain.model.persistence.RepositoryEntity
import com.farshidabz.squarerepo.helpers.Constants
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@Config(sdk = [Config.OLDEST_SDK])
internal class RepositoryDaoTest : BaseTest() {

    private lateinit var dao: RepositoryDao

    @Before
    override fun setup() {
        super.setup()
        dao = super.database.repositoryDao()
    }

    @Test
    fun `get all repositories when db is empty then return empty list`() {
        runBlocking {
            val repos = dao.getAll()
            assertThat(repos, `is`(emptyList()))
        }
    }

    @Test
    fun `get all repositories then return 1`() {
        runBlocking {
            addFakeEntityToDb()
            val repos = dao.getAll()
            assertThat(repos.size, `is`(1))
        }
    }

    @Test
    fun `get repo when not exist return null`() {
        runBlocking {
            val repo = dao.get(-1)
            assertThat(repo, `is`(nullValue()))
        }
    }

    @Test
    fun `get repo when exist return repo`() {
        runBlocking {
            addFakeEntityToDb()
            val repo = dao.get(Constants.FAKE_ENTITY_MODEL.id)
            assertThat(repo, `is`(notNullValue()))
            assertThat(repo!!.id, `is`(Constants.FAKE_ENTITY_MODEL.id))
        }
    }

    @Test
    fun `insert repository into db then repositories size should be 1`() {
        runBlocking {
            addFakeEntityToDb()
            assertThat(dao.getAll().size, `is`(1))
        }
    }

    @Test
    fun `insert two same repository into db replace first with second repository return 1 repo`() {
        runBlocking {
            addFakeEntityToDb()
            assertThat(dao.getAll().size, `is`(1))
            assertThat(dao.getAll().first().name, `is`("Square Repository"))

            val newEntityWithSameId = RepositoryEntity(1L, "new repository", 0, true, "")
            dao.insert(newEntityWithSameId)

            assertThat(dao.getAll().size, `is`(1))
            assertThat(dao.getAll().first().name, `is`("new repository"))
        }
    }

    @Test
    fun `update exist repository bookmark to true then bookmark field should be true`() {
        runBlocking {
            addFakeEntityToDb()
            dao.update(Constants.FAKE_ENTITY_MODEL.id, true)
            assertThat(dao.get(Constants.FAKE_ENTITY_MODEL.id)?.isBookmarked, `is`(true))
        }
    }

    @Test
    fun `update exist repository bookmark to false then bookmark field should be false`() {
        runBlocking {
            addFakeEntityToDb()
            dao.update(Constants.FAKE_ENTITY_MODEL.id, false)
            assertThat(dao.get(Constants.FAKE_ENTITY_MODEL.id)?.isBookmarked, `is`(false))
        }
    }

    @Test
    fun `update non exist repository`() {
        runBlocking {
            dao.update(Constants.FAKE_ENTITY_MODEL.id, true)
            assertThat(dao.get(Constants.FAKE_ENTITY_MODEL.id), `is`(nullValue()))
        }
    }

    private fun addFakeEntityToDb() {
        runBlocking {
            val entity = Constants.FAKE_ENTITY_MODEL
            dao.insert(entity)
        }
    }
}