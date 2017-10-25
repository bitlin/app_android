package bitlin.example.android.bits_pizzas;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
//      Set the toolbar as the activity's app bar
        setSupportActionBar(toolbar);

//        This returns an object of type ActionBar.
        ActionBar actionBar=getSupportActionBar();
//        This enables the Up button.
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
}
