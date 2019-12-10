package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class CloseoropenActivity extends AppCompatActivity {

    Intent intent;
    int clothtype;
    Button clothopen, clothclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closeoropen);
        intent = getIntent();
        clothtype = intent.getIntExtra("ClothType", 0);

        clothopen = (Button) findViewById(R.id.clothopen_button);
        clothclose= (Button) findViewById(R.id.clothclose_button);

        setClickListener();
    }

    public void setClickListener(){
        clothopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1;
                switch (clothtype){
                    case 1:
                        intent1 = new Intent(CloseoropenActivity.this, VelcroActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case 2:
                        intent1 = new Intent(CloseoropenActivity.this, DdbtnActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case 3:
                        intent1 = new Intent(CloseoropenActivity.this, ZipperActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case 4:
                        intent1 = new Intent(CloseoropenActivity.this, StudActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case 5:
                        intent1 = new Intent(CloseoropenActivity.this, BtnActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                }

            }
        });

        clothclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1;
                switch (clothtype){
                    case 1:
                        intent1 = new Intent(CloseoropenActivity.this, VelcrocloseActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case 2:
                        intent1 = new Intent(CloseoropenActivity.this, DdbtncloseActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case 3:
                        intent1 = new Intent(CloseoropenActivity.this, ZippercloseActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case 4:
                        intent1 = new Intent(CloseoropenActivity.this, StudcloseActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case 5:
                        intent1 = new Intent(CloseoropenActivity.this, BtncloseActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent = new Intent(CloseoropenActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
