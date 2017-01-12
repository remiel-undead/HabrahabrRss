package com.example.undead.habrahabrrss.utils;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

public class StringUtils {
    public static String excludeHtmlImgs(String string) {
        return string.replaceAll("<img.+?>", "");
    }

    public static String excludeHtml(String string) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return excludeExtraSpaces(Html.fromHtml(StringUtils.excludeHtmlImgs(string), Html.FROM_HTML_MODE_COMPACT).toString());
        } else {
            return excludeExtraSpaces(Html.fromHtml(StringUtils.excludeHtmlImgs(string)).toString());
        }
    }

    public static String excludeHtmlBrs(String string) {
        return string.replaceAll("<(?!br|/br).+?>", "");
    }

    public static String excludeExtraSpaces(String string) {
        return string.replaceAll("\\s+", " ").trim();
    }

    public static Spanned htmlToSpanned(String string) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(string, Html.FROM_HTML_MODE_COMPACT);
        } else {
            return Html.fromHtml(string);
        }
    }
}
