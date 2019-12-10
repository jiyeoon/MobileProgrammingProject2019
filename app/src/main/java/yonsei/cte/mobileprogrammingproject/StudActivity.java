package yonsei.cte.mobileprogrammingproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import yonsei.cte.mobileprogrammingproject.databinding.ActivityStudBinding;

public class StudActivity extends AppCompatActivity {
    ActivityStudBinding binding;
    int btn_condition = 0;
    int num_contents = 1;
    MediaPlayer voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_stud);
        setCondition(btn_condition);

        binding.studgohomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.studgonextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition <= num_contents)
                    btn_condition = btn_condition + 1;
                setCondition(btn_condition);
            }
        });
        binding.studgoprevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn_condition >= 0)
                    btn_condition = btn_condition - 1;
                setCondition(btn_condition);
            }
        });
        Glide.with(this).load(R.drawable.stud1).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.stud1Image);
        Glide.with(this).load(R.drawable.stud2).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.stud2Image);
    }

    private void setCondition(int btn_condition) {
        switch (btn_condition) {
            case 0:
                binding.stud1Text.setVisibility(View.VISIBLE);
                binding.stud2Text.setVisibility(View.GONE);
                binding.stud1Image.setVisibility(View.VISIBLE);
                binding.stud2Image.setVisibility(View.GONE);
                binding.studgoprevButton.setVisibility(View.INVISIBLE);
                binding.studgonextButton.setVisibility(View.VISIBLE);
                voiceStart(btn_condition);
                break;
            case 1:
                binding.stud1Text.setVisibility(View.GONE);
                binding.stud2Text.setVisibility(View.VISIBLE);
                binding.stud1Image.setVisibility(View.GONE);
                binding.stud2Image.setVisibility(View.VISIBLE);
                binding.studgoprevButton.setVisibility(View.VISIBLE);
                binding.studgonextButton.setVisibility(View.INVISIBLE);
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
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicestud1);
                voice.setLooping(false);
                voice.start();
                break;
            case 1:
                if(voice != null){
                    voice.release();
                }
                voice = MediaPlayer.create(getApplicationContext(), R.raw.voicestud2);
                voice.setLooping(false);
                voice.start();
                break;

        }
    }

}
