package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityZipperBinding;

public class ZipperActivity extends AppCompatActivity {

    ActivityZipperBinding binding;
    int btn_condition = 0;
    int num_contents = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_zipper);

        binding.zippergohomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZipperActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.zippergonextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition <= num_contents)
                    btn_condition = btn_condition + 1;
                setCondition(btn_condition);
            }
        });
        binding.zippergoprevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition >= 0)
                    btn_condition = btn_condition - 1;
                setCondition(btn_condition);
            }
        });
        Glide.with(this).load(R.drawable.ziper1).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.zipper1Image);
        Glide.with(this).load(R.drawable.ziper2).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.zipper2Image);
        Glide.with(this).load(R.drawable.ziper3).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.zipper3Image);
        Glide.with(this).load(R.drawable.ziper4).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.zipper4Image);
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.zipper1Text.setVisibility(View.VISIBLE);
                binding.zipper2Text.setVisibility(View.GONE);
                binding.zipper1Image.setVisibility(View.VISIBLE);
                binding.zipper2Image.setVisibility(View.GONE);
                binding.zippergoprevButton.setVisibility(View.INVISIBLE);
                break;
            case 1:
                binding.zipper1Text.setVisibility(View.GONE);
                binding.zipper2Text.setVisibility(View.VISIBLE);
                binding.zipper3Text.setVisibility(View.GONE);
                binding.zipper1Image.setVisibility(View.GONE);
                binding.zipper2Image.setVisibility(View.VISIBLE);
                binding.zipper3Image.setVisibility(View.GONE);
                binding.zippergoprevButton.setVisibility(View.VISIBLE);
                break;
            case 2:
                binding.zipper2Text.setVisibility(View.GONE);
                binding.zipper3Text.setVisibility(View.VISIBLE);
                binding.zipper4Text.setVisibility(View.GONE);
                binding.zipper5Text.setVisibility(View.GONE);
                binding.zipper2Image.setVisibility(View.GONE);
                binding.zipper3Image.setVisibility(View.VISIBLE);
                binding.zipper4Image.setVisibility(View.GONE);
                binding.zippergonextButton.setVisibility(View.VISIBLE);
                break;
            case 3:
                binding.zipper3Text.setVisibility(View.GONE);
                binding.zipper4Text.setVisibility(View.VISIBLE);
                binding.zipper5Text.setVisibility(View.VISIBLE);
                binding.zipper3Image.setVisibility(View.GONE);
                binding.zipper4Image.setVisibility(View.VISIBLE);
                binding.zippergonextButton.setVisibility(View.INVISIBLE);
                break;

        }
    }
}