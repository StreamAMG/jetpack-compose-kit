package com.streamamg.jetpack.compose.toolkit.composable.layouts.tabs

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(pagerState: PagerState, tabs: List<TabContent>) {
    HorizontalPager(state = pagerState) { page ->
        tabs[page].content()
    }
}