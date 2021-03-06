package eu.dubedout.vincent.viewpagerindicatorslibraries;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class GenericData {
    private final Context context;

    public GenericData(Context context) {
        this.context = context;
    }

    public List<PageData> getContentWithTitle(){
        ArrayList<PageData> content = new ArrayList<>();
        content.add(new PageData("Page 1", context.getString(R.string.pager_content_swipe_left)));
        content.add(new PageData("Page 2", context.getString(R.string.pager_content_swipe_left_or_right)));
        content.add(new PageData("Page 3", context.getString(R.string.pager_content_swipe_left_or_right)));
        content.add(new PageData("Page 4", context.getString(R.string.pager_content_swipe_right)));
        return content;
    }

    public List<PageData> getContentWithoutTitle(){
        ArrayList<PageData> content = new ArrayList<>();
        content.add(new PageData("", context.getString(R.string.pager_content_swipe_left)));
        content.add(new PageData("", context.getString(R.string.pager_content_swipe_left_or_right)));
        content.add(new PageData("", context.getString(R.string.pager_content_swipe_left_or_right)));
        content.add(new PageData("", context.getString(R.string.pager_content_swipe_right)));
        return content;
    }

    public List<PageData> getContentWithOneLetterTitle(){
        ArrayList<PageData> content = new ArrayList<>();
        content.add(new PageData("1", context.getString(R.string.pager_content_swipe_left)));
        content.add(new PageData("2", context.getString(R.string.pager_content_swipe_left_or_right)));
        content.add(new PageData("3", context.getString(R.string.pager_content_swipe_left_or_right)));
        content.add(new PageData("4", context.getString(R.string.pager_content_swipe_right)));
        return content;
    }
}
