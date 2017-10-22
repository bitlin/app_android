package bitlin.example.android.starbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

//        If you need to bind your list view to data held in something other than a String array resource, you need use an adapter
//        An adapter acts as a bridge between a view and a data source. There are several different types of adapter. For now, we’re going to focus on array adapters.
//        An ArrayAdapter is a type of adapter that specializes in working with arrays.

//        You use an array adapter by initializing it and then attaching it to the list view.
//       Here’s the code to create an array adapter that displays drink data from the Drink.drinks array
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drink.drinks);

//        You then attach the array adapter to the list view using the ListView setAdapter() method:
        ListView listDrinks = (ListView) findViewById(R.id.list_drinks);
        listDrinks.setAdapter(listAdapter);
// Behind the scenes, the array adapter takes each item in the array, converts it to a String using its toString() method,
// and puts each result into a text view. It then displays each text view as a single row in the list view.
    }
}

//    What happens when you run the code
//1. When the user clicks on the Drinks option, DrinkCategoryActivity is launched.Its layout has a LinearLayout that contains a ListView.
//2. DrinkCategoryActivity creates an ArrayAdapter<Drink>, an array adapter that deals with arrays of Drink objects.
//3. The array adapter retrieves data from the drinks array in the Drink class.
//It uses the Drink.toString() method to return the name of each drink
//4. DrinkCategoryActivity makes the ListView use the array adapter via the setAdapter() method.