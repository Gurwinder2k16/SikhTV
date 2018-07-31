package com.anaadar.sumitsingh.sikhtv;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ProgressBar progressBar;
    TextView tv;
    ImageView btFac, btYou, btCon, btLive;
    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        tv = (TextView) findViewById(R.id.textView1);
        btFac = (ImageView) findViewById(R.id.facebook);
        btYou = (ImageView) findViewById(R.id.youtube);
        btCon = (ImageView) findViewById(R.id.contact);
        btLive = (ImageView) findViewById(R.id.live);
        btFac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFacebook();
            }
        });
        btYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYoutube();
            }
        });
        btCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConatctUs();
            }
        });
        btLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLive();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "+919988321323"));
                intent.putExtra("sms_body", "Dhan Guru Nanak..... <Message To Indeerbeer Singh Tinku>");
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       /* MobileAds.initialize(this, getString(R.string.admob_app_id));
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                } else {
                    mRewardedVideoAd.loadAd(getString(R.string.ad_unit_id), new AdRequest.Builder().build());
                }
            }
        }, 5000); */
        //-------------init
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.web) {
            Intent b = new Intent(MainActivity.this, Contact_web.class);
            b.putExtra("Message", "https://www.Sikhtvgurbani.com");
            startActivity(b);
        } else if (id == R.id.about_app) {
            openConatctUs();
        } else if (id == R.id.fb_page) {
            openFacebook();
        } else if (id == R.id.you_page) {
            openYoutube();
        } else if (id == R.id.amritvela) {
            openAmritvale();
        } else if (id == R.id.other) {
            /*Intent b = new Intent(MainActivity.this, Contact_web.class);
            b.putExtra("Message", "https://www.payumoney.com/paybypayumoney/#/0279B475FA7ED2F5C38ED62B211B9817");
            startActivity(b);*/
            openLive();
        } else if (id == R.id.exit) {
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void openYoutube() {
        Intent b = new Intent(MainActivity.this, Contact_web.class);
        b.putExtra("Message", "https://www.youtube.com/channel/UCgCneWxYYKsJCPMJfov6pPw");
        startActivity(b);
    }

    void openFacebook() {
        Intent b = new Intent(MainActivity.this, Contact_web.class);
        b.putExtra("Message", "https://www.facebook.com/NaamSimranSamagam/");
        startActivity(b);
    }

    void openConatctUs() {
        Intent b = new Intent(MainActivity.this, ContactUS.class);
        startActivity(b);
    }

    void openLive() {
        Intent b = new Intent(MainActivity.this, Contact_web.class);
        b.putExtra("Message", "http://209.58.178.202/Gurmeettvhls/Gurmeettv.m3u8");
        startActivity(b);
    }

    void openAmritvale() {
        startActivity(new Intent(MainActivity.this, Amritvela.class));
    }
}
