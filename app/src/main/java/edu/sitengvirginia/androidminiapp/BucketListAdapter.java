package edu.sitengvirginia.androidminiapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class BucketListAdapter extends
        RecyclerView.Adapter<BucketListAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView dateTextView;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.bucketItemName);
            dateTextView = (TextView) itemView.findViewById(R.id.bucketItemDate);

        }
    }

    // Store a member variable for the contacts
    private ArrayList<BucketItem> mItems;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public BucketListAdapter(Context context, ArrayList<BucketItem> items) {
        mItems = items;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public BucketListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.bucket_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(BucketListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        BucketItem bucket = mItems.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        String bucketDisplay = bucket.getMname();
        textView.setText(bucketDisplay);

        TextView dateView = viewHolder.dateTextView;
        String dateDisplay = bucket.getMdate();
        dateView.setText(dateDisplay);

        }



    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
