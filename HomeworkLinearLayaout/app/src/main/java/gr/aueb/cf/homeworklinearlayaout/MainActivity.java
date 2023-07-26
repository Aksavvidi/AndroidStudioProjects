package gr.aueb.cf.homeworklinearlayaout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private EditText usernameET;
    private EditText passwordET;
    private Button loginBtn;
    private TextView resetPasswordTV;
    private TextView registerTV;
    private TextView signupTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        loginBtn = findViewById(R.id.loginBtn);
        resetPasswordTV = findViewById(R.id.resetPasswordTV);
        registerTV = findViewById(R.id.registerTV);
        signupTV = findViewById(R.id.signupTV);

        String username = usernameET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidCredentials(username, password)){
                    displayWelcomeMessage(username);
                }else {
                    displayErrorMessage();
                }
            }
        });
    }
    private boolean isValidCredentials(String username, String password){
        return username.equals("admin") && password.equals("cars");
    }
    private void displayWelcomeMessage(String username){
        String message = "Welcome " + username;
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
    private void displayErrorMessage(){
        Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
    }
}