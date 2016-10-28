package eu.dubedout.vincent.viewpagerindicatorslibraries.components.devlightnavigationtabstripactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gigamole.navigationtabstrip.NavigationTabStrip;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.DemoPagerAdapter;
import eu.dubedout.vincent.viewpagerindicatorslibraries.GenericData;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;

public class DevLightNavigationTabStripActivity extends AppCompatActivity {

    @BindView(R.id.activity_rubber_indicator_indicator_default) NavigationTabStrip indicatorDefault;
    @BindView(R.id.activity_rubber_indicator_viewpager_default) ViewPager viewpagerDefault;
    @BindView(R.id.activity_rubber_indicator_indicator_point) NavigationTabStrip indicatorPoint;
    @BindView(R.id.activity_rubber_indicator_viewpager_point) ViewPager viewpagerPoint;
    @BindView(R.id.activity_rubber_indicator_indicator_themed) NavigationTabStrip indicatorThemed;
    @BindView(R.id.activity_rubber_indicator_viewpager_themed) ViewPager viewpagerThemed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_light_navigation_tab_strip);
        ButterKnife.bind(this);

        ViewPager.OnPageChangeListener pagerSynchronizer = getPagerSynchronizer();

        DemoPagerAdapter adapterDefault = getAdapter();
        viewpagerDefault.setAdapter(adapterDefault);
        viewpagerDefault.addOnPageChangeListener(pagerSynchronizer);
        indicatorDefault.setTitles(getTitles(adapterDefault));
        indicatorDefault.setTabIndex(0);
        indicatorDefault.setViewPager(viewpagerDefault);

        DemoPagerAdapter adapterPoint = getAdapter();
        viewpagerPoint.setAdapter(adapterPoint);
        viewpagerPoint.addOnPageChangeListener(pagerSynchronizer);
        indicatorPoint.setTitles(getTitles(adapterPoint));
        indicatorPoint.setTabIndex(0);
        indicatorPoint.setViewPager(viewpagerPoint);

        DemoPagerAdapter adapterThemed = getAdapter();
        viewpagerThemed.setAdapter(adapterThemed);
        viewpagerThemed.addOnPageChangeListener(pagerSynchronizer);
        indicatorThemed.setTitles(getTitles(adapterThemed));
        indicatorThemed.setTabIndex(0);
        indicatorThemed.setViewPager(viewpagerThemed);

    }

    private String[] getTitles(DemoPagerAdapter adapter) {
        int maxItems = adapter.getCount();
        String[] titles = new String[maxItems];

        for (int index = 0; index < maxItems; index++){
            titles[index] = String.valueOf(adapter.getPageTitle(index));
        }

        return titles;
    }

    private DemoPagerAdapter getAdapter() {
        return new DemoPagerAdapter(new GenericData(this).getContentWithTitle());
    }


    private ViewPager.OnPageChangeListener getPagerSynchronizer() {
        return new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                viewpagerDefault.setCurrentItem(position, true);
                viewpagerPoint.setCurrentItem(position, true);
                viewpagerThemed.setCurrentItem(position, true);
            }
        };
    }
}
