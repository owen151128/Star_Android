package kr.pe.dreamer.startalk.profile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import kr.pe.dreamer.startalk.R;
import kr.pe.dreamer.startalk.util.ImageLoad;

/**
 * Created by rhdlr on 2017-02-18.
 */

public class ProfileSettingActivity extends AppCompatActivity {
    private String id;
    private String name;

    private FloatingActionButton fbtn_photo;
    private ImageView iv_background;

    private static final int PICK_FROM_BACKGROUND = 1;
    private static final int PICK_FROM_PROFILE = 2;

    public static class Builder {
        private Intent intent;

        public Builder(Context context) {
            intent = new Intent(context, ProfileSettingActivity.class);
        }

        public ProfileSettingActivity.Builder setName(String name) {
            intent.putExtra("name", name);
            return this;
        }

        public ProfileSettingActivity.Builder setId(String id) {
            intent.putExtra("id", id);
            return this;
        }

        public Intent build() {
            return intent;
        }
    }

    private void init() {
        Intent intent = getIntent();

        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);

        init();

        createName();
        createNumber();
        createCloseButton();
        createLayoutMessage();
        createPhotoButton();
        createBackground();
    }

    private void createLayoutMessage() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout_message);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void createName() {
        TextView tv_name = (TextView) findViewById(R.id.tv_name);
        tv_name.setText(name);

        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void createNumber() {
        TextView tv_id = (TextView) findViewById(R.id.tv_id);
        tv_id.setText(id);
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

    private void createPhotoButton() {
        fbtn_photo = (FloatingActionButton) findViewById(R.id.fbtn_profile_photo);
        ImageLoad.getInstance().load(this, fbtn_photo, R.drawable.thm_general_default_profile_image);

        fbtn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, PICK_FROM_PROFILE);
            }
        });

    }

    private void createBackground() {
        iv_background = (ImageView) findViewById(R.id.iv_profile_background);
        ImageLoad.getInstance().load(this, iv_background, R.drawable.thm_general_default_profile_image);

        iv_background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent, PICK_FROM_BACKGROUND);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("test", "onActivityResult");
        if (resultCode != RESULT_OK) {
            return;
        }

        if (requestCode == PICK_FROM_BACKGROUND) {
            beginCrop(data.getData());
        } else if (requestCode == PICK_FROM_PROFILE) {
            ImageLoad.getInstance().load(this, fbtn_photo, data.getData());
        } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            Uri resultUri = result.getUri();
            ImageLoad.getInstance().load(this, iv_background, resultUri);
        }
    }

    private void beginCrop(Uri source) {
        CropImage.activity(source)
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);
    }
}
