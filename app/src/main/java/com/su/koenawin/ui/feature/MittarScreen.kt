package com.su.koenawin.ui.feature

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.android.material.tabs.TabItem


@Composable
fun MittarScreen() {
    ParagraphView("မေတ္တသုတ်ပါဠိ\n" +
            "~~~~~~~~~~\n" +
            "၁။ ယဿာ နုဘာဝတောယက္ခာ၊\n" +
            "နေ၀ ဒေဿနိ ္တ ဘီသနံ။\n" +
            "ယဥှိ စေဝါ နုယုဉ္ဖနေ ္တာ၊\n" +
            "ရတ္တိန္ဒိ၀ မ-တန္ဒိတော။\n" +
            "၂။သုခံ သုပတိ သုတ္တောစ၊\n" +
            "ပါပံ ကိဉ္စိ နပဿတိ။\n" +
            "ဧ၀ မာဒိ-ဂုဏူပေတံ၊\n" +
            "ပရိတ္တံ တံဘဏာမ ဟေ။\n" +
            "၃။ ကရဏီယ မတ္ထ-ကုသလေန၊\n" +
            "ယန ္တသနံ ္တ ပဒံ အဘိသမေစ္စ။\n" +
            "သက္ကော ဥဇူ စ သုဟုဇူ စ၊\n" +
            "သုဝစော စဿ မုဒု အနတိမာနီ။\n" +
            "၄။ သန ္တုဿကော စ သု-ဘရောစ၊\n" +
            "အပ္ပကိစ္စော စ သလ္လဟုကဝုတ္တိ၊\n" +
            "သနိ ္တနြ္ဒိယော စ နိပကော စ၊\n" +
            "အပ္ပဂဗေ ္ဘာ ကုလေသွ နနုဂိဒ္ဓေါ။\n" +
            "၅။ န စ ခုဒ္ဒမာစရေ ကိဉ္စိ၊\n" +
            "ယေန ဝိညူ ပရေ ဥပဝဒေယျုံ။\n" +
            "သုခနော ၀ ခေမိနော ဟောန ္တု၊\n" +
            "သဗ္ဗသတ္တာ ဘ၀န ္တု သုခိတတ္ထာ။\n" +
            "၆။ ယေ ကေစိ ပါဏ ဘူတတ္ထိ၊\n" +
            "တသာ ဝါ ထာ၀ရာ၀ န၀ သေသာ။\n" +
            "ဒီဃာ ဝါယေ ၀ မဟန ္တာ၊\n" +
            "မဇ္စျိမာ ရဿကာ အဏုက-ထူလာ။\n" +
            "၇။ ဒိဋ္ဌာ ဝါယေ၀ အဒိဋ္ဌာ၊\n" +
            "ယေ၀ ဒူရေ ၀သနိ ္တ အဝိဒူရေ။\n" +
            "ဘူတာ ၀ သမ ၻေ၀ သီ၀၊\n" +
            "သဗ္ဗ သတ္တာ ဘ၀န ္ထု သုခိတတ္တာ။\n" +
            "၈။ န ပရော ပရံ နိကုဗ္ဗေထ၊\n" +
            "နာတိ မညေထ ကတ္ထစိ န ကဉ္စိ။\n" +
            "ဗျာရောသနာ ပဋိဃ-သည၊\n" +
            "နာည မညဿ ဒုက္ခ မိစေ ္ဆယျ။\n" +
            "၉။ မာတာ ယထာ နိယံ ပုတ္တ-\n" +
            "မာယုသာ ဧက-ပုတ္တ မနုရက္ခေ။\n" +
            "ဧ၀မ္ပိ သဗ္ဗ-ဘူတေသု၊\n" +
            "မာနသံ ဘာဝယေ အပရိမဏံ။\n" +
            "၁၀။ မေတ္တဉ္စ သဗ္ဗ လောကသ္မိ ံ၊\n" +
            "မာနသံ ဘာဝယေ အပရိမာဏံ။\n" +
            "ဥဒ္ဓံ အဓော စ တိရိယဉ္စ၊\n" +
            "အ-သမ္ဗာဓံ အ-ဝေရ မ-သပတံ္ထ။\n" +
            "၁၁။ တိဋ္ဌံ စရံ နိသိန္နော ၀၊\n" +
            "သယာနော ယာ၀တာဿ-ဝိတ-မိဒ္ဓေါ။\n" +
            "ဧတံ သတိ ံ အဓိဋ္ဌေယျ၊\n" +
            "ဗြဟ္မ မေတံ ဝိဟာရ’မိဓ မာဟု။\n" +
            "၁၂။ ဒီဌိဉ္စ အနုပဂ္ဂမ္မ၊\n" +
            "သီလဝါဒဿနေန သမ္ပန္နော။\n" +
            "ကာမေသု ဝိနေယျ ဂေဓံ၊\n" +
            "န ဟိ ဇာတုဂ္ဂဗ ္ဘသေယျ ပုန-ရေတိ။\n" +
            "မေတ္တ-သုတ္တံ နဋ္ဌိတံ။\n" +
            "မေတ္တာသုတ် - အနက်မြန်မာပြန်\n" +
            "~~~~~~~~~~~~~~~~~~~\n" +
            "၁။မေတ္တာသုတ်ပရိတ်ေ တာ်၏ တန်ခိုးရှိန်စော်အာနုဘော်ကြောင့်ဘီလူးကြမ်းတို့ သည် ကြောက်မက်ဖွယ်သောအဆင်းအသံအစရှိ\n" +
            "သော အာရုံတို့ကို မပြဝံ့ မခြောက်ဝံ့ကြလေ\n" +
            "က ုန်၊ မေတ္တာသုတ်ပရိတ်တော်ကို ညဥ့်အခါ၌လည်းကောင်း၊ နေ့အခါ၌လည်းကောင်း၊ မပျင်းမရိ လုံ့လပြု၍ ရွတ်ဖတ်သောသူသည်၊\n" +
            "၂။ချမ်းသာစွာအိပ်ရ ၏၊ အိပ်သော်လည်း မကောင်းသောအိပ်မက်ကိုတစိုးတစိ မျှ မမြင်မက်၊ ဤသို့အစရှိသောဂုဏ်ကျေးဇူးအပေါ င်းနှင့် ပြည့်စုံသောမေတ္တာသုတ်ပရိတ်တော်ကို အို-သူတော်ကောင်းတို့ငါတို့ရွတ်ဖတ်ကြပါကုန်စို့။\n" +
            "၃။လောကီလောကုတ္တရာအကျိုးစီးပွား၌ လိမ္မာသောသူသည် ငြိမ်သက်အေး ချမ်းသော နိဗ္ဗာန်ကိုအာရုံပြု၍ဤဆိုလတ္တံ့သော သူတော်ကောင်းနည်းလမ်းကိုကျင့်ကြံ အားထုတ် ပြုလုပ်အပ်၏၊ ကိုယ်နှင့်အသက်တ ို့ကို မငဲ့ကွက် မညှာတာပြုလုပ်ခြင်းငှာ စွမ်းနိုင်ရာ၏၊ ကိုယ်နှုတ်နှစ်ပါ းရိုးသားဖြောင့်မတ်ရာ၏၊ စိတ်သဘောထား ကောင်းစွာဖြောင့်မတ်ရာ၏၊ ဆိုဆုံးမလွယ်ရာ၏ ၊ နူးညံ့သိမ်မွေ့ရာ၏၊ သူတစ်ပါးအပေါ်ထောင်လွှားသော မာန်မာနမရှိရာ။\n" +
            "၄။ ရောင့်ရဲလွယ်ရာ၏ ၊ မွေးမြူလွယ်ရာ၏၊ နည်းပါးသောအမှုကိစ္စရှိရာ၏၊ ပေါ့ပါးသော အသက်မွေးခြင်း ရှိရာ၏၊ ငြိမ်သက်သောဣနြေ္ဒရှိရာ၏၊ အရာရာ၌ခွဲခြမ်းစိတ်ဖြာ ရဲရင့်သော ဉာဏ်ပညာရှိရာ၏၊ ကိုယ်နှုတ်နှလုံး သုံးပါးလုံး ရုန့်ရင်း ကြမ်းတမ်းမှုမရှိရာ၊ ဒါယကာတို့၌ တွယ်တာမက်မောမှုမရှိရ။\n" +
            "၅။ပညာရှိတို့ကဲ့ရဲ့ရှုတ်ချအပ် သောတစုံတစ်ခုသော မကောင်းမှုကိုအနည်းငယ်မျှသော်လည်း မပြုမလုပ်ရာ၊ ခပ်သိမ်းသောသတ္တဝါတို့သည် ကိုယ်၏ချမ်း သာခြင်းနှင့် ပြည့်စုံကြပါစေက ုန်သတည်း၊ စိတ်ချမ်းသာခြင်းနှင့် ပြည့်စုံကြပါစေ ကုန် သတည်း၊ ဘေးရန် ဥပဒ္ဒဝေါ မရှိကြပါစေကုန်သ တည်း။\n" +
            "၆။အကြွင်းမရှိ အလုံးစုံ ထွက်သက် ဝင်သက်ရှိသော သတ္တဝါ၊ ထင်ရှားရှိသောသတ္တဝါ၊ ထိတ်လန့် တတ်သောသတ္တဝါ၊ တည်ကြည်ငြိမ်သက်သော၊ သတ္တဝါ၊ ရှည်သောသတ္တဝါ၊ တိုသော သတ္တဝါ၊ ပုကွသောသတ္တဝါ၊ မတိုမရှည်သောသတ္တဝါ၊ ကြီးသော သတ္တဝါ၊ ငယ်သောသတ္တဝါ၊ မကြီးမငယ်သောသတ္တဝါ၊ ဆူသောသတ္တဝါ၊ ကြုံသောသတ္တဝါ၊ မဆူမကြုံသော သတ္တဝါ။\n" +
            "၇။မျက်စိဖြင့်မြင်ကောင်းသောသတ္တဝါ၊ မျက်စိဖြင့် မမြင်ကောင်းသောသတ္တဝါ၊ အဝေး၌နေသောသတ္တဝါ၊ အနီး၌နေသောသတ္တဝါ၊ ထင်ရှားဖြစ်ပေါ်\n" +
            "ပြီးသော သတ္တဝါ၊ ဖြစ်ဆဲတည်နေသောသတ္တဝါ၊ ဤအလုံးစုံသောသတ္တဝါတို့သည်ကိုယ်စိတ်နှစ်ဖြ ာ ချမ်းသာခြင်းရှိကြပါစေကုန်သတ ည်း။\n" +
            "၈။တစ်ယောက်သောသူကတစ်ယောက်သောသူကိ အမျက်မထွက်ပါစေလင့်၊ တစ်စုံတစ်ခုသော အမှုကိစ္စ၌တစ်ယောက်သောသူက တစ်ယောက်သောသူကိုညှဉ်းဆဲချုပ်ချယ်သော ကာယကံဝစီကံဖြင့်လည်းကောင်း၊ ခိုက်ရန်မျက်ပွာ း အငြိုးထားသောစိတ်ဖြင့်လည်းကောင်း၊ အနည်းငယ်မျှသော်မှ မထီမဲ့မြင် မအောက်မေ့ပါစေလင့်၊ အချင်းချင်း၏ ဆင်းရဲဒုက္ခကို အလိုမရှိပါစေလင့်။\n" +
            "၉။အမိသည် မိမိရင်သွေးဖြစ် သော တစ်ယောက်တည်းသော သားငယ်ကို အသက်အတွက်ကြောင့်အဖန်တလဲလဲ စောင့်ရှောက်သကဲ့သို့ ဤနည်းအတူ သာလျှင် ခပ်သိမ်းသောသတ္တဝါတို့၌အတိုင်းအရှည်မရှိ ိသော မေတ္တာစိတ်ကို ပွားစေရာ၏။\n" +
            "၁၀။ ကာမဘဝတည်းဟူသောအောက်လောက၌ လည်းကောင်း၊ ရူပဘဝတည်း ဟူသော အလယ်လောက၌လည်းကောင်း၊ အရူပဘဝတည်းဟူသော အထက်လောက၌ လည်းကောင်း၊ ဤလောကသုံးပါးတို့၌ ပိုင်းခြားလွတ်ကင်းကျဉ်းမြောင်းခြင်းလည် းမရှိ ကိုယ်တွင်းဘေးရန်လည်းမရှိ အပဘေးရန်လည်းမရှ အတိုင်းမသိ ချစ်ခင်မြတ်နိုး သောမေတ္တာစိတ်ကိုလည်း ပွားစေရာ၏။\n" +
            "၁၂။ရပ်နေစဉ်သော်လည် းကောင်း၊ သွားနေစဉ်သော် လည်းကောင်း၊ ထိုင် နေစဉ်သော် လည်းကောင်း၊ လဲလျောင်းနေစဉ်ေ သာ် လည်းကောင်း၊ မအိပ် မငိုက်သမျှ ကာလပတ်လုံးသာသနာတော်ကြီး၌ မေတ္တာစိတ်နှင့်ယှဉ်၍နေထိုင်ခြင်းကို ''မြတ်သောနေထိုင်ခြင်း''ဟူ၍မြတ်စွာဘုရားတို့ ဟောတော်မူ ကုန်၏။\n" +
            "၁၃။ မေတ္တာကမ္မဋ္ဌာန်းကိ ုစီးဖြန်းအားထုတ် ပြုလုပ်သောသူသည် အမြင်ဖောက် ပြန် မိစ္ဆာဉာဏ်သို့ မကပ်မရောက်သောကြောင့် လောကုတ္တရာသီလ ရှိသည် ဖြစ်၍မဂ်ဉာဏ်အမြင်နှင့်ပြည့်စုံပြီးလျှင် ဝတ္ထုကာမ ကိလေသာ ကာမ တို့၌တပ်မက်မောခြင်း ကင်းသောကြောင့် နောက်တဖန်အမိဝမ်းတွင်း ပဋိသန္ဓေနေခြင်းသို့ ဧကန်မရောက်တော့ပြီ ။\n" +
            "မေတ္တသုတ်မြန်မာပြန်ပြီးပါပြီ\n" +
            "ဓမ္မမိတ်ဆွေများအားလုံး နိဗ္ဗာန်၏အထောက်အပံ့ဖြစ်ကြပါစေ...။")
//    Column() {
//        var selectedTabIndex by remember { mutableStateOf(0) }
//        val tabs = listOf("Fruits", "Vegetables", "Meats", "Miscellaneous")
//        CustomScrollableTabRow(
//            tabs = tabs,
//            selectedTabIndex = selectedTabIndex,
//        ) { tabIndex ->
//            selectedTabIndex = tabIndex
//        }
//
//    }

}
//@Composable https://johncodeos.com/how-to-create-tabs-with-jetpack-compose/
//fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
//    HorizontalPager(state = pagerState, count = tabs.size) { page ->
//        tabs[page].screen()
//    }
//}


@Composable
fun CustomScrollableTabRow(
    tabs: List<String>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit
) {
    val density = LocalDensity.current
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()
        repeat(tabs.size) {
            tabWidthStateList.add(0.dp)
        }
        tabWidthStateList
    }
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = Color.White,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabIndicatorOffset(
                    currentTabPosition = tabPositions[selectedTabIndex],
                    tabWidth = tabWidths[selectedTabIndex]
                )
            )
        }
    ) {
        tabs.forEachIndexed { tabIndex, tab ->
            Tab(
                selected = selectedTabIndex == tabIndex,
                onClick = { onTabClick(tabIndex) },
                text = {
                    Text(
                        text = tab,
                        onTextLayout = { textLayoutResult ->
                            tabWidths[tabIndex] =
                                with(density) { textLayoutResult.size.width.toDp() }
                        }
                    )
                }
            )
        }
    }
}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}

@Composable
fun ParagraphView(text:String) {
    val scroll = rememberScrollState(0)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scroll)
    ) {
        Text(text,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}