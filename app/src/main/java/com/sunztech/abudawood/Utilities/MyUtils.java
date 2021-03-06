package com.sunztech.abudawood.Utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class MyUtils {

    public static void setTypeface(Context context, TextView tvArabic, TextView tvUrdu, TextView tvEng) {
        if (tvEng != null) {

            Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/liberationsans-regular.ttf");
            tvEng.setTypeface(type);
        }
        if (tvUrdu != null) {
            Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/jameel_noori_nastaleeq.ttf");
            tvUrdu.setTypeface(type);
        }
        if (tvArabic != null) {
            Typeface typeArabic = Typeface.createFromAsset(context.getAssets(), "fonts/noorehuda.ttf");
            tvArabic.setTypeface(typeArabic);
        }

    }

    public static void setRadioTypeFace(Context context,RadioButton radioButton)
    {
        Typeface type = Typeface.createFromAsset(context.getAssets(), "fonts/liberationsans-regular.ttf");
        radioButton.setTypeface(type);
    }

    public static void changeToolbarFont(Toolbar toolbar, Activity context) {
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View view = toolbar.getChildAt(i);
            if (view instanceof TextView) {
                TextView tv = (TextView) view;
                if (tv.getText().equals(toolbar.getTitle())) {
                    MyUtils.setTypeface(context, null, null, tv);
                    break;
                }
            }
        }
    }

    public static void shareContent(String content, Context context) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);
        context.startActivity(Intent.createChooser(sharingIntent, "Share Text"));
    }

    public static String refactorColumn(String columnName) {
        switch (columnName) {
            case "English":
                return "English";
            case "Urdu":
                return "Urdu";
            case "Hadees No.":
                return "hadees_number";
            case "Ravi":
                return "Ravi";
            default:
                return "English";
        }

    }

    public static void changeTabFont(TabLayout tabLayout, Context context)
    {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    MyUtils.setTypeface(context,null,null,(TextView) tabViewChild);
                }
            }
        }

    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void shareApp(String content, Context context) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, content);
        context.startActivity(Intent.createChooser(sharingIntent, "Share Text"));
    }

}
