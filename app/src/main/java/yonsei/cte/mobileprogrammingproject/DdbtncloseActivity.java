package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

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
        Glide.with(this).load(R.drawable.ddbtnclose1).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.ddbtnclose1Image);
        Glide.with(this).load(R.drawable.ddbtnclose2).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.ddbtnclose2Image);
        Glide.with(this).load(R.drawable.ddbtnclose3).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.ddbtnclose3Image);
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.ddbtnclose1Text.setVisibility(View.VISIBLE);
                binding.ddbtnclose2Text.setVisibility(View.GONE);
                binding.ddbtnclose1Image.setVisibility(View.VISIBLE);
                binding.ddbtnclose2Image.setVisibility(View.GONE);
                binding.ddbtnclosegoprevButton.setVisibility(View.INVISIBLE);
                break;
            case 1:
                binding.ddbtnclose1Text.setVisibility(View.GONE);
                binding.ddbtnclose2Text.setVisibility(View.VISIBLE);
                binding.ddbtnclose3Text.setVisibility(View.GONE);
                binding.ddbtnclose1Image.setVisibility(View.GONE);
                binding.ddbtnclose2Image.setVisibility(View.VISIBLE);
                binding.ddbtnclose3Image.setVisibility(View.GONE);
                binding.ddbtnclosegoprevButton.setVisibility(View.VISIBLE);
                binding.ddbtnclosegonextButton.setVisibility(View.VISIBLE);
                break;
            case 2:
                binding.ddbtnclose2Text.setVisibility(View.GONE);
                binding.ddbtnclose3Text.setVisibility(View.VISIBLE);
                binding.ddbtnclose2Image.setVisibility(View.GONE);
                binding.ddbtnclose3Image.setVisibility(View.VISIBLE);
                binding.ddbtnclosegonextButton.setVisibility(View.INVISIBLE);
                break;

        }
    }
}