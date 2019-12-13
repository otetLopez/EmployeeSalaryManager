package com.f19.vulcansalute_768425_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.f19.vulcansalute_768425_fp.src.Employee;

public class EmployeeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        Intent intent = getIntent();
        Employee employee = (Employee) intent.getExtras().get("details");

        TextView textView = findViewById(R.id.detailstxt);
        textView.setText(employee.toString());

        Button btn_ok = findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                setResult(MainActivity.RESULT_CANCELED,returnIntent);
                finish();
            }
        });
    }


}
