package gr.aueb.cf.myapplication001.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import gr.aueb.cf.myapplication001.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ActivityLifecycle";

    private TextView textView;
    private Button button;
    private String message;
    private EditText nameEditText;
     private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        //"connect with "
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        nameEditText = findViewById(R.id.nameEditText);
        imageView = findViewById(R.id.imageView);

        message = "Hello Coding Factory";

        textView.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked me", Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.test_anroid);
                String name =nameEditText.getText().toString().trim();
                textView.setText(name);
               // Toast.makeText(MainActivity.this, "You clicked me", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

}
