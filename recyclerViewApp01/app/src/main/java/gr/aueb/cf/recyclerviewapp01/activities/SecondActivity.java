package gr.aueb.cf.recyclerviewapp01.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import gr.aueb.cf.recyclerviewapp01.R;

public class SecondActivity extends AppCompatActivity {
    private TextView titleTextView;
    private TextView genreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        titleTextView = findViewById(R.id.titleTextView);
        genreTextView = findViewById(R.id.genreTextView);

        Intent intent = getIntent();
        titleTextView.setText(intent.getStringExtra("title"));
        genreTextView.setText(intent.getStringExtra("genre"));
    }
}