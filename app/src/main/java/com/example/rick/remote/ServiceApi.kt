package com.example.rick.remote

import com.example.rick.data.model.CharacterResponse
import

interface ServiceApi {
    @GET()
    fun getAllCharacters() : CharacterResponse
}