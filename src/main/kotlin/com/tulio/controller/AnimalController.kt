package com.tulio.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/animal")
class AnimalController {

    @PostMapping()
    fun createAnimal() {
        //Todo
    }

    @GetMapping()
    fun findAnimal() {
        //Todo
    }

    @PatchMapping()
    fun updateAnimal() {
        //Todo
    }

    @DeleteMapping()
    fun deleteAnimal() {
        //Todo
    }
}