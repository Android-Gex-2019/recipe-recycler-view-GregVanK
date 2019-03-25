package com.example.reciperecycler;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ActivityRecipeDetail extends AppCompatActivity {

    TextView nameText;
    TextView ingredientsText;
    TextView directionsText;
    ImageView foodImage;
    Recipe currentRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        currentRecipe = (Recipe)getIntent().getSerializableExtra("recipe");
        nameText =(TextView) findViewById(R.id.txtRecipeDetailTitle);
        ingredientsText =(TextView) findViewById(R.id.txtIngredientsBody);
        directionsText =(TextView) findViewById(R.id.txtDirectionsBody);
        foodImage = (ImageView) findViewById(R.id.imgRecipe);


        nameText.setText(currentRecipe.name);
        ingredientsText.setText(currentRecipe.ingredients);
        directionsText.setText(currentRecipe.directions);
        Picasso.get()
                .load(currentRecipe.image)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(foodImage);

    }

}
