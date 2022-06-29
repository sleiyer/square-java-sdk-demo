package com.example.squarejavasdkdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan
class SquareJavaSdkDemoApplication

fun main(args: Array<String>) {
	runApplication<SquareJavaSdkDemoApplication>(*args)
}
