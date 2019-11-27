package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityDdbtnBinding;
import yonsei.cte.mobileprogrammingproject.databinding.ActivityDdbtncloseBinding;

public class DdbtncloseActivity extends AppCompatActivity {

    ActivityDdbtncloseBinding binding;
    int btn_condition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ddbtnclose);

        binding.ddbtnclosegohomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DdbtncloseActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.ddbtnclosegonextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition <= 5)
                    btn_condition = btn_condition + 1;
                setCondition(btn_condition);
            }
        });
        binding.ddbtnclosegoprevButton.setOnClickListener(new View.OnClickListener() {
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
                binding.ddbtnclose1Text.setVisibility(binding.ddbtnclose1Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtnclose2Text.setVisibility(binding.ddbtnclose2Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose1Image.setVisibility(binding.ddbtnclose1Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtnclose2Image.setVisibility(binding.ddbtnclose2Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclosegoprevButton.setVisibility(binding.ddbtnclosegoprevButton.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.INVISIBLE);
                break;
            case 1:
                binding.ddbtnclose1Text.setVisibility(binding.ddbtnclose1Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose2Text.setVisibility(binding.ddbtnclose2Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtnclose3Text.setVisibility(binding.ddbtnclose3Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose1Image.setVisibility(binding.ddbtnclose1Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose2Image.setVisibility(binding.ddbtnclose2Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtnclose3Image.setVisibility(binding.ddbtnclose3Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclosegoprevButton.setVisibility(binding.ddbtnclosegoprevButton.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                break;
            case 2:
                binding.ddbtnclose2Text.setVisibility(binding.ddbtnclose2Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose3Text.setVisibility(binding.ddbtnclose3Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtnclose4Text.setVisibility(binding.ddbtnclose4Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose2Image.setVisibility(binding.ddbtnclose2Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose3Image.setVisibility(binding.ddbtnclose3Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtnclose4Image.setVisibility(binding.ddbtnclose4Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                break;
            case 3:
                binding.ddbtnclose3Text.setVisibility(binding.ddbtnclose3Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose4Text.setVisibility(binding.ddbtnclose4Text.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtnclose5Text.setVisibility(binding.ddbtnclose5Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose3Image.setVisibility(binding.ddbtnclose3Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose4Image.setVisibility(binding.ddbtnclose4Image.getVisibility() == View.VISIBLE ? View.VISIBLE : View.VISIBLE);
                binding.ddbtnclose5Image.setVisibility(binding.ddbtnclose5Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclosegonextButton.setVisibility(binding.ddbtnclosegonextButton.getVisibility() == View.INVISIBLE ? View.VISIBLE : View.VISIBLE);
                break;
            case 4:
                binding.ddbtnclose4Text.setVisibility(binding.ddbtnclose4Text.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose5Text.setVisibility(binding.ddbtnclose5Text.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                binding.ddbtnclose4Image.setVisibility(binding.ddbtnclose4Image.getVisibility() == View.VISIBLE ? View.GONE : View.GONE);
                binding.ddbtnclose5Image.setVisibility(binding.ddbtnclose5Image.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                binding.ddbtnclosegonextButton.setVisibility(binding.ddbtnclosegonextButton.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.INVISIBLE);
                break;

        }
    }
}
