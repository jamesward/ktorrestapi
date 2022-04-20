package ktorrestapi

import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.*

@Serializable
data class Employee(val id: String, val fullName: String, val location: String, val jobTitle: String)

fun main() {

    val employees = listOf(
        Employee("300", "Walt Longmire", "WYG", "Sheriff"),
        Employee("301", "Vic Moretti", "WYG", "Deputy"),
    )

    embeddedServer(CIO, port = 8080) {
        install(ContentNegotiation) {
            json()
        }

        routing {
            get("/employees") {
                call.respond(employees)
            }
        }
    }.start(wait = true)
}