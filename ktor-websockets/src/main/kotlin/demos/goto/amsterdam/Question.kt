package demos.goto.amsterdam

import kotlinx.serialization.Serializable

@Serializable
data class Question(var id: Long, var title: String)