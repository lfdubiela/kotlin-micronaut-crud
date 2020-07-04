package io.example.helloworld.resource

import io.micronaut.http.annotation.*
import io.example.helloworld.domain.Profile
import io.example.helloworld.services.ProfileService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Inject

@Controller("/api/profile")
class ProfileController {

    @Inject
    lateinit var profileService: ProfileService

    @Post("/save")
    fun save(@Body profile: Profile): Profile {
        log.info("Saving Profile :{}", profile)
        return profileService.save(profile)
    }

    @Get("/get")
    fun findById(id: Long): Profile {
        log.info("Finding Profile: {}", id)
        return profileService.findById(id)
    }

    @Delete("/delete/{id}")
    fun deleteById(id: Long): Boolean {
        log.info("Deleting Profile: {}", id)
        return profileService.deleteById(id)
    }

    @Get("/findAll")
    fun findAll(): Iterable<Profile> {
        log.info("find All")
        return profileService.findAll()
    }

    @Put("/update")
    fun update(@Body profile: Profile): Profile {
        log.info("update {}", profile)
        return profileService.update(profile)
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(ProfileController::class.java)
    }
}