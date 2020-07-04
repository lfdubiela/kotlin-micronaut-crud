package io.example.helloworld.services

import io.example.helloworld.domain.Profile
import io.example.helloworld.repository.ProfileRepository
import javax.inject.Inject
import javax.inject.Singleton
import javax.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Singleton
@Transactional
open class ProfileService {

    @Inject
    open lateinit var profileRepository: ProfileRepository

    open fun save(profile: Profile): Profile {
        log.info("Saving Profile :{}", profile)
        profileRepository.save(profile)
        return profile
    }

    open fun findById(id: Long): Profile {
        log.info("Finding Profile by id:{}", id)
        return profileRepository.findById(id).orElse(null)
    }

    open fun deleteById(id: Long): Boolean {
        try {
            profileRepository.deleteById(id)
            log.info("Deleting Profile by id:{}", id)
            return true
        } catch (e: Exception) {
            log.error("Failed to delete Profile by id:{}", id)
            e.printStackTrace()
            return false
        }
    }

    open fun findAll(): Iterable<Profile> {
        log.info("Find All")
        return profileRepository.findAll()
    }

    open fun update(profile: Profile): Profile {
        log.info("update {}", profile)
        return profileRepository.update(profile)

    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(ProfileService::class.java)
    }
}