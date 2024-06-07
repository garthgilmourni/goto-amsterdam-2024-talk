package demos.goto.amsterdam.queries

import com.expediagroup.graphql.server.operations.Query
import demos.goto.amsterdam.StackExchangeClient

class StackOverflowQuery : Query {
    private val client = StackExchangeClient()

    suspend fun questions(userID: String) = client.fetchQuestions(userID.toInt())
}