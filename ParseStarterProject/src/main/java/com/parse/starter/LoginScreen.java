package com.parse.starter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.parse.starter.Adapters.LoginSlidesAdapter;

public class LoginScreen extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] layouts = {R.layout.login_intro_slide1, R.layout.login_intro_slide2, R.layout.login_intro_slide3};
    private LoginSlidesAdapter loginSlidesAdapter;
    private Button login;
    private LinearLayout Dots_Layout;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_intro_screen);
        viewPager = findViewById(R.id.viewPager);
        loginSlidesAdapter = new LoginSlidesAdapter(layouts, this);
        viewPager.setAdapter(loginSlidesAdapter);
        login = findViewById(R.id.login);
        login.setVisibility(View.INVISIBLE);
        Dots_Layout = findViewById(R.id.dotsLayout);
        createDots(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
                if (position == layouts.length - 1) {
                    Dots_Layout.setVisibility(View.INVISIBLE);
                    login.setVisibility(View.VISIBLE);
                } else {
                    Dots_Layout.setVisibility(View.VISIBLE);
                    login.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createDots(int current_position) {
        if (Dots_Layout != null)
            Dots_Layout.removeAllViews();

        dots = new ImageView[layouts.length];

        for (int i = 0; i < layouts.length; i++) {
            dots[i] = new ImageView(this);
            if (i == current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
            } else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(15, 0, 15, 0);
            Dots_Layout.addView(dots[i], params);
        }
    }

    public void moveToLogin(View view) {
        startActivity(new Intent(LoginScreen.this, LoginActivity.class));
        finish();
    }
}
