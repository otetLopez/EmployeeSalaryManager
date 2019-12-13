package com.f19.vulcansalute_768425_fp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.f19.vulcansalute_768425_fp.constants.Constants;
import com.f19.vulcansalute_768425_fp.src.Employee;
import com.f19.vulcansalute_768425_fp.src.ListObject;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class ObjectListAdapter extends RecyclerView.Adapter<ObjectListAdapter.MyViewHolder> implements AdapterView.OnItemClickListener {
    private ArrayList<ListObject> mDataset;
    private ArrayList<Employee> employees;

    AdapterView.OnItemClickListener itemClickListener;
    int position = -1;
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;
        public TextView id;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            id = (TextView) itemView.findViewById(R.id.id);
            //itemView.setOnClickListener(itemClickListener);
        }

        void bindData(ListObject listObject) {
            if (listObject == null)
                return;

            name.setText(listObject.title);
            id.setText(listObject.subTitle);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ObjectListAdapter(ArrayList<Employee> employees, ArrayList<ListObject> myDataset, AdapterView.OnItemClickListener itemClickListener) {
        this.mDataset = myDataset;
        this.employees = employees;
        this.itemClickListener = itemClickListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ObjectListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View  v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view, parent, false);

        final MyViewHolder vh = new MyViewHolder(v);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Click", "Clicked on item " + vh.name.getText().toString() + " at pos " + getAdapterPosition(vh.name.getText().toString()));
                position = getAdapterPosition(vh.name.getText().toString());
                //itemClickListener.onItemClick(itemClickListener, view, position, 0);
                //itemClickListener.onItemClick(view, getAdapterPosition(vh.name.getText().toString()));
                Context context = view.getContext();
                Intent intent = new Intent(context, EmployeeDetailsActivity.class);
                intent.putExtra("details", employees.get(position));
                context.startActivity(intent);
                //view.getContext().startActivityForResult(intent, Constants.INTENT_REQUEST_CODE_DISPLAY);
            }
        });
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindData(mDataset.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public int getAdapterPosition (String title) {
        for(int i = 0; i< mDataset.size(); ++i) {
            if(mDataset.get(i).title.equals(title))
                return i;
        }
        return -1;
    }
}

