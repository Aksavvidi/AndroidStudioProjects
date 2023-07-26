package gr.aueb.cf.multirelativeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RatingBar likeRB;
    private SeekBar ageSB;
    private Switch switchBtn;
    private Button submitBtn;
    private RelativeLayout fullView;
    private TextView ageTV;
    private TextView scrollTV;
    private RadioButton yesRB;
    private RadioButton noRB;
    private CheckBox athensCB;
    private CheckBox patrasCB;
    private String ratingStars;
    private String agree;
    private ArrayList<String> checkBoxList;
    private String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeRB = findViewById(R.id.likeRB);
        ageSB= findViewById(R.id.ageSB);
        switchBtn= findViewById(R.id.switchBtn);
        submitBtn= findViewById(R.id.submitBtn);
        fullView= findViewById(R.id.fullView);
        ageTV= findViewById(R.id.seekBarTitleTV);
        scrollTV= findViewById(R.id.scrollTV);
        yesRB= findViewById(R.id.yesRB);
        noRB= findViewById(R.id.noRB);
        athensCB= findViewById(R.id.athensCB);
        patrasCB= findViewById(R.id.patrasCB);
        checkBoxList = new ArrayList<>();

        likeRB.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingStars = String.valueOf(rating);
                Toast.makeText(MainActivity.this,ratingStars, Toast.LENGTH_SHORT).show();
            }
        });
        ageSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageTV.setText("Set your age (allowed 18-65)" + progress);
                age = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    switchBtn.setText("Dark");
                    scrollTV.setBackgroundColor(getColor(R.color.blue_03));
                    fullView.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue_02));
                }else {
                    switchBtn.setText("Ligth");
                    scrollTV.setBackgroundColor(getColor(R.color.blue_02));
                    fullView.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.blue_01));
                }
            }
        });

        noRB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    agree = "no";
                }
            }
        });

        yesRB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    agree = "yes";
                }
            }
        });

        athensCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBoxList.add("Athens");
                }else {
                    checkBoxList.remove("Athens");
                }
                Toast.makeText(MainActivity.this,checkBoxList.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        // δεύτερος τρόποσ δεν προτιματε
        patrasCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(patrasCB.isChecked()){
                    checkBoxList.add("Patras");
                }else {
                    checkBoxList.remove("Patras");
                }
                Toast.makeText(MainActivity.this,checkBoxList.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("agree", agree);
                intent.putExtra("rate", ratingStars);
                intent.putExtra("age", age);
                intent.putStringArrayListExtra("cities", checkBoxList);
                startActivity(intent);
                //finish(); δεν επιτρέπει να κανείσ πίσω στην MainActivity
            }
        });

    }
}