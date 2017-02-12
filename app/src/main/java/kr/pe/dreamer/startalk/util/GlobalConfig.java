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

    private void putString(Context context, String key, String value) {
        SharedPreferences pref = context.getSharedPreferences("Talk", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private String getString(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences("Talk", Activity.MODE_PRIVATE);
        return pref.getString(key, null);
    }

    public void setId(Context context, String value) {
        putString(context, "id", value);
    }

    public String getId(Context context) {
        return getString(context, "id");
    }
}
