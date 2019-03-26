package com.example.reciperecycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/***
 * Author:Greg VanKampen
 * Date:3/25/2019
 * File:RecipeListAdapter
 */

public class RecipeListAdapter extends
        RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private final LinkedList<Recipe> mRecipeList;
    private final LayoutInflater mInflater;

    class RecipeViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView recipeTitleView;
        public final TextView recipeDescView;
        final RecipeListAdapter mAdapter;


        /**
         * View holder constructor
         * @param itemView
         * @param adapter
         */
        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            recipeTitleView = itemView.findViewById(R.id.lblRecipeName);
            recipeDescView = itemView.findViewById(R.id.lblRecipDescription);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        /**
         * opens recipe when viewholder is clicked
         * @param view
         */
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
     * Generates a view container for the content
     * @param parent
     * @param viewType
     * @return
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
     * Inserts data into the view holder
     * @param holder
     * @param position
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
     * returns the size of the list adapter
     * @return
     */
    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }
}