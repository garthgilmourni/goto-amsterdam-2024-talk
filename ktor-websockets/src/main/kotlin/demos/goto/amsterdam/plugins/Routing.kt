package demos.goto.amsterdam.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello GOTO Amsterdam 2024!")
        }
        staticResources("/static", "static")
    }
}
