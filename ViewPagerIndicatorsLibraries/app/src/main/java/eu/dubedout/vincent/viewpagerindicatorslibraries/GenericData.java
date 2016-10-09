package eu.dubedout.vincent.viewpagerindicatorslibraries;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class GenericData {
    private final Context context;

    public GenericData(Context context) {
        this.context = context;
    }

    public List<PageData> getContent(){
        ArrayList<PageData> content = new ArrayList<>();
        content.add(new PageData("Page 1", context.getString(R.string.pager_content_swipe_left)));
        content.add(new PageData("Page 2", context.getString(R.string.pager_content_swipe_left_or_right)));
        content.add(new PageData("Page 3", context.getString(R.string.pager_content_swipe_left_or_right)));
        content.add(new PageData("Page 4", context.getString(R.string.pager_content_swipe_right)));
        return content;
    }
}
