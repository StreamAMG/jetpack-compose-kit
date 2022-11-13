package com.sabero.jetpack.compose.toolkit.composable.modifiers

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope

fun ConstrainedLayoutReference.underConstrainModifier(
    underReference: ConstrainedLayoutReference,
    scope: ConstraintLayoutScope,
    margins: Margins
) : Modifier {
    val layoutRef = this
    scope.apply {

        return Modifier.constrainAs(ref = layoutRef) {
            margins.all?.let {
                start.linkTo(underReference.start, margin = it.dp)
                top.linkTo(underReference.bottom, margin = it.dp)
                end.linkTo(underReference.end, margin = it.dp)
            }
            margins.startEnd?.let {
                start.linkTo(underReference.start, margin = it.dp)
                end.linkTo(underReference.end, margin = it.dp)
            }
            margins.topBottom?.let {
                top.linkTo(underReference.bottom, margin = it.dp)
            }
            margins.start?.let { start.linkTo(underReference.start, margin = it.dp) }
            margins.top?.let { top.linkTo(underReference.bottom, margin = it.dp) }
            margins.end?.let { end.linkTo(underReference.end, margin = it.dp) }
        }.applyDefaults()
    }
}

fun Modifier.applyDefaults(): Modifier {
    return this.fillMaxWidth().padding(horizontal = 24.dp, vertical = 0.dp)
}