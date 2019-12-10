package yonsei.cte.mobileprogrammingproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class TodayActivity extends Activity implements AdapterView.OnItemClickListener {
    DBHelper mDBHelper;
    String today;
    Cursor cursor;
    Cursor month_list_cursor;

    SimpleCursorAdapter adapter;
    SimpleCursorAdapter month_list_adapter;

    ListView list;

    String year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        Intent intent = getIntent();
        year = intent.getStringExtra("year");
        month = intent.getStringExtra("month");
        day = intent.getStringExtra("day");

        today = year + "/" + month + "/" + day;

        mDBHelper = new DBHelper(this, "Today.db", null, 1);
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        cursor = db.rawQuery("SELECT * FROM today WHERE date = '" + today + "'", null);

        adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,
                cursor, new String[]{"title", "tile"}, //time인데.. tile로 오타가..
                new int[] {android.R.id.text1, android.R.id.text2});

        ListView list = (ListView) findViewById(R.id.list1);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

        mDBHelper.close();

    }


    public void onCalAddButtonClicked(View view) {
        // todo : 일정 추가 버튼을 우르면 가게끔!!
        Intent intent = new Intent(this, ScheduleDetailActivity.class);
        intent.putExtra("ParamID", today);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        // todo : 해당 날짜의 일정 클릭했을 때!
        Intent intent = new Intent(this, ScheduleDetailActivity.class);
        cursor.moveToPosition(position);

        intent.putExtra("ParamDate", cursor.getInt(0));
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0: //그냥 일정추가 했을 떼는 암것도 없음
            case 1: //애드 했으면.. 1을 추가함
                if(resultCode == RESULT_OK){
                    SQLiteDatabase db = mDBHelper.getWritableDatabase();
                    cursor = db.rawQuery("SELECT * FROM today WHERE date = '" + today + "'", null);
                    adapter.changeCursor(cursor);
                    mDBHelper.close();
                }
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent = new Intent(TodayActivity.this, ProfileActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
