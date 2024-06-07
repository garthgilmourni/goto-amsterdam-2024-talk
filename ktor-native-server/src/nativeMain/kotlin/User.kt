import kotlinx.serialization.Serializable

val MOCK_USERS = listOf(
    User("1", "John", "john@ktor.io", "UK"),
    User("2", "Kate", "kate@ktor.io", "UK"),
    User("3", "Rick", "rick@ktor.io", "UK"),
    User("4", "Fill", "fill@ktor.io", "UK"),
    User("5", "Anna", "anna@ktor.io", "UK"),
)


@Serializable
data class User(val id: String, val name: String, val email: String, val country: String)
