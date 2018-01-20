package kr.pe.dreamer.startalk.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rhdlr on 2017-02-26.
 */

public class SQLManager extends SQLiteOpenHelper {
    private static int version = 0;
    private static String name = "starTalk";
    private static SQLManager instance;

    public SQLManager(Context context) {
        super(context, name, null, version);
    }

    public static SQLManager getInstance(Context context) {
        if (instance == null) {
            instance = new SQLManager(context);
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
