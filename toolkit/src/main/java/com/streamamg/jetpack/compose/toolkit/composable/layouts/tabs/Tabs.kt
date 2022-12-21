package com.streamamg.jetpack.compose.toolkit.composable.layouts.tabs

import android.graphics.Typeface
import android.text.TextPaint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
fun Tabs(
    pagerState: PagerState,
    tabContentList: List<TabContent>,
    scrollable: Boolean
) {

    val scope = rememberCoroutineScope()
    if (scrollable) {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = Color.White,
            contentColor = Color(0xFF6d23f9),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    height = 2.dp,
                    color = Color(0xFF6d23f9)
                )
            }
        ) {
            buildTabs(tabContentList, pagerState, scope)
        }
    } else {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = Color.White,
            contentColor = Color(0xFF6d23f9),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    height = 2.dp,
                    color = Color(0xFF6d23f9)
                )
            }
        ) {
            buildTabs(tabContentList, pagerState, scope)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun buildTabs(
    tabContentList: List<TabContent>,
    pagerState: PagerState,
    scope: CoroutineScope
) {
    tabContentList.forEachIndexed { index, _ ->
        Tab(
            icon = {
                tabContentList[index].icon?.let { icon ->
                    Icon(imageVector = icon, contentDescription = null)
                }
            },
            text = {
                tabContentList[index].name?.let { name ->
                    Text(
                        name,
                        color = if (pagerState.currentPage == index) Color(0xFF6d23f9) else Color.LightGray,
                        fontFamily = FontFamily.Default,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            },
            selected = pagerState.currentPage == index,
            onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }
        )
    }
}