package demos.goto.amsterdam

import io.ktor.client.HttpClient
import io.ktor.client.engine.*
import io.ktor.client.request.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.compression.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.http.HttpStatusCode.Companion.OK

import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.io.*
import org.jetbrains.kotlinx.dataframe.api.*

const val ROOT_URL = "https://api.stackexchange.com/2.3/users/"

class StackExchangeClient(engine: HttpClientEngine) {
    private val client = HttpClient(engine) {
        install(ContentEncoding) {
            gzip()
            deflate()
        }
        defaultRequest {
            url(ROOT_URL)
        }
    }

    val items = column<DataFrame<*>>("items")
    val questionId = column<Long>("question_id")
    val questionTitle = column<String>("title")

    private suspend fun fetchRawData(userID: Long): HttpResponse {
        val response = client.get {
            accept(ContentType.parse("text/plain"))
            url("$userID/questions?site=stackoverflow")
        }
        return response
    }

    suspend fun fetchQuestions(userID: Long): List<Question> {
        val response = fetchRawData(userID)
        if(response.status != OK) {
            return emptyList()
        }

        val text = response.bodyAsText()
        val dataFrame = DataFrame.readJsonStr(text)
        return dataFrame
            .map { items() }
            .first()
            .map {
                Question(questionId(), questionTitle())
            }
    }
}