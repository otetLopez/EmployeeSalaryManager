package com.f19.vulcansalute_768425_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.f19.vulcansalute_768425_fp.constants.Constants;
import com.f19.vulcansalute_768425_fp.src.Simulator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Constants.ENABLE_DEBUG) {
            /** Run test simulation */
            Simulator simulator = new Simulator();
            simulator.run();
        }

    }
}
