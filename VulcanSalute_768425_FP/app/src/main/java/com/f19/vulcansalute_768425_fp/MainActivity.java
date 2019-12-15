package com.f19.vulcansalute_768425_fp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.f19.vulcansalute_768425_fp.constants.Constants;
import com.f19.vulcansalute_768425_fp.src.Car;
import com.f19.vulcansalute_768425_fp.src.Employee;
import com.f19.vulcansalute_768425_fp.src.ListObject;
import com.f19.vulcansalute_768425_fp.src.Manager;
import com.f19.vulcansalute_768425_fp.src.Motorcycle;
import com.f19.vulcansalute_768425_fp.src.Programmer;
import com.f19.vulcansalute_768425_fp.src.Simulator;
import com.f19.vulcansalute_768425_fp.src.Tester;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    View v;

    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<String> uniqueID = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Constants.ENABLE_DEBUG) {
            /** Run test simulation */
            Simulator simulator = new Simulator();
            simulator.run();
        }
        if(Constants.DEBUG_ADD_INITIAL_DATA) {
            /** Add initial data for testing */
            add_test_data();
        }

        /** Setup RecyclerView */
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setOnClickListener(new );

        /** Update display list */
        updateList(Constants.NO_SEARCH_FILTER);

        /** Setup search bar */
        SearchView search = findViewById(R.id.search);
        search.setOnQueryTextListener(this);

        Button btn = findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                intent.putExtra("uniqueID", uniqueID);
                startActivityForResult(intent, Constants.INTENT_REQUEST_CODE_ADD_OK);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constants.INTENT_REQUEST_CODE_ADD_OK) {
            if(resultCode == RESULT_OK) {
                Employee employee = (Employee) data.getExtras().get("newEmployee");
                //if(isIDValid(employee.getId())) {
                    employees.add((Employee) data.getExtras().get("newEmployee"));
                    uniqueID.add(employee.getId());
                //}
                //else
                //    Toast.makeText(MainActivity.this, "ID you used is already registered.  Please try again", Toast.LENGTH_SHORT).show();
            }
        }
        updateList(Constants.NO_SEARCH_FILTER);
    }

    private void updateList(String filter) {

        ArrayList<ListObject> names = new ArrayList<>();
        ArrayList<Employee> filteredEmployees = new ArrayList<>();
        for(int i=0; i<employees.size(); ++i) {
            String name = employees.get(i).getFname() + " " + employees.get(i).getLname();
            ListObject listObject = new ListObject("Name\t\t: " + name, "ID\t\t: " + employees.get(i).getId());
            if(!filter.isEmpty()) {
                if (name.toLowerCase().contains(filter.toLowerCase())) {
                    names.add(listObject);
                    filteredEmployees.add(employees.get(i));
                }
            } else {
                names.add(listObject);
                filteredEmployees.add(employees.get(i));
            }
        }

        // specify an adapter (see also next example)
        AdapterView.OnItemClickListener itemClickListener = null;
        mAdapter = new ObjectListAdapter(filteredEmployees, names, itemClickListener);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        updateList(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        updateList(s);
        return false;
    }

    private boolean isIDValid(String id) {
        for(int i=0; i<employees.size(); ++i) {
            if(employees.get(i).getId().toLowerCase().equals(id.toLowerCase()))
                return false;
        }
        return true;
    }

    private void add_test_data() {
        Car v1 = new Car("Lamborghini", "Custom Plate", "White", "Sport");
        Car v2 = new Car("BMW", "Custome Plate", "Black", "Sedan");
        Motorcycle v3 = new Motorcycle("Kawasaki", "Custome Plate", "Yellow", false);
        Motorcycle v4 = new Motorcycle("Honda", "Custome Plate", "Black", true);

        Manager serge = new Manager("Serge", "E","e1", 1985, 7456.0, 100, v1, 30);
        employees.add(serge);
        uniqueID.add("e1");
        Manager cindy = new Manager("Cindy", "E", "e2", 1974, 8240, 80, v2, 20);
        employees.add(cindy);
        uniqueID.add("e2");
        Programmer paul = new Programmer("Paul", "Z", "e3",1993, 6456, 75, v3, 3);
        employees.add(paul);
        uniqueID.add("e3");
        Tester pierre = new Tester("Pierre", "D", "e4",1987, 5456, 50, v4, 124);
        employees.add(pierre);
        uniqueID.add("e4");
    }
}
