package bitlin.example.android.starbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends Activity {

//    We’re using a constant for the name of the extra information in the intent so that we know DrinkCategoryActivity and DrinkActivity are using the same String.
// We’ll add this constant to DrinkActivity when we create the activity.
    public static final String EXTRA_DRINKID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

//     When the detail activity is started, it can retrieve the extra information from the intent and use it to populate its views.
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);

//        In our case, we can use drinkId to get details of the drink the user selected. drinkId is the ID of the drink,
// the index of the drink in the drinks array. This means that you can get details about the drink the user clicked on using:
        Drink drink = Drink.drinks[drinkId];
// This gives us a Drink object containing all the information we need to update the views attributes in the activity

        //Populate the drink name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(drink.getName());

        //Populate the drink description
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(drink.getDescription());

        //Populate the drink image
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }
}
