package com.f19.vulcansalute_768425_fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.f19.vulcansalute_768425_fp.src.ListObject;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class ObjectListAdapter extends RecyclerView.Adapter<ObjectListAdapter.MyViewHolder> {
    private ArrayList<ListObject> mDataset;

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
        }

        void bindData(ListObject listObject) {
            if (listObject == null)
                return;

            name.setText(listObject.title);
            id.setText(listObject.subTitle);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ObjectListAdapter(ArrayList<ListObject> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ObjectListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View  v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
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
}

