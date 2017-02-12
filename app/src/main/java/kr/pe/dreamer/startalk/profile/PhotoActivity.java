package kr.pe.dreamer.startalk.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import kr.pe.dreamer.startalk.R;
import kr.pe.dreamer.startalk.util.ImageLoad;

/**
 * Created by rhdlr on 2017-02-12.
 */

public class PhotoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        ImageView iv_photo = (ImageView) findViewById(R.id.iv_photo);
        Button btn_close = (Button) findViewById(R.id.btn_photo_close);

        ImageLoad.getInstance().load(this,iv_photo,R.drawable.thm_general_default_profile_image);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
