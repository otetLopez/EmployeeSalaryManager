package com.f19.vulcansalute_768425_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import com.f19.vulcansalute_768425_fp.constants.Constants;

public class RegisterActivity extends AppCompatActivity {

    Spinner spinnerEType;
    TableRow nbRow;
    TextView nb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nbRow = findViewById(R.id.tbrow_nb);
        nbRow.setVisibility(View.GONE);

        spinnerEType = findViewById(R.id.spinner_etype);
        nb = findViewById(R.id.txtview_nb);

//        spinnerEType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                setEmploymentType(i);
//            }
//        });
        spinnerEType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setEmploymentType(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setEmploymentType(int i) {
        if(i > 0 && i < Constants.EmployeeType.length) {
            nbRow.setVisibility(View.VISIBLE);
            nb.setText(Constants.GainFactor[i]);
        } else {
            nbRow.setVisibility(View.GONE);
        }
    }
}
