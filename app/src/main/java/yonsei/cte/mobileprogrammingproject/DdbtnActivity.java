package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityDdbtnBinding;

public class DdbtnActivity extends AppCompatActivity {

    ActivityDdbtnBinding binding;
    int btn_condition = 0;
    MediaPlayer voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ddbtn);
        binding.setDdtnactivity(this);
        setCondition(btn_condition);

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
        Glide.with(this).load(R.drawable.ddbtn1).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.ddbtn1Image);
        Glide.with(this).load(R.drawable.ddbtn2).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.ddbtn2Image);
        Glide.with(this).load(R.drawable.ddbtn3).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.ddbtn3Image);
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.ddbtn1Text.setVisibility(View.VISIBLE);
                binding.ddbtn2Text.setVisibility(View.GONE);
                binding.ddbtn1Image.setVisibility(View.VISIBLE);
                binding.ddbtn2Image.setVisibility(View.GONE);
                binding.ddbtngoprevButton.setVisibility(View.INVISIBLE);
                voiceStart(btn_condition);
                break;
            case 1:
                binding.ddbtn1Text.setVisibility(View.GONE);
                binding.ddbtn2Text.setVisibility(View.VISIBLE);
                binding.ddbtn3Text.setVisibility(View.GONE);
                binding.ddbtn1Image.setVisibility(View.GONE);
                binding.ddbtn2Image.setVisibility(View.VISIBLE);
                binding.ddbtn3Image.setVisibility(View.GONE);
                binding.ddbtngoprevButton.setVisibility(View.VISIBLE);
                binding.ddbtngonextButton.setVisibility(View.VISIBLE);
                voiceStart(btn_condition);
                break;
            case 2:
                binding.ddbtn2Text.setVisibility(View.GONE);
                binding.ddbtn3Text.setVisibility(View.VISIBLE);
                binding.ddbtn2Image.setVisibility(View.GONE);
                binding.ddbtn3Image.setVisibility(View.VISIBLE);
                binding.ddbtngonextButton.setVisibility(View.INVISIBLE);
                voiceStart(btn_condition);
                break;

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(voice != null){
            voice.release();
        }
    }

    private void voiceStart(int voiceNum){
        switch (voiceNum) {
            case 0:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voiceddbtn1);
                voice.setLooping(false);
                voice.start();
                break;
            case 1:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voiceddbtn2);
                voice.setLooping(false);
                voice.start();
                break;
            case 2:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voiceddbtn3);
                voice.setLooping(false);
                voice.start();
                break;
        }
    }

}