package com.e.modernui2;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.content.DialogInterface.*;
import static android.content.Intent.*;

public class MainActivity extends AppCompatActivity {

    private TextView geo1; private TextView geo2; private TextView geo3; private TextView geo5;
    //private TextView geo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geo1 = findViewById(R.id.textView11);
        geo2 = findViewById(R.id.textView12);
        geo3 = findViewById(R.id.textView10);
        //geo4 = findViewById(R.id.textView8);
        geo5 = findViewById(R.id.textView9);
        SeekBar seekBarValue = findViewById(R.id.seekBar);
        seekBarValue.setOnSeekBarChangeListener(seekBarListener);
    }

    private SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            geo1.setBackgroundColor(Color.parseColor("#5c6bc0")*progress/50);
            geo2.setBackgroundColor(Color.parseColor("#d500f9")*progress/50);
            geo3.setBackgroundColor(Color.parseColor("#9b0000")*progress/50);
           // geo4.setBackgroundColor(Color.parseColor("#e0e0e0")*progress/50);
            geo5.setBackgroundColor(Color.parseColor("#1a237e")*progress/50);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dot_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem info) {
        int id = info.getItemId();
        if(id == R.id.info){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, AlertDialog.THEME_HOLO_DARK);

            builder.setNegativeButton("Cancel", onClick);
            builder.setPositiveButton("Visit Site", onClick);
            builder.setMessage("Inspired by the works of MoMA artists such as Piet Mondrian and Ben Nicholson.. \nClick below to learn more!");
            AlertDialog dialog = builder.show();

            TextView alertMessage = (TextView) dialog.findViewById(android.R.id.message);
            alertMessage.setGravity(Gravity.CENTER);

            return true;
        }
        return super.onOptionsItemSelected(info);
    }

    OnClickListener onClick = new OnClickListener() {

        public void onClick(DialogInterface dialog, int which) {
            if (which == BUTTON_NEGATIVE) {
                dialog.cancel();
            } else if (which == BUTTON_POSITIVE) {
                String urlString = "http://www.moma.org";
                Intent baseIntent = new Intent(ACTION_VIEW, Uri.parse(urlString));
                Intent ichoose = createChooser(baseIntent, "Load " + urlString + " with: ");
                startActivity(ichoose);
            }
        }
    };

}