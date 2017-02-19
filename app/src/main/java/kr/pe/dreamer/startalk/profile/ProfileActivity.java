package kr.pe.dreamer.startalk.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import kr.pe.dreamer.startalk.R;
import kr.pe.dreamer.startalk.util.GlobalConfig;
import kr.pe.dreamer.startalk.util.ImageLoad;

/**
 * Created by rhdlr on 2017-02-12.
 */

public class ProfileActivity extends AppCompatActivity {
    private String id;
    private String name;

    public static class Builder {
        private Intent intent;

        public Builder(Context context) {
            intent = new Intent(context, ProfileActivity.class);
        }

        public Builder setName(String name) {
            intent.putExtra("name", name);
            return this;
        }

        public Builder setId(String id) {
            intent.putExtra("id", id);
            return this;
        }

        public Intent build() {
            return intent;
        }
    }

    private void init(){
        Intent intent = getIntent();

        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();

        GlobalConfig.getInstance().setId(this, "010-1234-4560");

        createCloseButton();
        createSettingButton();
        createPhotoButton();

        TextView tv_name = (TextView) findViewById(R.id.tv_profile_name);
        TextView tv_id = (TextView) findViewById(R.id.tv_profile_id);
        TextView tv_or = (TextView) findViewById(R.id.tv_profile_or);
        ImageView iv_background = (ImageView) findViewById(R.id.iv_profile_background);

        tv_name.setText(name);
        tv_id.setText(id);
        tv_or.setText(GlobalConfig.getInstance().getId(this).equals(id) ? "프로필 관리" : "1:1 채팅");
        ImageLoad.getInstance().load(this, iv_background, R.drawable.thm_general_default_profile_image);
    }

    private void createCloseButton() {
        Button button = (Button) findViewById(R.id.btn_profile_close);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void createSettingButton() {
        final Button button = (Button) findViewById(R.id.btn_profile_or);

        button.setBackgroundResource(GlobalConfig.getInstance().getId(this).equals(id) ?
                R.drawable.btn_minipf_edit_n : R.drawable.btn_minipf_chat_n);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_UP:
                        button.setBackgroundResource(GlobalConfig.getInstance().getId(ProfileActivity.this).equals(id) ?
                                R.drawable.btn_minipf_edit_n : R.drawable.btn_minipf_chat_n);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        button.setBackgroundResource(GlobalConfig.getInstance().getId(ProfileActivity.this).equals(id) ?
                                R.drawable.btn_minipf_edit_p : R.drawable.btn_minipf_chat_p);
                        break;
                }
                return false;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new ProfileSettingActivity.Builder(ProfileActivity.this)
                        .setId(id).setName(name)
                        .build();

                startActivity(intent);
            }
        });
    }

    private void createPhotoButton() {
        FloatingActionButton fbtn_photo = (FloatingActionButton) findViewById(R.id.fbtn_profile_photo);

        fbtn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, PhotoActivity.class);
                startActivity(intent);
            }
        });

        ImageLoad.getInstance().load(this, fbtn_photo, R.drawable.thm_general_default_profile_image);
    }
}
