package com.streamamg.jetpack.compose.toolkit.composable.layouts


import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.streamamg.jetpack.compose.toolkit.composable.layouts.tabs.TabContent
import com.streamamg.jetpack.compose.toolkit.composable.layouts.tabs.TabLayout


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeLayout(title: String, tabs: List<TabContent>, scrollable: Boolean = false) {
    TabLayout(title = title, tabs = tabs, scrollable = scrollable)
}