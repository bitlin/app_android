package bitlin.example.android.twoactivities_mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    //Call onSendMessage() when the button is clicked
    public void onSendMessage(View view){
        EditText messageView=(EditText)findViewById(R.id.message);
        String messageText=messageView.getText().toString();

//  Whenever you want an activity to start a second activity, you use an intent. You can think of an intent as an “intent to do something.”
//  It’s a type of message that allows you to bind separate objects (such as activities) together at runtime.
//  If one activity wants to start a second activity, it does it by sending an intent to Android.
//  Android will then start the second activity and pass it the intent.

//        This intent is an example of an explicit intent; you explicitly tell Android which class you want it to run.
//      Intent intent=new Intent(this, ReceiveMessageActivity.class);

//   We’ll get CreateMessageActivity to pass text to ReceiveMessageActivity so that ReceiveMessageActivity can display it.
//   You can add extra information to this intent that can be picked up by the activity you’re targeting so it can react in some way.
//      intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE,messageText);
//      startActivity(intent);


// If there’s an action you want done but you don’t care which activity does it, you create an implicit intent.
// You tell Android what sort of action you want it to perform, and you leave the details of which activity performs it to Android.

        //Instead of creating an intent that's explicitly for ReceiveMessageActivity, we're creating an intent that uses a send action
        Intent intent= new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,messageText);
//        startActivity(intent);

// You can create a chooser that asks users to pick an activity without giving them the option to always use that activity.
// You can achieve this using the Intent.createChooser() method, which takes the intent you’ve already created and wraps it in a chooser dialog.
// When you use this method, the user isn’t given the option of choosing a default activity—they get asked to choose one every time.

//        The getString() method is used to get the value of a String resource. It takes one parameter, the ID of the resource
        String chooserTitle=getString(R.string.chooser);
//        The method takes two parameters: an intent and an optional String title for the chooser dialog window.
//        The Intent parameter needs to describe the types of activity you want the chooser to display.
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);

//        This is a new explicit intent that’s targeted at the activity chosen by the user. It includes any extra information supplied by the original intent, including any text.
//        To start the activity the user chose, you need to call:
        startActivity(chosenIntent);

//        If no activities are found, Android still displays the chooser but shows a message telling the user there are no apps that can perform the action.


// Note: You can check whether any activities on the device are able to receive the intent by calling the intent’s resolveActivity() method and checking its return value.
// If its return value is null, no activities on the device are able to receive the intent, so you shouldn’t call startActivity().

    }
}