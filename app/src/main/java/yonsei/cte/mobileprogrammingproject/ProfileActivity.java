package yonsei.cte.mobileprogrammingproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends Activity implements AdapterView.OnItemClickListener {

    protected FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private String name, email, photoUrl, uid, emailVerified;
    private static final String TAG_TITLE = "title";
    private static final String TAG_DATE = "date";

    ArrayList<String> mItems;
    ArrayList<HashMap<String, String>> TitleList;
    ArrayAdapter<String> adapter;
    ListAdapter adapter2;
    TextView textYear;
    TextView textMonth;
    ListView list;

    Cursor month_list_cursor;
    DBHelper mDBHelper;
    SimpleCursorAdapter month_list_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //파이어베이스 정보를 같이 가져옴
        mAuth = FirebaseAuth.getInstance();

        //인텐트 설정 - 인텐트에 유저 정보를 같이 받아와줘야 한다.
        Intent intent = getIntent();
        FirebaseUser user = (FirebaseUser) intent.getSerializableExtra("user");

        //달력 정보 설정하는 부분
        textYear = (TextView) this.findViewById(R.id.edit_year);
        textMonth = (TextView) this.findViewById(R.id.edit_month);

        mItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mItems );

        GridView grid = (GridView) this.findViewById(R.id.cal);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(this);

        Date date = new Date();
        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        textYear.setText(year + "");
        textMonth.setText(month + "");

        fillDate(year, month);

        mDBHelper = new DBHelper(this, "Today.db", null, 1);
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        month_list_cursor = db.rawQuery("SELECT * FROM today ", null); // WHERE REGEXP_LIKE( date, '" + year + "/" + month  + "/*');", null);
        month_list_adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,
                month_list_cursor, new String[]{"title", "tile"},
                new int[] {android.R.id.text1, android.R.id.text2});


        list = (ListView) findViewById(R.id.month_schedule_list);
        TitleList = new ArrayList<HashMap<String,String>>();

        showList();
    }

    private void fillDate(int year, int month) {
        mItems.clear();

        mItems.add("일");
        mItems.add("월");
        mItems.add("화");
        mItems.add("수");
        mItems.add("목");
        mItems.add("금");
        mItems.add("토");

        Date current = new Date(year - 1900, month - 1, 1);
        int day = current.getDay(); //요일도 int로 저장

        for(int i=0; i<day; i++){
            mItems.add("");
        }

        current.setDate(32); //32일까지 입력하면 1일로 바꿔준다.
        int last = 32 - current.getDate();

        for(int i = 1 ; i<=last ; i++){
            mItems.add(i + "");
        }

        adapter.notifyDataSetChanged();
    }


    public void onCalClicked(View view) {
        int year = Integer.parseInt(textYear.getText().toString());
        int month = Integer.parseInt(textMonth.getText().toString());
        fillDate(year, month);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int arg1, long arg2) {
        if(mItems.get(arg1).equals("")){
            return;
        }else{
            // todo : 여기에.. 넣어주어야 한다. 아이템 클릭했을 때 추가하도
            Intent intent = new Intent(this, TodayActivity.class);
            intent.putExtra("year", textYear.getText().toString());
            intent.putExtra("month", textMonth.getText().toString());
            intent.putExtra("day", mItems.get(arg1));
            startActivity(intent);
            finish();
        }

    }

    public void showList(){

        try {

            mDBHelper = new DBHelper(this, "Today.db", null, 1);
            SQLiteDatabase db = mDBHelper.getWritableDatabase();


            //SELECT문을 사용하여 테이블에 있는 데이터를 가져옵니다..
            Cursor c = db.rawQuery("SELECT * FROM today" , null);

            if (c != null) {


                if (c.moveToFirst()) {
                    do {
                        String Title = c.getString(c.getColumnIndex("title"));
                        String Date = c.getString(c.getColumnIndex("date"));

                        //HashMap에 넣습니다.
                        HashMap<String,String> Titles = new HashMap<String,String>();

                        Titles.put(TAG_TITLE, Title);
                        Titles.put(TAG_DATE, Date);

                        //ArrayList에 추가합니다..
                        TitleList.add(Titles);

                    } while (c.moveToNext());
                }
            }

            db.close();


            //새로운 apapter를 생성하여 데이터를 넣은 후..
            adapter2 = new SimpleAdapter(
                    this, TitleList, R.layout.list_item,
                    new String[]{TAG_TITLE, TAG_DATE},
                    new int[]{ R.id.TV_title, R.id.TV_date}
            );


            //화면에 보여주기 위해 Listview에 연결합니다.
            list.setAdapter(adapter2);


        } catch (SQLiteException se) {
            Toast.makeText(getApplicationContext(),  se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("",  se.getMessage());
        }

    }
}
