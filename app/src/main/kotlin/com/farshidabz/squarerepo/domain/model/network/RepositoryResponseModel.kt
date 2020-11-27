package com.farshidabz.squarerepo.domain.model.network

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.util.*

@Keep
data class RepositoryResponseModel(
    @SerializedName("private")
    val isPrivate: Boolean = false,
    val id: Long = 0,
    val node_id: String? = null,
    val name: String? = null,
    val full_name: String? = null,
    val owner: Owner? = null,
    val html_url: String? = null,
    val description: String? = null,
    val fork: Boolean = false,
    val url: String? = null,
    val forks_url: String? = null,
    val keys_url: String? = null,
    val collaborators_url: String? = null,
    val teams_url: String? = null,
    val hooks_url: String? = null,
    val issue_events_url: String? = null,
    val events_url: String? = null,
    val assignees_url: String? = null,
    val branches_url: String? = null,
    val tags_url: String? = null,
    val blobs_url: String? = null,
    val git_tags_url: String? = null,
    val git_refs_url: String? = null,
    val trees_url: String? = null,
    val statuses_url: String? = null,
    val languages_url: String? = null,
    val stargazers_url: String? = null,
    val contributors_url: String? = null,
    val subscribers_url: String? = null,
    val subscription_url: String? = null,
    val commits_url: String? = null,
    val git_commits_url: String? = null,
    val comments_url: String? = null,
    val issue_comment_url: String? = null,
    val contents_url: String? = null,
    val compare_url: String? = null,
    val merges_url: String? = null,
    val archive_url: String? = null,
    val downloads_url: String? = null,
    val issues_url: String? = null,
    val pulls_url: String? = null,
    val milestones_url: String? = null,
    val notifications_url: String? = null,
    val labels_url: String? = null,
    val releases_url: String? = null,
    val deployments_url: String? = null,
    val created_at: Date? = null,
    val updated_at: Date? = null,
    val pushed_at: Date? = null,
    val git_url: String? = null,
    val ssh_url: String? = null,
    val clone_url: String? = null,
    val svn_url: String? = null,
    val homepage: String? = null,
    val size: Int = 0,
    val stargazers_count: Int = 0,
    val watchers_count: Int = 0,
    val language: String? = null,
    val has_issues: Boolean = false,
    val has_projects: Boolean = false,
    val has_downloads: Boolean = false,
    val has_wiki: Boolean = false,
    val has_pages: Boolean = false,
    val forks_count: Int = 0,
    val mirror_url: String? = null,
    val archived: Boolean = false,
    val disabled: Boolean = false,
    val open_issues_count: Int = 0,
    val license: License? = null,
    val forks: Int = 0,
    val open_issues: Int = 0,
    val watchers: Int = 0,
    val default_branch: String? = null,
    val permissions: Permissions? = null
)

@Keep
data class License(
    val key: String? = null,
    val name: String? = null,
    val spdx_id: String? = null,
    val url: String? = null,
    val node_id: String? = null
)

@Keep
data class Permissions(
    val admin: Boolean = false,
    val push: Boolean = false,
    val pull: Boolean = false
)

@Keep
data class Owner(
    val login: String? = null,
    val id: Int = 0,
    val node_id: String? = null,
    val avatar_url: String? = null,
    val gravatar_id: String? = null,
    val url: String? = null,
    val html_url: String? = null,
    val followers_url: String? = null,
    val following_url: String? = null,
    val gists_url: String? = null,
    val starred_url: String? = null,
    val subscriptions_url: String? = null,
    val organizations_url: String? = null,
    val repos_url: String? = null,
    val events_url: String? = null,
    val received_events_url: String? = null,
    val type: String? = null,
    val site_admin: Boolean = false
)