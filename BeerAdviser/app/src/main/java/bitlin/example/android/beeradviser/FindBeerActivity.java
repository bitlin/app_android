package bitlin.example.android.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/* Whenever you add a button to a layout, it’s likely you’ll want it to do something when the user clicks on it.
To make this happen, you need to get the button to call a method in your activity.*/

//All activities (not just this one) have to extend the Activity class or one of its subclasses.
public class FindBeerActivity extends Activity {

    @Override
    //All activities also need to implement the onCreate() method. onCreate() method is called when the activity is first created
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Tells Android which layout the activity uses.
        setContentView(R.layout.activity_find_beer);
    }

// If the method doesn’t take this form, then it won’t respond when the user presses the button.
// * Must be public
// * Must have a void return value
// * Must have a single parameter of type View
//    The parameter View refers to the GUI component that triggers the method (in this case, the button).
//    GUI components such as buttons and text views are all types of View.
    public void onClickFindBeer(View view){

    }
}
