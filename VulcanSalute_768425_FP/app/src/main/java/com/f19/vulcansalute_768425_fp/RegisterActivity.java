package com.f19.vulcansalute_768425_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import com.f19.vulcansalute_768425_fp.constants.Constants;

public class RegisterActivity extends AppCompatActivity {


    TableRow nbRow;
    TableRow carTypeRow;
    TableRow sideCarRow;
    TextView nb;

    short vehicleType;
    boolean sidecar;
    short employeeType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nbRow = findViewById(R.id.tbrow_nb);
        carTypeRow = findViewById(R.id.tbrow_cartype);
        sideCarRow = findViewById(R.id.tbrow_sidecar);

        initialize();

        Spinner spinnerEType = findViewById(R.id.spinner_etype);
        nb = findViewById(R.id.txtview_nb);
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

    private void initialize() {
        nbRow.setVisibility(View.GONE);
        carTypeRow.setVisibility(View.GONE);
        sideCarRow.setVisibility(View.GONE);

        employeeType = Constants.FIELD_NOT_SET;
        vehicleType = Constants.FIELD_NOT_SET;
        sidecar = Constants.BOOLEAN_FIELD_NOT_SET;
    }

    private void setEmploymentType(int i) {
        if(i > 0 && i < Constants.EmployeeType.length) {
            nbRow.setVisibility(View.VISIBLE);
            nb.setText(Constants.GainFactor[i-1]);
            employeeType = (short) i;
        } else {
            nbRow.setVisibility(View.GONE);
            employeeType = Constants.FIELD_NOT_SET;
        }
    }

    public void vehicleChecked(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.radio_car: {
                carTypeRow.setVisibility(View.VISIBLE);
                sideCarRow.setVisibility(View.GONE);
                vehicleType = Constants.VEHICLE_TYPE_CAR;
            }
                break;
            case R.id.radio_motorcycle: {
                carTypeRow.setVisibility(View.GONE);
                sideCarRow.setVisibility(View.VISIBLE);
                vehicleType = Constants.VEHICLE_TYPE_MOTORCYCLE;
            }
                break;
            default:
                carTypeRow.setVisibility(View.GONE);
                sideCarRow.setVisibility(View.GONE);
                vehicleType = Constants.FIELD_NOT_SET;
                break;
        }
    }
    public void sideCarChecked(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.radio_wscar: {
                sidecar = Constants.MOTORCYCLE_W_SIDECAR;
            }
            break;
            case R.id.radio_woutscar: {
                sidecar = Constants.MOTORCYCLE_WOUT_SIDECAR;
            }
            break;
            default:
                sidecar = Constants.BOOLEAN_FIELD_NOT_SET;
                break;
        }
    }
}
