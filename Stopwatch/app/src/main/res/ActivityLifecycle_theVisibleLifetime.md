# The activity lifecycle: the visible lifetime
1. The activity gets launched, and the onCreate() method runs.
Any activity initialization code in the onCreate() method runs. At this point, the activity isn’t yet visible, as no call to onStart() has been made.

2. The onStart() method runs. It gets called when the activity is about to become visible.

3. The onStop() method runs when the activity stops being visible to the user.

4. If the activity becomes visible to the user again, the onRestart() method gets called followed by onStart().
The activity may go through this cycle many times if the activity repeatedly becomes invisible(onStop() gets called) and then visible(onStart()) again.

5. Finally, the activity is destroyed(onDestroy() gets called).
The onStop() method will get called before onDestroy().



# The activity lifecycle: the foreground lifetime

**What if an app is only partially visible?**

So far you’ve seen what happens when an activity gets created and destroyed,
and you’ve also seen what happens when an activity becomes visible, and when it becomes invisible.
But there’s one more situation we need to consider: when an activity is visible but doesn’t have the focus.
When an activity is visible but doesn’t have the focus, the activity is paused.

This can happen if another activity appears on top of your activity that isn’t full-size or that’s transparent.
The activity on top has the focus, but the one underneath is still visible and is therefore paused.

**An activity has a state of paused if it’s lost the focus but is still visible to the user.
The activity is still alive and maintains all its state information.**
There are two lifecycle methods that handle when the activity is paused and when it becomes active again: onPause() and onResume().
onPause() gets called when your activity is visible but another activity has the focus.
onResume() is called immediately before your activity is about to start interacting with the user.
1. **The activity gets launched, and the onCreate() and onStart() methods run.**
   At this point, the activity is visible, but it doesn’t have the focus.
2. **The onResume() method runs. It gets called when the activity is about to move into the foreground.**
   After the onResume() method has run, the activity has the focus and the user can interact with it.
3. **The onPause() method runs when the activity stops being in the foreground.**
   After the onPause() method has run, the activity is still visible but doesn’t have the focus.
4. **If the activity moves into the foreground again, the onResume() method gets called.**
   The activity may go through this cycle many times if the activity repeatedly loses and then regains the focus.
5. **If the activity stops being visible to the user, the onStop() method gets called.**
   After the onStop() method has run, the activity is no longer visible.
6. **If the activity becomes visible to the user again, the onRestart() method gets called, followed by onStart() and onResume().**
   The activity may go through this cycle many times.
7. **Finally, the activity is destroyed**
   As the activity moves from running to destroyed,the onPause() and onStop() methods get called before the activity is destroyed.

If you have an activity that’s visible, but never in the foreground and never has the focus, the onPause() and onResume() methods never get called.
If an activity stops or gets destroyed before it appears in the foreground, the onStart() method is followed by the onStop() method. onResume() and onPause() are bypassed.