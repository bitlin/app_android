package bitlin.example.android.starbuzz;

import android.app.Activity;
import android.os.Bundle;

public class DrinkActivity extends Activity {

//    We’re using a constant for the name of the extra information in the intent so that we know DrinkCategoryActivity and DrinkActivity are using the same String.
// We’ll add this constant to DrinkActivity when we create the activity.
    public static final String EXTRA_DRINKID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
    }
}
