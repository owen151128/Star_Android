package kr.pe.dreamer.startalk.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by rhdlr on 2017-02-12.
 */

public class GlobalConfig {
    private static GlobalConfig instance;

    private GlobalConfig() {

    }

    public static GlobalConfig getInstance() {
        if (instance == null) {
            instance = new GlobalConfig();
        }

        return instance;
    }

    private SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("Talk", Activity.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences pref = getSharedPreferences(context);
        return pref.edit();
    }

    private void putString(Context context, String key, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.commit();
    }

    private String getString(Context context, String key) {
        SharedPreferences pref = getSharedPreferences(context);
        return pref.getString(key, null);
    }


    private void putBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(key, value);
        editor.commit();
    }

    private boolean getBoolean(Context context, String key) {
        SharedPreferences pref = getSharedPreferences(context);
        return pref.getBoolean(key, false);
    }

    public void setId(Context context, String value) {
        putString(context, "id", value);
    }

    public String getId(Context context) {
        return getString(context, "id");
    }

    public void setLogin(Context context, boolean value) {
        putBoolean(context, "login", value);
    }

    public boolean isLogin(Context context) {
        return getBoolean(context, "login");
    }
}
