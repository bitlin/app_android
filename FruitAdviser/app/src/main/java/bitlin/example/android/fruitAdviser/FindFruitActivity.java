package bitlin.example.android.fruitAdviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;


/* Whenever you add a button to a layout, it’s likely you’ll want it to do something when the user clicks on it.
To make this happen, you need to get the button to call a method in your activity.*/


public class FindFruitActivity extends Activity {
    private FruitExpert expert=new FruitExpert();

    @Override
    //All activities also need to implement the onCreate() method. onCreate() method is called when the activity is first created
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Tells Android which layout the activity uses.
        setContentView(R.layout.activity_find_fruit);
    }

// If the method doesn’t take this form, then it won’t respond when the user presses the button.
// * Must be public
// * Must have a void return value
// * Must have a single parameter of type View
//    The parameter View refers to the GUI component that triggers the method (in this case, the button).
//    GUI components such as buttons and text views are all types of View.
    public void onClickFindFruit(View view){
//  we need to get our app to display a selection of different fruit that match the fruit type the user has selected.
//  In order to achieve this, we first need to get a reference to both the spinner and text view GUI components in the layout.
        TextView fruits=(TextView)findViewById(R.id.fruits); //Android uses R.java to keep track of the resources used within the app, and among other things it enables you to get references to GUI components from within your activity code.
        fruits.setText("no recommendation.");

        Spinner color=(Spinner)findViewById(R.id.color);
//  spinner values can be something other than Strings, such as images. In our case, we know the values are all Strings, so we can use String.valueOf() to convert the selected item from an Object to a String.
        String fruitType=String.valueOf(color.getSelectedItem());

//      get recommendations from fruitExpert class
        List<String> fruitList=expert.getFruits(fruitType.toLowerCase());

//  String对象是不可改变的。每次使用 System.String类中的方法之一时，都要在内存中创建一个新的字符串对象，这就需要为该新对象分配新的空间。
// 在需要对字符串执行重复修改的情况下，与创建新的 String对象相关的系统开销可能会非常昂贵。如果要修改字符串而不创建新的对象，则可以使用System.Text.StringBuilder类。
// 例如，当在一个循环中将许多字符串连接在一起时，使用 StringBuilder类可以提升性能。
        StringBuilder fruitsFormatted=new StringBuilder();
        for(String fruit:fruitList){
            fruitsFormatted.append(fruit).append('\n');
        }

        fruits.setText(fruitsFormatted);
    }
}
