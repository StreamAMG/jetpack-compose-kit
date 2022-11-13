package com.sabero.jetpack.compose.toolkit.composable.layouts



import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sabero.jetpack.compose.toolkit.composable.modifiers.MARGIN_MEDIUM
import com.sabero.jetpack.compose.toolkit.composable.modifiers.Margins
import com.sabero.jetpack.compose.toolkit.composable.modifiers.innerConstrainModifier

@Composable
fun HomeLayout() {
    ConstraintLayout {
        val (logo) = createRefs()

        val logoModifier = logo.innerConstrainModifier(
            scope = this,
            margins = Margins(top = 100, startEnd = MARGIN_MEDIUM)
        )
        Text(text = "Home Screen", modifier = logoModifier, fontSize = 22.sp, color = Color(0xFFBB86FC))

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeLayout()
}