package yonsei.cte.mobileprogrammingproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ScheduleDetailActivity extends Activity implements
        View.OnClickListener {
    DBHelper mDBHelper;
    int mID;
    String today;
    EditText editDate, editTitle, editTime, editMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail);

        editDate = (EditText) findViewById(R.id.edit_date);
        editTitle = (EditText) findViewById(R.id.edit_title);
        editTime = (EditText) findViewById(R.id.edit_time);
        editMemo = (EditText) findViewById(R.id.edit_memo);

        Intent intent = getIntent();
        mID = intent.getIntExtra("ParamID", - 1);
        today = intent.getStringExtra("ParamDate");

        mDBHelper = new DBHelper(this, "Today.db", null, 1);

        if(mID == -1){
            editDate.setText(today);
        }else{
            SQLiteDatabase db = mDBHelper.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM today WHERE _id = " + mID + "'", null);

            if(cursor.moveToNext()){
                editTitle.setText(cursor.getString(1));
                editDate.setText(cursor.getString(2));
                editTime.setText(cursor.getString(3));
                editMemo.setText(cursor.getString(4));
            }
            mDBHelper.close();
        }

        Button btn_save = (Button) findViewById(R.id.btn_shedule_save);
        btn_save.setOnClickListener(this);
        Button btn_del = (Button) findViewById(R.id.btn_shedule_delete);
        btn_del.setOnClickListener(this);
        Button btn_cancel = (Button) findViewById(R.id.btn_schedule_cancel);
        btn_cancel.setOnClickListener(this);

        if(mID == -1){
            btn_del.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onClick(View view) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        switch(view.getId()){
            case R.id.btn_shedule_save:
                if(mID != -1){
                    db.execSQL("UPDATE today SET title = '"
                    + editTitle.getText().toString() + "', date = '"
                    + editDate.getText().toString() + "', tile = '"
                    + editTime.getText().toString() + "', memo = '"
                    + editMemo.getText().toString() + "' WHERE _id = "
                    + mID + "';");
                }
                else{
                    db.execSQL("INSERT INTO today(title, date, tile, memo) VALUES('"
                            + editTitle.getText().toString() + "', '"
                            + editDate.getText().toString() + "', '"
                            + editTime.getText().toString() + "', '"
                            + editMemo.getText().toString() + "');");
                }
                mDBHelper.close();
                setResult(RESULT_OK);

            case R.id.btn_shedule_delete:
                if(mID != -1){
                    db.execSQL("DELETE FROM today WHERE _id= '" + mID + "';");
                    mDBHelper.close();
                }
                setResult(RESULT_OK);
                break;

            case R.id.btn_schedule_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
