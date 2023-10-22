package com.example.callphoneexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(view -> {
            String phn = et1.getText().toString();
            Intent call = new Intent(Intent.ACTION_CALL);
            call.setData(Uri.parse("tel:" + phn));
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 1);
            }
            else {
                startActivity(call);
            }
        });
    }
}