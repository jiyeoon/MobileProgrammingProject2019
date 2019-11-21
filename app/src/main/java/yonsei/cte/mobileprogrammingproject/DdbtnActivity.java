package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityDdbtnBinding;

public class DdbtnActivity extends AppCompatActivity {

    ActivityDdbtnBinding binding;
    int btn_condition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ddbtn);
        binding.setDdtnactivity(this);

        binding.ddbtngohomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DdbtnActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.ddbtngonextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition <= 5)
                    btn_condition = btn_condition + 1;
                setCondition(btn_condition);
            }
        });
        binding.ddbtngoprevButton.setOnClickListener(new View.OnClickListener() {
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
                binding.ddbtn1Text.setVisibility(binding.ddbtn1Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtn2Text.setVisibility(binding.ddbtn2Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn1Image.setVisibility(binding.ddbtn1Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtn2Image.setVisibility(binding.ddbtn2Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtngoprevButton.setVisibility(binding.ddbtngoprevButton.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.INVISIBLE);
                break;
            case 1:
                binding.ddbtn1Text.setVisibility(binding.ddbtn1Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn2Text.setVisibility(binding.ddbtn2Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtn3Text.setVisibility(binding.ddbtn3Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn1Image.setVisibility(binding.ddbtn1Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn2Image.setVisibility(binding.ddbtn2Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtn3Image.setVisibility(binding.ddbtn3Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtngoprevButton.setVisibility(binding.ddbtngoprevButton.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                break;
            case 2:
                binding.ddbtn2Text.setVisibility(binding.ddbtn2Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn3Text.setVisibility(binding.ddbtn3Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtn4Text.setVisibility(binding.ddbtn4Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn2Image.setVisibility(binding.ddbtn2Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn3Image.setVisibility(binding.ddbtn3Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtn4Image.setVisibility(binding.ddbtn4Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                break;
            case 3:
                binding.ddbtn3Text.setVisibility(binding.ddbtn3Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn4Text.setVisibility(binding.ddbtn4Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtn5Text.setVisibility(binding.ddbtn5Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn3Image.setVisibility(binding.ddbtn3Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn4Image.setVisibility(binding.ddbtn4Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtn5Image.setVisibility(binding.ddbtn5Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtngonextButton.setVisibility(binding.ddbtngonextButton.getVisibility() == View.INVISIBLE ? View.VISIBLE : View.VISIBLE);
                 break;
            case 4:
                binding.ddbtn4Text.setVisibility(binding.ddbtn4Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn5Text.setVisibility(binding.ddbtn5Text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                binding.ddbtn4Image.setVisibility(binding.ddbtn4Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtn5Image.setVisibility(binding.ddbtn5Image.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                binding.ddbtngonextButton.setVisibility(binding.ddbtngonextButton.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.INVISIBLE);
                break;


        }
    }

}