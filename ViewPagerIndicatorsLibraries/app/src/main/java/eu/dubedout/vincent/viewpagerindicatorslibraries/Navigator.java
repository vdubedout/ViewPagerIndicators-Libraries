package eu.dubedout.vincent.viewpagerindicatorslibraries;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;

import eu.dubedout.vincent.viewpagerindicatorslibraries.components.viewpagerindicatoractivity.ViewPagerIndicatorActivity;

public class Navigator {
    private final Activity activity;

    public Navigator(Activity activity) {
        this.activity = activity;
    }


    public void launch(Class clazz){
        Intent intent = new Intent(activity, clazz);
        ActivityCompat.startActivity(activity, intent, null);
    }
}
