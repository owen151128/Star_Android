package kr.pe.dreamer.startalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import kr.pe.dreamer.startalk.util.GlobalConfig;

/**
 * Created by rhdlr on 2017-03-11.
 */

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        initLayout();
    }

    private void initLayout() {
        createSignButton();
    }

    private void createSignButton() {
        Button btn_signIn = (Button) findViewById(R.id.btn_signin);
        Button btn_signUp = (Button) findViewById(R.id.btn_signup);

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalConfig.getInstance().setLogin(view.getContext(), true);
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
