package com.streamamg.jetpack.compose.toolkit.composable.modifiers


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope

@Composable
fun ConstrainedLayoutReference.innerConstrainModifier(
    scope: ConstraintLayoutScope,
    margins: Margins
) : Modifier {
    val layoutRef = this
    scope.apply {
        return Modifier.constrainAs(ref = layoutRef) {
            margins.all?.let {
                start.linkTo(parent.start, margin = it.dp)
                top.linkTo(parent.top, margin = it.dp)
                end.linkTo(parent.end, margin = it.dp)
                bottom.linkTo(parent.bottom, margin = it.dp)
            }
            margins.startEnd?.let {
                start.linkTo(parent.start, margin = it.dp)
                end.linkTo(parent.end, margin = it.dp)
            }
            margins.topBottom?.let {
                top.linkTo(parent.top, margin = it.dp)
                bottom.linkTo(parent.bottom, margin = it.dp)
            }
            margins.start?.let { start.linkTo(parent.start, margin = it.dp) }
            margins.top?.let { top.linkTo(parent.top, margin = it.dp) }
            margins.end?.let { end.linkTo(parent.end, margin = it.dp) }
            margins.bottom?.let { bottom.linkTo(parent.bottom, margin = it.dp) }
        }.applyDefaults()
    }
}