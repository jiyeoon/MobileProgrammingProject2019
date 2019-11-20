package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DdbtnActivity extends AppCompatActivity {

    Button home_btn, next_btn, prev_btn;
    ImageView one_image, two_image, three_image, four_image, five_image;
    TextView one_text, two_text, three_text, four_text, five_text;
    int btn_condition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddbtn);

        home_btn = (Button) findViewById(R.id.btn_go_home2);
        next_btn = (Button) findViewById(R.id.btn_go_next);
        prev_btn = (Button) findViewById(R.id.btn_go_prev);
        one_text = (TextView) findViewById(R.id.ddbtn_1text);
        two_text = (TextView) findViewById(R.id.ddbtn_2text);
        three_text = (TextView) findViewById(R.id.ddbtn_3text);
        four_text = (TextView) findViewById(R.id.ddbtn_4text);
        five_text = (TextView) findViewById(R.id.ddbtn_5text);
        one_image = (ImageView) findViewById(R.id.ddbtn_1image);
        two_image = (ImageView) findViewById(R.id.ddbtn_2image);
        three_image = (ImageView) findViewById(R.id.ddbtn_3image);
        four_image = (ImageView) findViewById(R.id.ddbtn_4image);
        five_image = (ImageView) findViewById(R.id.ddbtn_5image);

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DdbtnActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_condition = btn_condition + 1;

            }
        });
    }

    private void setCondition(int btn_condition){
        switch (btn_condition) {
            case 0:
                one_text.setVisibility(View.VISIBLE);
                two_text.setVisibility(two_text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        }
    }
}