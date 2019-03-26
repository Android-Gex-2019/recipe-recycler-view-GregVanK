package com.example.reciperecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Iterator;
import java.util.LinkedList;

/***
 * Author:Greg VanKampen
 * Date:3/25/2019
 * File:MainActivity
 */
public class MainActivity extends AppCompatActivity {

    private LinkedList<Recipe> listContents;
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //get recipes
        listContents = DataProvider.getRecipes();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create recycler view
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new RecipeListAdapter(this, listContents);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
