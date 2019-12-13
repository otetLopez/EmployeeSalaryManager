package com.f19.vulcansalute_768425_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.f19.vulcansalute_768425_fp.constants.Constants;
import com.f19.vulcansalute_768425_fp.src.Car;
import com.f19.vulcansalute_768425_fp.src.Employee;
import com.f19.vulcansalute_768425_fp.src.Manager;
import com.f19.vulcansalute_768425_fp.src.Motorcycle;
import com.f19.vulcansalute_768425_fp.src.Programmer;
import com.f19.vulcansalute_768425_fp.src.Tester;
import com.f19.vulcansalute_768425_fp.src.Vehicle;

public class RegisterActivity extends AppCompatActivity {


    TableRow nbRow;
    TableRow carTypeRow;
    TableRow sideCarRow;
    TextView nb;

    boolean missingflds;
    short vehicleType;
    boolean sidecar;
    short employeeType;
    short vehicleColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nbRow = findViewById(R.id.tbrow_nb);
        carTypeRow = findViewById(R.id.tbrow_cartype);
        sideCarRow = findViewById(R.id.tbrow_sidecar);

        initialize();

        final Spinner spinnerEType = findViewById(R.id.spinner_etype);
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

        final Spinner spinnerColor = findViewById(R.id.spinner_vcolor);
        spinnerColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0)
                    vehicleColor = (short) (i-1);
                else
                    vehicleColor = Constants.FIELD_NOT_SET;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final EditText fnametxt = findViewById(R.id.edittxt_fname);
        final EditText lnametxt = findViewById(R.id.edittxt_lname);
        final EditText byeartxt = findViewById(R.id.edittxt_byear);
        final EditText salarytxt = findViewById(R.id.edittxt_msalary);
        final EditText oratetxt = findViewById(R.id.edittxt_orate);
        final EditText idtxt = findViewById(R.id.edittxt_eid);
        // Employee Spinner
        final EditText nbtxt = findViewById(R.id.edittxt_nb);
        //Radio Vehicle Type
        final EditText ctypetxt = findViewById(R.id.edittxt_ctype);
        //Radio Sidecar
        final EditText modeltxt = findViewById(R.id.edittxt_vmodel);
        final EditText pnumbertxt = findViewById(R.id.edittxt_pnumber);
        //Vehicle Color Spinner

        Button btn = findViewById(R.id.btn_reg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(!checkMissingFields()) {

                //}
                String message = "";
                if(fnametxt.getText().toString().isEmpty())
                    message += "First Name";
                if(lnametxt.getText().toString().isEmpty())
                    message += message.isEmpty() ? "Last Name" : ", Last Name";
                if(byeartxt.getText().toString().isEmpty())
                    message += message.isEmpty() ? "Birth Year" : ", Birth Year";
                if(salarytxt.getText().toString().isEmpty())
                    message += message.isEmpty() ? "Monthly Salary" : ", Monthly Salary";
                if(oratetxt.getText().toString().isEmpty())
                    message += message.isEmpty() ? "Occupation Rate" : ", Occupation Rate";
                if(idtxt.getText().toString().isEmpty())
                    message += message.isEmpty() ? "ID" : ", ID";
                if(employeeType == Constants.FIELD_NOT_SET)
                    message += message.isEmpty() ? "Employee Type" : ", Employee Type";
                else {
                    if(nbtxt.getText().toString().isEmpty())
                        message += message.isEmpty() ? "Number of contributions" : ", Number of contributions";
                }
                if(vehicleType == Constants.FIELD_NOT_SET)
                    message += message.isEmpty() ? "Vehicle Type" : ", Vehicle Type";
                else {
                    if(vehicleType == Constants.VEHICLE_TYPE_CAR) {
                        if(ctypetxt.getText().toString().isEmpty())
                            message += message.isEmpty() ? "Car Type" : ", Car Type";
                    }
                    else if(vehicleType == Constants.VEHICLE_TYPE_MOTORCYCLE) {
                        if(sidecar == Constants.BOOLEAN_FIELD_NOT_SET)
                            message += message.isEmpty() ? "Side Car" : ", Side Car";
                    }
                }
                if(modeltxt.getText().toString().isEmpty())
                    message += message.isEmpty() ? "Model" : ", Model";
                if(pnumbertxt.getText().toString().isEmpty())
                    message += message.isEmpty() ? "Plate Number" : ", Plate Number";
                if(vehicleColor == Constants.FIELD_NOT_SET)
                    message += message.isEmpty() ? "Vehicle Color" : ", Vehicle Color";

                if(!message.isEmpty())
                    Toast.makeText(RegisterActivity.this, "Make sure the following fields are filled : " + message, Toast.LENGTH_LONG).show();

                else {
                    if (Integer.valueOf(byeartxt.getText().toString()) < 1900)
                        Toast.makeText(RegisterActivity.this, "Your Birth Year is invalid.  Please make sure you were born after 1900s", Toast.LENGTH_SHORT).show();
                    else {
                        Vehicle v = (vehicleType == Constants.VEHICLE_TYPE_CAR) ?
                                new Car(modeltxt.getText().toString(), pnumbertxt.getText().toString(), Constants.Colors[vehicleColor], ctypetxt.getText().toString()) :
                                new Motorcycle(modeltxt.getText().toString(), pnumbertxt.getText().toString(), Constants.Colors[vehicleColor], sidecar);

                        //Employee employee = null;
                        Intent returnIntent = new Intent();
                        switch (employeeType) {
                            case Constants.EMPLOYMENT_CODE_MANAGER: {
                                Manager manager = new Manager(fnametxt.getText().toString(), lnametxt.getText().toString(),
                                        idtxt.getText().toString(), Integer.valueOf(byeartxt.getText().toString()),
                                        Double.valueOf(salarytxt.getText().toString()), Double.valueOf(oratetxt.getText().toString()),
                                        v, Integer.valueOf(nbtxt.getText().toString()));
                                returnIntent.putExtra("employeeType", Constants.EMPLOYMENT_CODE_MANAGER);
                                returnIntent.putExtra("newEmployee", manager);
                                setResult(MainActivity.RESULT_OK, returnIntent);
                                finish();
                            }
                            break;
                            case Constants.EMPLOYMENT_CODE_TESTER: {
                                Tester tester = new Tester(fnametxt.getText().toString(), lnametxt.getText().toString(),
                                        idtxt.getText().toString(), Integer.valueOf(byeartxt.getText().toString()),
                                        Double.valueOf(salarytxt.getText().toString()), Double.valueOf(oratetxt.getText().toString()),
                                        v, Integer.valueOf(nbtxt.getText().toString()));
                                returnIntent.putExtra("employeeType", Constants.EMPLOYMENT_CODE_TESTER);
                                returnIntent.putExtra("newEmployee", tester);
                                setResult(MainActivity.RESULT_OK, returnIntent);
                                finish();
                            }
                            break;
                            case Constants.EMPLOYMENT_CODE_PROGRAMMER: {
                                Programmer programmer = new Programmer(fnametxt.getText().toString(), lnametxt.getText().toString(),
                                        idtxt.getText().toString(), Integer.valueOf(byeartxt.getText().toString()),
                                        Double.valueOf(salarytxt.getText().toString()), Double.valueOf(oratetxt.getText().toString()),
                                        v, Integer.valueOf(nbtxt.getText().toString()));
                                returnIntent.putExtra("employeeType", Constants.EMPLOYMENT_CODE_PROGRAMMER);
                                returnIntent.putExtra("newEmployee", programmer);
                                setResult(MainActivity.RESULT_OK, returnIntent);
                                finish();
                            }
                            break;
                            default:
                                Toast.makeText(RegisterActivity.this, "ERROR: Employee record not created.  Employment type invalid.", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                }
            }
        });
    }

    private void initialize() {
        missingflds = false;

        nbRow.setVisibility(View.GONE);
        carTypeRow.setVisibility(View.GONE);
        sideCarRow.setVisibility(View.GONE);

        employeeType = Constants.FIELD_NOT_SET;
        vehicleType = Constants.FIELD_NOT_SET;
        sidecar = Constants.BOOLEAN_FIELD_NOT_SET;
        vehicleColor = Constants.FIELD_NOT_SET;
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
