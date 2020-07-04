package io.example.helloworld.domain

import javax.persistence.*

@Entity(name="profile")
data class Profile(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,
    @Column
    val name: String? = null
)