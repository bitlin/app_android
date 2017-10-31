package bitlin.example.android.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}

//1. When the app is launched, activity MainActivity gets created. The user clicks on the button in MainActivity to start DetailActivity
//2. DetailActivity’s onCreate() method runs. The onCreate() method specifies that activity_detail.xml should be used for DetailActivity’s layout.
//3. activity_detail.xml sees that it includes a <fragment> element that refers to WorkoutDetailFragment.
//4. WorkoutDetailFragment’s onCreateView() method is called.
//   The onCreateView() method specifies that fragment_workout_detail.xml should be used for WorkoutDetailFragment’s layout.
//   It inflates the layout to a View object.
//5. activity_detail.xml’s Views are inflated to View Java objects.
//    DetailActivity layout uses WorkoutDetailFragment’s View object in place of the <fragment> element in its layout’s XML.
//6. Finally, DetailActivity is displayed on the device.
//   Its layout contains the fragment WorkoutDetailFragment
