package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityBtnBinding;

public class BtnActivity extends AppCompatActivity {

    ActivityBtnBinding binding;
    int btn_condition = 0;
    int num_contents = 2;

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
                if (btn_condition <= num_contents)
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
        Glide.with(this).load(R.drawable.btn1).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.btn1Image);
        Glide.with(this).load(R.drawable.btn2).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.btn2Image);
        Glide.with(this).load(R.drawable.btn3).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.btn3Image);
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.btn1Text.setVisibility(View.VISIBLE);
                binding.btn2Text.setVisibility(View.GONE);
                binding.btn1Image.setVisibility(View.VISIBLE);
                binding.btn2Image.setVisibility(View.GONE);
                binding.btngoprevButton.setVisibility(View.INVISIBLE);
                break;
            case 1:
                binding.btn1Text.setVisibility(View.GONE);
                binding.btn2Text.setVisibility(View.VISIBLE);
                binding.btn3Text.setVisibility(View.GONE);
                binding.btn1Image.setVisibility(View.GONE);
                binding.btn2Image.setVisibility(View.VISIBLE);
                binding.btn3Image.setVisibility(View.GONE);
                binding.btngoprevButton.setVisibility(View.VISIBLE);
                binding.btngonextButton.setVisibility(View.VISIBLE);
                break;
            case 2:
                binding.btn2Text.setVisibility(View.GONE);
                binding.btn3Text.setVisibility(View.VISIBLE);
                binding.btn2Image.setVisibility(View.GONE);
                binding.btn3Image.setVisibility(View.VISIBLE);
                binding.btngonextButton.setVisibility(View.INVISIBLE);
                break;

        }
    }
}
