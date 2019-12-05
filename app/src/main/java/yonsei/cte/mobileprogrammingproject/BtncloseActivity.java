package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityBtncloseBinding;

public class BtncloseActivity extends AppCompatActivity {

    ActivityBtncloseBinding binding;
    int btn_condition = 0;
    int num_contents = 2;
    MediaPlayer voice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_btnclose);
        setCondition(btn_condition);

        binding.btnclosegohomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BtncloseActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.btnclosegonextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition <= num_contents)
                    btn_condition = btn_condition + 1;
                setCondition(btn_condition);
            }
        });
        binding.btnclosegoprevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition >= 0)
                    btn_condition = btn_condition - 1;
                setCondition(btn_condition);
            }
        });
        Glide.with(this).load(R.drawable.btnclose1).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.btnclose1Image);
        Glide.with(this).load(R.drawable.btnclose2).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.btnclose2Image);
        Glide.with(this).load(R.drawable.btnclose3).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.btnclose3Image);
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.btnclose1Text.setVisibility(View.VISIBLE);
                binding.btnclose2Text.setVisibility(View.GONE);
                binding.btnclose1Image.setVisibility(View.VISIBLE);
                binding.btnclose2Image.setVisibility(View.GONE);
                binding.btnclosegoprevButton.setVisibility(View.INVISIBLE);
                voiceStart(btn_condition);
                break;
            case 1:
                binding.btnclose1Text.setVisibility(View.GONE);
                binding.btnclose2Text.setVisibility(View.VISIBLE);
                binding.btnclose3Text.setVisibility(View.GONE);
                binding.btnclose1Image.setVisibility(View.GONE);
                binding.btnclose2Image.setVisibility(View.VISIBLE);
                binding.btnclose3Image.setVisibility(View.GONE);
                binding.btnclosegoprevButton.setVisibility(View.VISIBLE);
                binding.btnclosegonextButton.setVisibility(View.VISIBLE);
                voiceStart(btn_condition);
                break;
            case 2:
                binding.btnclose2Text.setVisibility(View.GONE);
                binding.btnclose3Text.setVisibility(View.VISIBLE);
                binding.btnclose2Image.setVisibility(View.GONE);
                binding.btnclose3Image.setVisibility(View.VISIBLE);
                binding.btnclosegonextButton.setVisibility(View.INVISIBLE);
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
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicebtnclose1);
                voice.setLooping(false);
                voice.start();
                break;
            case 1:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicebtnclose2);
                voice.setLooping(false);
                voice.start();
                break;
            case 2:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicebtnclose3);
                voice.setLooping(false);
                voice.start();
                break;
        }
    }

}