package direction.com.ingeniumedupro.view.splash;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

import direction.com.ingeniumedupro.R;
import direction.com.ingeniumedupro.view.dashboard.MainActivity;

public class SplashActivity extends AppCompatActivity {

    LottieAnimationView animationProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //hide action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        animationProgress = findViewById(R.id.animationProgress);

        animationProgress.playAnimation();

        //handler timeout for splash animation
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);

    }
}