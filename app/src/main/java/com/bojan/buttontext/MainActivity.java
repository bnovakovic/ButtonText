package com.bojan.buttontext;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tAnsw1;
    private boolean isTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tAnsw1 = (TextView) findViewById(R.id.tAnsw1);

        Typeface font = Typeface.createFromAsset(getAssets(), "font/BalooBhai-Regular.ttf");
        tAnsw1.setTypeface(font);
        tAnsw1.setTextColor(Color.WHITE);
        tAnsw1.setIncludeFontPadding(false);
        tAnsw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Tablet used: " + isTablet, Toast.LENGTH_SHORT).show();
            }
        });


        isTablet = findViewById(R.id.gamePlayLarge) != null;
        positionUI();




    }

    private void positionUI() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;
        int aButtonHeight = (int) (screenHeight / 6.5);
        int aButtonWidth = (int) (screenWidth / 2.32);


        int fontSize = (int) (aButtonHeight * 0.47);

//        Toast.makeText(getActivity(), "Width: " + screenWidth + " - Height: " + screenHeight, Toast.LENGTH_LONG).show();

//        Toast.makeText(getActivity(), "B - Height: " + tAnsw1.getHeight() + " - S Height: " + screenHeight, Toast.LENGTH_LONG).show();

        /************* SETTING UP BUTTONS *************/
        RelativeLayout.LayoutParams A1Params = (RelativeLayout.LayoutParams)
                tAnsw1.getLayoutParams();
        A1Params.height = aButtonHeight;
        A1Params.width = aButtonWidth;

        tAnsw1.setLayoutParams(A1Params);



        /************* SETTING BUTTONS END*************/

        /************* SETTING UP FONTS FOR TABLETS *************/
        if (isTablet) {
            tAnsw1.setTextSize(fontSize);

        }
        /************* SETTING UP FONTS END *************/

    }

}
