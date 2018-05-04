package me.mehdi.textinputlayout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    AppCompatEditText usernameEditText;
    AppCompatEditText passwordEditText;
    ViewGroup rootLayout;

    AppCompatButton loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        rootLayout = findViewById(R.id.root);


        rootLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });

        //This part is for animating the login button
        loginButton = findViewById(R.id.login);
        final Animation loginAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animate_button);
        loginAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                overridePendingTransition(R.anim.enter_animation, R.anim.exit_animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                button.startAnimation(loginAnimation);

            }
        });

    }


}
