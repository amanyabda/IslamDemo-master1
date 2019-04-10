package com.hassan.islamicdemo.Activiteis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.hassan.islamicdemo.R;


public class DouActivity extends AppCompatActivity {
    GridView gridView;

    String[] fruitNames = {"1","2","3","4","5","6","7","8","9","10","11","12","13",
            "14","15","16","17","18","19","20","21","22","23","24",
            "25","26","27","28","29","30"};

    int[] fruitImages = {R.drawable.r1, R.drawable.r2, R.drawable.r3,
            R.drawable.r4, R.drawable.r5, R.drawable.r6,
            R.drawable.r7, R.drawable.r8, R.drawable.r9, R.drawable.r10, R.drawable.r11,
            R.drawable.r12, R.drawable.r13, R.drawable.r14, R.drawable.r15, R.drawable.r16, R.drawable.r17, R.drawable.r18,
            R.drawable.r19, R.drawable.r20, R.drawable.r21,
            R.drawable.r22, R.drawable.r23, R.drawable.r24, R.drawable.r25, R.drawable.r26,
            R.drawable.r27, R.drawable.r28, R.drawable.r29, R.drawable.r30};

    String [] Namesday = {"اليوم الاول","اليوم الثاني","اليوم الثالت","اليوم الرابع","اليوم الخامس","اليوم السادس",
            "اليوم السابع","اليوم الثامن","اليوم التاسع","اليوم العاشر","اليوم الحادي عشر","اليوم الثاني عشر","اليوم الثالث عشر",
            "اليوم الرابع عشر","اليوم الخامس عشر","اليوم السادس عشر","اليوم السابع عشر",
            "اليوم الثامن عشر","اليوم التاسع عشر","اليوم العشرون","اليوم الواحد والعشرون","اليوم الثاني والعشرون",
            "اليوم الثالث والعشرون","اليوم الرابع والعشرون",
            "اليوم الخامس والعشرون","اليوم السادس والعشرون","اليوم السابع والعشرون","اليوم الثامن والعشرون",
            "اليوم التاسع والعشرون","اليوم الثلاثون"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dou_activity);



        //        ******* اضافة
        MobileAds.initialize(this, "ca-app-pub-4574345653098269~4809814993");
       // View adContainer = findViewById(R.id.adView);
        AdView mAdView = new AdView(getApplicationContext());
        mAdView.setAdSize(AdSize.SMART_BANNER);
        mAdView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_sample));
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
        AdRequest adRequest1 = new AdRequest.Builder()
                .build();
        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest1);


        //finding listview
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",Namesday[i]);
                intent.putExtra("image",fruitImages[i]);
                startActivity(intent);

            }
        });


    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return fruitImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data2,null);

            //getting view in row_data
            TextView name = view1.findViewById(R.id.rr);
            // ImageView image = view1.findViewById(R.id.images);

            name.setText(fruitNames[i]);
            // image.setImageResource(fruitImages[i]);
            return view1;



        }
    }



    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_sample));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                showInterstitial();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
            }
        });
        return interstitialAd;
    }

    InterstitialAd mInterstitialAd;

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
        }
    }

    private void loadInterstitial() {
        // Disable the next level button and load the ad.
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
    }

}