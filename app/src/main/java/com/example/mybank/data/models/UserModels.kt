package com.example.mybank.data.models

import com.google.gson.annotations.SerializedName

class UserModels {
}

data class PersonalizationState(
    @SerializedName("enabled")
    val enabled: Boolean
)