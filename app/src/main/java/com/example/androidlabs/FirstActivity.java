package com.example.androidlabs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //find button 1 from what was loaded, add a click listener
        /*Button page1Button = findViewById(R.id.firstButton);
        if(page1Button != null)
            page1Button.setOnClickListener(v -> {
                Intent goToPage2 = new Intent(FirstActivity.this, SecondActivity.class);
                    startActivity(goToPage2);
            });
*/
        EditText editText = findViewById(R.id.emailInput);

        //use a Lambda function to set a click listener
        Button page1Button = (Button)findViewById(R.id.loginButton);
        if(page1Button != null){
            page1Button.setOnClickListener(clk -> {
                Intent goToPage2 = new Intent(FirstActivity.this, SecondActivity.class);
                goToPage2.putExtra("emailInput",editText.getText().toString());

               startActivity(goToPage2);
               // startActivityForResult(goToPage2, 30);
            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 30) //you went to page 3 (look at line 38)
        {
            if(resultCode == 50) //you hit the finish button
            {
                Toast.makeText(this, "You came back from page 3 by hitting the finish button",
                        Toast.LENGTH_LONG).show();
            }
            else if(resultCode == RESULT_CANCELED) //you hit the back button
            {
                Toast.makeText(this, "You came back from page 3 by hitting the back button",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

 */
}
