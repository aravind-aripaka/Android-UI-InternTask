package com.example.intern;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

public class Utility {
    public static Userdata userdata;
    public static SpannableString getMultifontString(String stringbold, String name, String subheader){
        String fullname = stringbold +"\n" + name+"\n" + subheader +"";
        SpannableString spannableString = new SpannableString(fullname);
        //spannableString.setSpan(new RelativeSizeSpan(1f), 0,header.length(), 0); // set size
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, stringbold.length(), 0);
        //spannableString.setSpan(FontStyle., header.length()+1,newHeader.length(), 0);

        return spannableString;
    }
}
