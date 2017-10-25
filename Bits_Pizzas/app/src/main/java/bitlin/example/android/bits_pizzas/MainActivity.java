package bitlin.example.android.bits_pizzas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


//The AppCompatActivity class is a subclass of Activity. It lives in the AppCompat Support Library, and it’s designed to work with the AppCompat themes.
// Your activity needs to extend the AppCompatActivity class instead of the Activity class whenever you want an app bar that provides backward compatibility with older versions of Android.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
