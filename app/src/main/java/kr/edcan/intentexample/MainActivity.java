package kr.edcan.intentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText phone_num, sms_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefault();

    }

    private void setDefault() {
        phone_num = (EditText) findViewById(R.id.phone_number);
        sms_text = (EditText) findViewById(R.id.send_text);
        button = (Button) findViewById(R.id.button_send);
        button.setOnClickListener(this);
    }

    private void sendSMS() {
        Uri sms_uri = Uri.parse("smsto:" + phone_num.getText().toString());
        Intent sms_intent = new Intent(Intent.ACTION_SENDTO, sms_uri);
        sms_intent.putExtra("sms_body", sms_text.getText().toString().trim());
        startActivity(sms_intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_send:
                if (!phone_num.getText().toString().trim().equals("") && !sms_text.getText().toString().trim().equals(""))
                    sendSMS();
                else Toast.makeText(MainActivity.this, "빈칸 없이 완성해주세요!", Toast.LENGTH_SHORT).show();
        }
    }

}
