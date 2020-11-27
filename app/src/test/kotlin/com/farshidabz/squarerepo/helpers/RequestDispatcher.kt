package com.farshidabz.squarerepo.helpers

import com.farshidabz.squarerepo.helpers.Constants.REPOSITORIES_API
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

/**
 * Handles Requests from mock web server
 */
internal class RequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            REPOSITORIES_API -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson("json/repo_list_response.json"))
            }

            else -> throw IllegalArgumentException("Unknown Request Path ${request.path.toString()}")
        }
    }
}