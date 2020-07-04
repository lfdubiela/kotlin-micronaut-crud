package io.example.helloworld.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import io.example.helloworld.domain.Profile

@Repository
interface ProfileRepository : CrudRepository<Profile, Long> {

}