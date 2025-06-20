package com.sd.laborator

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.runtime.Micronaut

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.run(Application::class.java, *args)
    }

    @Controller
    class LambdaController {
        @Post
        fun execute(@Body book: Book?): BookSaved? {
            return handler.execute(book)
        }

        companion object {
            private val handler = BookRequestHandler()
        }
    }
}