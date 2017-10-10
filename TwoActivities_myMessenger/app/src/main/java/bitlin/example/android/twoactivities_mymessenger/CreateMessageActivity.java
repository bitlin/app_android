package bitlin.example.android.twoactivities_mymessenger;

import android.app.Activity;
import android.content.Intent;
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
        startActivity(intent);
    }
}
