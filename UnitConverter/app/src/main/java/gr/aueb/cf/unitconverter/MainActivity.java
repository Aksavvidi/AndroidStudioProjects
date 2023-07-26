package gr.aueb.cf.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private Button convertBtn;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        convertBtn = findViewById(R.id.convertBtn);
        result = findViewById(R.id.result);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kilos = inputValue.getText().toString();
                Double kilograms = Double.parseDouble(kilos);
                double pounds = kilograms * 2.20462;
                double roundedPounds = Math.ceil(pounds); // Round up the pounds value
                result.setText(String.valueOf(roundedPounds));
            }
        });
    }
}