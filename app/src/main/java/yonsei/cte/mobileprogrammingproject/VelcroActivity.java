package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityVelcroBinding;

public class VelcroActivity extends AppCompatActivity {
    ActivityVelcroBinding binding;
    int btn_condition = 0;
    int num_contents = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_velcro);

        binding.velcrogohomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VelcroActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.velcrogonextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition <= num_contents)
                    btn_condition = btn_condition + 1;
                setCondition(btn_condition);
            }
        });
        binding.velcrogoprevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition >= 0)
                    btn_condition = btn_condition - 1;
                setCondition(btn_condition);
            }
        });
        Glide.with(this).load(R.drawable.velcro1).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.velcro1Image);
        Glide.with(this).load(R.drawable.velcro2).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.velcro2Image);
        Glide.with(this).load(R.drawable.velcro3).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.velcro3Image);
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.velcro1Text.setVisibility(View.VISIBLE);
                binding.velcro2Text.setVisibility(View.GONE);
                binding.velcro1Image.setVisibility(View.VISIBLE);
                binding.velcro2Image.setVisibility(View.GONE);
                binding.velcrogoprevButton.setVisibility(View.INVISIBLE);
                break;
            case 1:
                binding.velcro1Text.setVisibility(View.GONE);
                binding.velcro2Text.setVisibility(View.VISIBLE);
                binding.velcro3Text.setVisibility(View.GONE);
                binding.velcro1Image.setVisibility(View.GONE);
                binding.velcro2Image.setVisibility(View.VISIBLE);
                binding.velcro3Image.setVisibility(View.GONE);
                binding.velcrogoprevButton.setVisibility(View.VISIBLE);
                binding.velcrogonextButton.setVisibility(View.VISIBLE);
                break;
            case 2:
                binding.velcro2Text.setVisibility(View.GONE);
                binding.velcro3Text.setVisibility(View.VISIBLE);
                binding.velcro2Image.setVisibility(View.GONE);
                binding.velcro3Image.setVisibility(View.VISIBLE);
                binding.velcrogonextButton.setVisibility(View.INVISIBLE);
                break;

        }
    }
}
