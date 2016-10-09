package eu.dubedout.vincent.viewpagerindicatorslibraries;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class DemoPagerAdapter extends PagerAdapter {
    private final List<PageData> list;

    public DemoPagerAdapter(List<PageData> list) {
        this.list = list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_pager_demo, container, false);
        ((TextView) view.findViewById(R.id.item_pager_demo_main_text)).setText(list.get(position).data);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).title;
    }
}
