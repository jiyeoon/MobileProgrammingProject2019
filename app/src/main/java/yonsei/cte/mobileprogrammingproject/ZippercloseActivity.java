package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityZippercloseBinding;

public class ZippercloseActivity extends AppCompatActivity {

    ActivityZippercloseBinding binding;
    int btn_condition = 0;
    int num_contents = 3;
    MediaPlayer voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_zipperclose);
        setCondition(btn_condition);

        binding.zipperclosegohomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZippercloseActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.zipperclosegonextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition <= num_contents)
                    btn_condition = btn_condition + 1;
                setCondition(btn_condition);
            }
        });
        binding.zipperclosegoprevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition >= 0)
                    btn_condition = btn_condition - 1;
                setCondition(btn_condition);
            }
        });
        Glide.with(this).load(R.drawable.ziperclose1).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.zipperclose1Image);
        Glide.with(this).load(R.drawable.ziperclose2).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.zipperclose2Image);
        Glide.with(this).load(R.drawable.ziperclose3).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.zipperclose3Image);
        Glide.with(this).load(R.drawable.ziperclose4).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.zipperclose4Image);
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.zipperclose1Text.setVisibility(View.VISIBLE);
                binding.zipperclose2Text.setVisibility(View.GONE);
                binding.zipperclose1Image.setVisibility(View.VISIBLE);
                binding.zipperclose2Image.setVisibility(View.GONE);
                binding.zipperclosegoprevButton.setVisibility(View.INVISIBLE);
                voiceStart(btn_condition);
                break;
            case 1:
                binding.zipperclose1Text.setVisibility(View.GONE);
                binding.zipperclose2Text.setVisibility(View.VISIBLE);
                binding.zipperclose3Text.setVisibility(View.GONE);
                binding.zipperclose1Image.setVisibility(View.GONE);
                binding.zipperclose2Image.setVisibility(View.VISIBLE);
                binding.zipperclose3Image.setVisibility(View.GONE);
                binding.zipperclosegoprevButton.setVisibility(View.VISIBLE);
                voiceStart(btn_condition);
                break;
            case 2:
                binding.zipperclose2Text.setVisibility(View.GONE);
                binding.zipperclose3Text.setVisibility(View.VISIBLE);
                binding.zipperclose4Text.setVisibility(View.GONE);
                binding.zipperclose5Text.setVisibility(View.GONE);
                binding.zipperclose2Image.setVisibility(View.GONE);
                binding.zipperclose3Image.setVisibility(View.VISIBLE);
                binding.zipperclose4Image.setVisibility(View.GONE);
                binding.zipperclosegonextButton.setVisibility(View.VISIBLE);
                voiceStart(btn_condition);
                break;
            case 3:
                binding.zipperclose3Text.setVisibility(View.GONE);
                binding.zipperclose4Text.setVisibility(View.VISIBLE);
                binding.zipperclose5Text.setVisibility(View.VISIBLE);
                binding.zipperclose3Image.setVisibility(View.GONE);
                binding.zipperclose4Image.setVisibility(View.VISIBLE);
                binding.zipperclosegonextButton.setVisibility(View.INVISIBLE);
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
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicezipperclose1);
                voice.setLooping(false);
                voice.start();
                break;
            case 1:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicezipperclose2);
                voice.setLooping(false);
                voice.start();
                break;
            case 2:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicezipperclose3);
                voice.setLooping(false);
                voice.start();
                break;
            case 3:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicezipperclose4);
                voice.setLooping(false);
                voice.start();
                voice.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        voice = MediaPlayer.create(getApplicationContext(), R.raw.voicezipperclosetip);
                        voice.setLooping(false);
                        voice.start();
                    }
                });
                break;
        }
    }

}