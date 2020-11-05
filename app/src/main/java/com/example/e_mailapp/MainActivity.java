package com.example.e_mailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtMail, edtSub, edtMsg;
    Button btns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtMail = findViewById(R.id.mail);
        edtSub = findViewById(R.id.sub);
        edtMsg = findViewById(R.id.msg);
        btns = findViewById(R.id.btns);

        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = edtMail.getText().toString().trim();
                String sub = edtSub.getText().toString().trim();
                String msg = edtMsg.getText().toString().trim();

                if(mail.isEmpty()){
                    edtMail.requestFocus();
                    edtMail.setError("Fill first");
                }else{
                    Intent intentob = new Intent(Intent.ACTION_SENDTO);
                    intentob.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});
                    intentob.putExtra(Intent.EXTRA_SUBJECT, sub);
                    intentob.putExtra(Intent.EXTRA_TEXT,msg);
                    intentob.setData(Uri.parse("mailto:"));
                    startActivity(intentob);
                }


            }
        });
    }
}