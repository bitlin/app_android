package bitlin.example.android.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

//We’ll update the stopwatch using a method we’ll create called runTimer().
// The runTimer() method will run code every second to check whether the stopwatch is running,
// and, if it is, increment the number of seconds and display the number of seconds in the text view.
public class StopwatchActivity extends Activity {
//    Use the seconds and running variables to record the number of seconds passed and whether the stopwatch is running
    private int seconds=0;
    private boolean running;
    private boolean wasRunning; //Record the running state before activity being destroyed

//    The onCreate() method gets called immediately after your activity is launched.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
//        Retrieve the values of the seconds and running variables from the Bundle.
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
        }
        //在界面上点击start操作之前，runTimer()已经在运行
        runTimer();
    }

    //Start the stopwatch running when the Start button is clicked.
    public void onClickStart(View view) {
        running = true;
    }

    //Stop the stopwatch running when the Stop button is clicked.
    public void onClickStop(View view) {
        running = false;
    }

    //Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    //Sets the number of seconds on the timer.
    private void runTimer() {
    final TextView timeView = (TextView)findViewById(R.id.time_view);
    final Handler handler = new Handler();
    handler.post(new Runnable() {
        @Override
        public void run() {
            int hours = seconds / 3600;
            int minutes = (seconds % 3600) / 60;
            int secs = seconds % 60;
            String time = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, secs);
            timeView.setText(time);
            if (running) {
                seconds++;
            }
            handler.postDelayed(this, 1000);
        }
    });
    }

//    When Android runs your app and starts an activity, it takes into account the device configuration.
// By this we mean the configuration of the physical device (such as the screen size, screen orientation,
// and whether there’s a keyboard attached) and also configuration options specified by the user (such as the locale).
//A change to any of these options results in the activity being destroyed and then recreated.

//    To save the activity’s current state, you need to implement the onSaveInstanceState() method.
// This method gets called before the activity gets destroyed, which means you get an opportunity to save any values you want to retain before they get lost.
//The onSaveInstanceState() method takes one parameter, a Bundle. A Bundle allows you to gather together different types of data into a single object:
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning",wasRunning);
    }

    @Override
    protected void onStop(){
        //This calls the onStop() method in the activity’s superclass, android.app.Activity.
        super.onStop();
//      Save the running status before onStop（the running status is set to false）
        wasRunning=running;
//        So now the stopwatch stops when the activity is no longer visible.
        running=false;
    }

    @Override
    protected void onStart(){
        super.onStart();
        //恢复stop之前的运行状态
        if(wasRunning){
            running=true;
        }
    }
}


