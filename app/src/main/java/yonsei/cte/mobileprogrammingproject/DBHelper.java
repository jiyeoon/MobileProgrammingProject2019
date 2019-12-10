package yonsei.cte.mobileprogrammingproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // todo : 새로 생겼을 때 - 테이블 새로 생성하는 부
        sqLiteDatabase.execSQL("CREATE TABLE today(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
               + "title TEXT, " + "date TEXT, " + "tile TEXT, " + "memo TEXT );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // todo : 업데이트 되었을 때
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS today;");
        onCreate(sqLiteDatabase);
    }

}
