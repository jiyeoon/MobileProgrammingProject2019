package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button velcro_btn;
    Button dd_btn;
    Button zipper_btn;
    Button stud_btn;
    Button btn_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        velcro_btn = (Button) findViewById(R.id.btn_start_vcr);
        dd_btn     = (Button) findViewById(R.id.btn_start_ddbtn);
        zipper_btn = (Button) findViewById(R.id.btn_start_zipper);
        stud_btn   = (Button) findViewById(R.id.btn_start_stud);
        btn_btn    = (Button) findViewById(R.id.btn_start_btn);
        Setclicklistener();
    }

    public void Setclicklistener(){

        velcro_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, VelcroActivity.class);
                startActivity(intent);
            }
        });
        dd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DdbtnActivity.class);
                startActivity(intent);
            }
        });
        zipper_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ZipperActivity.class);
                startActivity(intent);
            }
        });
        stud_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, StudActivity.class);
                startActivity(intent);
            }
        });
        btn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, BtnActivity.class);
                startActivity(intent);
            }
        });
    }
}
