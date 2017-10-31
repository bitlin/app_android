package bitlin.example.android.workout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WorkoutDetailFragment extends Fragment {
//  When you have an activity that uses a fragment, the activity will usually need to talk to the fragment in some way. As an example, if you have
//  a fragment that displays detail records, you need the activity to tell the fragment which record it needs to display details of.

//  In our case, we need WorkoutDetailFragment to display details of a particular workout.
//  To do this, we’ll add a simple setter method to the fragment that sets the value of the workout ID.
//  The activity will then be able to use this method to set the workout ID. Later on, we’ll use the workout ID to update the fragment’s views.
    private long workoutId;


//    onCreateView() method, which gets called each time Android needs the fragment’s layout,
//    and it’s where you say which layout the fragment uses.
//   The onCreateView() method returns a View object that represents the fragment’s user interface.
//  It gets called when Android is ready to instantiate the user interface
// * The first parameter is a LayoutInflator that you can use to inflate the fragment’s layout. Inflating the layout turns your XML views into Java objects.
// * The second parameter is a ViewGroup. This is the ViewGroup in the activity’s layout that will contain the fragment.
// * The final parameter is a Bundle. This is used if you’ve previously saved the fragment’s state, and want to reinstate it.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // You specify the fragment’s layout using the LayoutInflator’s inflate() method:
//      This is the fragment equivalent of calling an activity’s setContentView() method.
//      You use it to say what layout the fragment should use, in this case R.layout.fragment_ workout_detail.
//      The inflate() method’s container argument specifies the ViewGroup in the activity that the fragment’s layout needs to be inserted into.
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

//    The activity will use this method to set the value of the workout ID.
    public void setWorkout(long id) {
        this.workoutId = id;
    }
}
