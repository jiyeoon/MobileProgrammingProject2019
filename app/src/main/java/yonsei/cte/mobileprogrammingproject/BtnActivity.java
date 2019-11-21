package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityBtnBinding;

public class BtnActivity extends AppCompatActivity {

    ActivityBtnBinding binding;
    int btn_condition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_btn);


        binding.btngohomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BtnActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.btngonextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition <= 5)
                    btn_condition = btn_condition + 1;
                setCondition(btn_condition);
            }
        });
        binding.btngoprevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition >= 0)
                    btn_condition = btn_condition - 1;
                setCondition(btn_condition);
            }
        });
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.btn1Text.setVisibility(binding.btn1Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.btn2Text.setVisibility(binding.btn2Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn1Image.setVisibility(binding.btn1Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.btn2Image.setVisibility(binding.btn2Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btngoprevButton.setVisibility(binding.btngoprevButton.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.INVISIBLE);
                break;
            case 1:
                binding.btn1Text.setVisibility(binding.btn1Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn2Text.setVisibility(binding.btn2Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.btn3Text.setVisibility(binding.btn3Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn1Image.setVisibility(binding.btn1Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn2Image.setVisibility(binding.btn2Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.btn3Image.setVisibility(binding.btn3Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btngoprevButton.setVisibility(binding.btngoprevButton.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                break;
            case 2:
                binding.btn2Text.setVisibility(binding.btn2Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn3Text.setVisibility(binding.btn3Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.btn4Text.setVisibility(binding.btn4Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn2Image.setVisibility(binding.btn2Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn3Image.setVisibility(binding.btn3Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.btn4Image.setVisibility(binding.btn4Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                break;
            case 3:
                binding.btn3Text.setVisibility(binding.btn3Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn4Text.setVisibility(binding.btn4Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.btn5Text.setVisibility(binding.btn5Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn3Image.setVisibility(binding.btn3Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn4Image.setVisibility(binding.btn4Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.btn5Image.setVisibility(binding.btn5Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btngonextButton.setVisibility(binding.btngonextButton.getVisibility() == View.INVISIBLE ? View.VISIBLE : View.VISIBLE);
                break;
            case 4:
                binding.btn4Text.setVisibility(binding.btn4Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn5Text.setVisibility(binding.btn5Text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                binding.btn4Image.setVisibility(binding.btn4Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.btn5Image.setVisibility(binding.btn5Image.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                binding.btngonextButton.setVisibility(binding.btngonextButton.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.INVISIBLE);
                break;

        }
    }
}
