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
    public void onSendMessge(View view){
        EditText messageView=(EditText)findViewById(R.id.message);
        String messageText=messageView.getText().toString();
//  Whenever you want an activity to start a second activity, you use an intent. You can think of an intent as an “intent to do something.”
//  It’s a type of message that allows you to bind separate objects (such as activities) together at runtime.
//  If one activity wants to start a second activity, it does it by sending an intent to Android.
//  Android will then start the second activity and pass it the intent.
        Intent intent=new Intent(this, ReceiveMessageActivity.class);
//   We’ll get CreateMessageActivity to pass text to ReceiveMessageActivity so that ReceiveMessageActivity can display it.
//   You can add extra information to this intent that can be picked up by the activity you’re targeting so it can react in some way.
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE,messageText);
        startActivity(intent);

//
    }
}
