package com.example.reciperecycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

import static android.support.v4.content.ContextCompat.startActivity;

public class RecipeListAdapter extends
        RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private final LinkedList<Recipe> mRecipeList;
    private final LayoutInflater mInflater;

    class RecipeViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView recipeTitleView;
        public final TextView recipeDescView;
        final RecipeListAdapter mAdapter;


        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            recipeTitleView = itemView.findViewById(R.id.lblRecipeName);
            recipeDescView = itemView.findViewById(R.id.lblRecipDescription);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();

            Recipe recipe = mRecipeList.get(mPosition);

            Intent detailIntent = new Intent(view.getContext(), ActivityRecipeDetail.class);
            detailIntent.putExtra("recipe",recipe);
            mAdapter.notifyDataSetChanged();
            view.getContext().startActivity(detailIntent);
        }
    }

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeList) {
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipeList;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to
     * represent an item.
     *
     * This new ViewHolder should be constructed with a new View that can
     * represent the items of the given type. You can either create a new View
     * manually or inflate it from an XML layout file.
     *
     * The new ViewHolder will be used to display items of the adapter using
     * onBindViewHolder(ViewHolder, int, List). Since it will be reused to
     * display different items in the data set, it is a good idea to cache
     * references to sub views of the View to avoid unnecessary findViewById()
     * calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after
     *                 it is bound to an adapter position.
     * @param viewType The view type of the new View. @return A new ViewHolder
     *                 that holds a View of the given view type.
     */
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        // Inflate an item view.
        View mItemView = mInflater.inflate(
                R.layout.recipelist_item, parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the ViewHolder.itemView to
     * reflect the item at the given position.
     *
     * @param holder   The ViewHolder which should be updated to represent
     *                 the contents of the item at the given position in the
     *                 data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder,
                                 int position) {
        // Retrieve the data for that position.
        Recipe mCurrent = mRecipeList.get(position);
        // Add the data to the view holder.
        holder.recipeTitleView.setText(mCurrent.name);
        holder.recipeDescView.setText(mCurrent.description);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}