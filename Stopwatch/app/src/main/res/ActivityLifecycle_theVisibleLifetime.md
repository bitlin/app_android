# The activity lifecycle: the visible lifetime
1. The activity gets launched, and the onCreate() method runs.
Any activity initialization code in the onCreate() method runs. At this point, the activity isn’t yet visible, as no call to onStart() has been made.

2. The onStart() method runs. It gets called when the activity is about to become visible.

3. The onStop() method runs when the activity stops being visible to the user.

4. If the activity becomes visible to the user again, the onRestart() method gets called followed by onStart().
The activity may go through this cycle many times if the activity repeatedly becomes invisible(onStop() gets called) and then visible(onStart()) again.

5. Finally, the activity is destroyed(onDestroy() gets called).
The onStop() method will get called before onDestroy().
