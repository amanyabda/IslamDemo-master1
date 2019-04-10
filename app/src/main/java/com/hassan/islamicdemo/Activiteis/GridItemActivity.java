package com.hassan.islamicdemo.Activiteis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.hassan.islamicdemo.R;


public class GridItemActivity extends AppCompatActivity {
    TextView gridData;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        gridData = findViewById(R.id.griddata);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);
        gridData.setText(receivedName);

        imageView.setImageResource(receivedImage);
        //enable back Button
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
