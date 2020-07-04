package io.example.helloworld

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("io.example.helloworld")
		.start()
}

