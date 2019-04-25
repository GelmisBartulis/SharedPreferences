package com.ge20070469.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private EditText name, email, mob1, mob2, city;
    private Button save, kill;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameText);
        email = findViewById(R.id.emailText);
        mob1 = findViewById(R.id.mob1Text);
        mob2 = findViewById(R.id.mob2Text);
        city = findViewById(R.id.cityText);
        save = findViewById(R.id.save);
        kill = findViewById(R.id.kill);

        save.setOnClickListener(this);
        kill.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("Reg", Context.MODE_PRIVATE);

        if(sharedPreferences.contains("Name")) {
            name.setText(sharedPreferences.getString("Name", null));
            email.setText(sharedPreferences.getString("Email", null));
            mob1.setText(sharedPreferences.getString("Mob1", null));
            mob2.setText(sharedPreferences.getString("Mob2", null));
            city.setText(sharedPreferences.getString("City", null));
        } else {
            Toast.makeText(this, "There were no details recorded previously", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
        editor = sharedPreferences.edit();
        switch (v.getId()) {
            case R.id.save:
                editor.putString("Name", name.getText().toString());
                editor.putString("Email",email.getText().toString());
                editor.putString("Mob1", mob1.getText().toString());
                editor.putString("Mob2", mob2.getText().toString());
                editor.putString("City", city.getText().toString());
                editor.apply();
                break;

            case R.id.kill:
                System.exit(0);
                break;
        }
    }
}
