package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityStudcloseBinding;

public class StudcloseActivity extends AppCompatActivity {
    ActivityStudcloseBinding binding;
    int btn_condition = 0;
    int num_contents = 2;
    MediaPlayer voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_studclose);
        setCondition(btn_condition);

        binding.studclosegohomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudcloseActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.studclosegonextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition <= num_contents)
                    btn_condition = btn_condition + 1;
                setCondition(btn_condition);
            }
        });
        binding.studclosegoprevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition >= 0)
                    btn_condition = btn_condition - 1;
                setCondition(btn_condition);
            }
        });
        Glide.with(this).load(R.drawable.studclose1).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.studclose1Image);
        Glide.with(this).load(R.drawable.studclose2).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.studclose2Image);
        Glide.with(this).load(R.drawable.studclose3).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.studclose3Image);
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.studclose1Text.setVisibility(View.VISIBLE);
                binding.studclose2Text.setVisibility(View.GONE);
                binding.studclose1Image.setVisibility(View.VISIBLE);
                binding.studclose2Image.setVisibility(View.GONE);
                binding.studclosegoprevButton.setVisibility(View.INVISIBLE);
                voiceStart(btn_condition);
                break;
            case 1:
                binding.studclose1Text.setVisibility(View.GONE);
                binding.studclose2Text.setVisibility(View.VISIBLE);
                binding.studclose1Image.setVisibility(View.GONE);
                binding.studclose2Image.setVisibility(View.VISIBLE);
                binding.studclose3Image.setVisibility(View.GONE);
                binding.studclose3Text.setVisibility(View.GONE);
                binding.studclosegoprevButton.setVisibility(View.VISIBLE);
                binding.studclosegonextButton.setVisibility(View.VISIBLE);
                voiceStart(btn_condition);
                break;
            case 2:
                binding.studclose2Text.setVisibility(View.GONE);
                binding.studclose3Text.setVisibility(View.VISIBLE);
                binding.studclose2Image.setVisibility(View.GONE);
                binding.studclose3Image.setVisibility(View.VISIBLE);
                binding.studclosegonextButton.setVisibility(View.INVISIBLE);
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
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicestudclose1);
                voice.setLooping(false);
                voice.start();
                break;
            case 1:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicestudclose2);
                voice.setLooping(false);
                voice.start();
                break;
            case 2:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicestudclose3);
                voice.setLooping(false);
                voice.start();
                break;
        }
    }

}