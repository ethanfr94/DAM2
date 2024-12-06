package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    // @StringRes y @DrawableRes son anotaciones que indican que el valor de la propiedad debe ser una referencia de recurso.
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
