package com.su.core_data

import com.su.core_model.KoeNaWinUiData
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl : MainRepository {
    override fun getKoeNaWinList(): ArrayList<KoeNaWinUiData> {
        var mockData = ArrayList<KoeNaWinUiData>()
        mockData.add(KoeNaWinUiData(id = "01","တနင်္လာ","သမ္မာသမ္ဗုဒ္ဓေါ","","(၂)ပတ်",2))
        mockData.add(KoeNaWinUiData(id = "02","အင်္ဂါ","ဘဂဝါ","","(၉)ပတ်",9))
        mockData.add(KoeNaWinUiData(id = "03","ဗုဒ္ဓဟူး","သုဂတေ","ကောင်းသောစကားကို ဆိုတော်မူသောမြတ်စွာဘုရား။(မှန်ကန်၍ အကျိုးရှိသော စကားကို ဆိုတော်မူသောမြတ်စွာဘုရား။)" +
                "ကောင်းသောနိဗ္ဗာန်သို့ကြွတော်မူသော မြတ်စွာဘုရား။","(၄)ပတ်",4))
        mockData.add(KoeNaWinUiData(id = "04","ကြာသပတေး","သတ္တာဒေဝမနုဿာနံ","လူ ၊ နတ်၊ဗြဟ္မာ သတ္တဝါအားလုံးတို့၏ ဆရာတစ်ဆူဖြစ်တော်\n" +
                "မူသောမြတ်စွာဘုရား။","(၇)ပတ်",7))
        mockData.add(KoeNaWinUiData(id = "05","သောကြာ","လောကဝိဒူ","","(၅)ပတ်",5))
        mockData.add(KoeNaWinUiData(id = "06","စနေ","ဝိဇ္ဇစရဏသမ္မန္နော","","(၃)ပတ်",3))
        mockData.add(KoeNaWinUiData(id = "07","တနင်္ဂနွေ","အနုတ္တရောပုရိသဓမ္မသာရတိ","","(၆)ပတ်",6))
        // 2nd
        mockData.add(KoeNaWinUiData(id = "08","တနင်္လာ","အရဟံ","လူ၊ နတ်၊ ဗြဟ္မာ၊ သတ္တဝါအားလုံးတို့၏ ပူဇော်အထူးကို ခံယူတော်မူထိုက်သောမြတ်စွာဘုရား။","(၁)ပတ်",1))
        mockData.add(KoeNaWinUiData(id = "09","အင်္ဂါ","ဗုဒ္ဓေ","သစ္စာလေးပါးကို ကိုယ်တိုင်လည်း သိတော်မူ၊သူတစ်ပါးတို့ကိုလည်း သိအောင်\n" +
                "ဟောတော်မူတတ်သောမြတ်စွာဘုရား။","(၈)ပတ်",8))
        mockData.add(KoeNaWinUiData(id = "10","ဗုဒ္ဓဟူး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "11","ကြာသပတေး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "12","သောကြာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "13","စနေ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "14","တနင်္ဂနွေ","","","()ပတ်",0))
        //3rd
        mockData.add(KoeNaWinUiData(id = "08","တနင်္လာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "09","အင်္ဂါ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "10","ဗုဒ္ဓဟူး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "11","ကြာသပတေး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "12","သောကြာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "13","စနေ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "14","တနင်္ဂနွေ","","","()ပတ်",0))
        //4th
        mockData.add(KoeNaWinUiData(id = "08","တနင်္လာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "09","အင်္ဂါ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "10","ဗုဒ္ဓဟူး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "11","ကြာသပတေး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "12","သောကြာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "13","စနေ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "14","တနင်္ဂနွေ","","","()ပတ်",0))
        //5th
        mockData.add(KoeNaWinUiData(id = "08","တနင်္လာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "09","အင်္ဂါ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "10","ဗုဒ္ဓဟူး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "11","ကြာသပတေး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "12","သောကြာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "13","စနေ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "14","တနင်္ဂနွေ","","","()ပတ်",0))
        //6th
        mockData.add(KoeNaWinUiData(id = "08","တနင်္လာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "09","အင်္ဂါ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "10","ဗုဒ္ဓဟူး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "11","ကြာသပတေး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "12","သောကြာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "13","စနေ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "14","တနင်္ဂနွေ","","","()ပတ်",0))
        //7th
        mockData.add(KoeNaWinUiData(id = "08","တနင်္လာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "09","အင်္ဂါ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "10","ဗုဒ္ဓဟူး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "11","ကြာသပတေး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "12","သောကြာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "13","စနေ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "14","တနင်္ဂနွေ","","","()ပတ်",0))
        //8th
        mockData.add(KoeNaWinUiData(id = "08","တနင်္လာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "09","အင်္ဂါ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "10","ဗုဒ္ဓဟူး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "11","ကြာသပတေး","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "12","သောကြာ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "13","စနေ","","","()ပတ်",0))
        mockData.add(KoeNaWinUiData(id = "14","တနင်္ဂနွေ","","","()ပတ်",0))
        return mockData
    }
}