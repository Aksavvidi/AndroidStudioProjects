package gr.aueb.cf.advancewidgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioBtnActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton submitBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_btn);

        radioGroup = findViewById(R.id.radioGroup);
        submitBtn2 = findViewById(R.id.submitBtn2);

        submitBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                RadioButton radioButton = findViewById(selectedId);
                Toast.makeText(RadioBtnActivity.this, "Selected Delivery: " + radioButton.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}