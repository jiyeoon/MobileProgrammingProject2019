package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityVelcrocloseBinding;

public class VelcrocloseActivity extends AppCompatActivity {
    ActivityVelcrocloseBinding binding;
    int btn_condition = 0;
    int num_contents = 2;
    MediaPlayer voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_velcroclose);
        setCondition(btn_condition);

        binding.velcroclosegohomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VelcrocloseActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.velcroclosegonextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition <= num_contents)
                    btn_condition = btn_condition + 1;
                setCondition(btn_condition);
            }
        });
        binding.velcroclosegoprevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition >= 0)
                    btn_condition = btn_condition - 1;
                setCondition(btn_condition);
            }
        });
        Glide.with(this).load(R.drawable.velcroclose1).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.velcroclose1Image);
        Glide.with(this).load(R.drawable.velcroclose2).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.velcroclose2Image);
        Glide.with(this).load(R.drawable.velcroclose3).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.velcroclose3Image);
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.velcroclose1Text.setVisibility(View.VISIBLE);
                binding.velcroclose2Text.setVisibility(View.GONE);
                binding.velcroclose1Image.setVisibility(View.VISIBLE);
                binding.velcroclose2Image.setVisibility(View.GONE);
                binding.velcroclosegoprevButton.setVisibility(View.INVISIBLE);
                voiceStart(btn_condition);
                break;
            case 1:
                binding.velcroclose1Text.setVisibility(View.GONE);
                binding.velcroclose2Text.setVisibility(View.VISIBLE);
                binding.velcroclose3Text.setVisibility(View.GONE);
                binding.velcroclose1Image.setVisibility(View.GONE);
                binding.velcroclose2Image.setVisibility(View.VISIBLE);
                binding.velcroclose3Image.setVisibility(View.GONE);
                binding.velcroclosegoprevButton.setVisibility(View.VISIBLE);
                binding.velcroclosegonextButton.setVisibility(View.VISIBLE);
                voiceStart(btn_condition);
                break;
            case 2:
                binding.velcroclose2Text.setVisibility(View.GONE);
                binding.velcroclose3Text.setVisibility(View.VISIBLE);
                binding.velcroclose2Image.setVisibility(View.GONE);
                binding.velcroclose3Image.setVisibility(View.VISIBLE);
                binding.velcroclosegonextButton.setVisibility(View.INVISIBLE);
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
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicevelcroclose1);
                voice.setLooping(false);
                voice.start();
                break;
            case 1:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicevelcroclose2);
                voice.setLooping(false);
                voice.start();
                break;
            case 2:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicevelcroclose3);
                voice.setLooping(false);
                voice.start();
                break;
        }
    }

}