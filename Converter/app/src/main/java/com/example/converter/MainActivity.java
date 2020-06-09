package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    // Check for existing Google Sign In account, if the user is already signed in
    // the GoogleSignInAccount will be non-null.
    private GoogleSignInAccount account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get current account
        account = GoogleSignIn.getLastSignedInAccount(this);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Buttons
        setButtons();

        //Manage profile button
        ImageView profileBtn = findViewById(R.id.profile_img);
        profileBtn.setOnClickListener(new View.OnClickListener()
        {    public void onClick(View v)
        {
            if(account != null) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ImageView profileImg = findViewById(R.id.profile_img);
        if (account != null) {
            Picasso.get().load(account.getPhotoUrl()).placeholder(R.drawable.profile).into(profileImg);
        } else {
            profileImg.setImageResource(R.drawable.profile);
        }


    }

    private void setButtons() {
        CardView btnDistance = (CardView)findViewById(R.id.distanceButton);
        btnDistance.setOnClickListener(new View.OnClickListener()
        {    public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this, DistanceActivity.class);
            startActivity(intent);
            finish();
        }
        });

        CardView btnArea = (CardView)findViewById(R.id.areaButton);
        btnArea.setOnClickListener(new View.OnClickListener()
        {    public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this, AreaActivity.class);
            startActivity(intent);
            finish();
        }
        });

        CardView btnTemperature = (CardView)findViewById(R.id.temperatureButton);
        btnTemperature.setOnClickListener(new View.OnClickListener()
        {    public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this, TemperatureActivity.class);
            startActivity(intent);
            finish();
        }
        });

        CardView btnWeight = (CardView)findViewById(R.id.weightButton);
        btnWeight.setOnClickListener(new View.OnClickListener()
        {    public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this, WeightActivity.class);
            startActivity(intent);
            finish();
        }
        });

        CardView btnSpeed = findViewById(R.id.speedButton);
        btnSpeed.setOnClickListener(new View.OnClickListener()
        {    public void onClick(View v)
        {
            Toast.makeText(MainActivity.this, "Coming soon!", Toast.LENGTH_SHORT).show();
        }
        });

        CardView btnSize = findViewById(R.id.sizeButton);
        btnSize.setOnClickListener(new View.OnClickListener()
        {    public void onClick(View v)
        {
            Toast.makeText(MainActivity.this, "Coming soon!", Toast.LENGTH_SHORT).show();
        }
        });
    }
}
