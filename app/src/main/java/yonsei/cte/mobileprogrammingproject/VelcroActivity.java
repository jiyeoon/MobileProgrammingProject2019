package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VelcroActivity extends AppCompatActivity {

    Button home_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velcro);

        home_btn = (Button) findViewById(R.id.btn_go_home4);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VelcroActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}