package bitlin.example.android.bits_pizzas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


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

//    Implementing this method adds any items in the menu resource file to the app bar.
//  This means that it creates a Menu object that’s a Java representation of your menu resource file,
// and any actions the menu resource file contains are translated to MenuItems. These are then added to the app bar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the app bar.
//        R.menu.menu_main is the menu resource file; menu is a Menu object that’s a Java representation of the menu resource file.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    The onOptionsItemSelected() method runs whenever an action gets clicked.
//    It takes one parameter, a MenuItem object that represents the action on the app bar that was clicked.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        You can use the MenuItem’s getItemId() method to get the ID of the action so that you can perform an appropriate action, such as starting a new activity.
        switch (item.getItemId()) {
            case R.id.action_create_order:
                //Code to run when the Create Order item is clicked
                Intent intent = new Intent(this, OrderActivity.class); startActivity(intent);
                //Returning true tells Android you've dealt with the item being clicked
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
