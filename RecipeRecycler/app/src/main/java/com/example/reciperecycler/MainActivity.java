package com.example.reciperecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Iterator;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Recipe> listContents;
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        listContents = DataProvider.getRecipes();
        for(Iterator i = listContents.iterator(); i.hasNext();){
            Recipe temp = (Recipe)i.next();


        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new RecipeListAdapter(this, listContents);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
