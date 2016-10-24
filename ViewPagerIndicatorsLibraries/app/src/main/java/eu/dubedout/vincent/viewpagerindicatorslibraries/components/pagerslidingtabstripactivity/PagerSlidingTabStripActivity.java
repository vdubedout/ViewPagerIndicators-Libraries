package eu.dubedout.vincent.viewpagerindicatorslibraries.components.pagerslidingtabstripactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.DemoPagerAdapter;
import eu.dubedout.vincent.viewpagerindicatorslibraries.GenericData;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;

public class PagerSlidingTabStripActivity extends AppCompatActivity {
    @BindView(R.id.activity_pager_sliding_tab_strip_indicator_default) PagerSlidingTabStrip indicatorDefault;
    @BindView(R.id.activity_pager_sliding_tab_strip_viewpager_default) ViewPager viewpagerDefault;
    @BindView(R.id.activity_pager_sliding_tab_strip_indicator_themed) PagerSlidingTabStrip indicatorThemed;
    @BindView(R.id.activity_pager_sliding_tab_strip_viewpager_themed) ViewPager viewpagerThemed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_sliding_tab_strip);
        ButterKnife.bind(this);

        ViewPager.SimpleOnPageChangeListener pagerSynchronizer = getSynchronizer();

        viewpagerDefault.setAdapter(getAdapter());
        indicatorDefault.setViewPager(viewpagerDefault);
        indicatorDefault.setOnPageChangeListener(pagerSynchronizer);

        viewpagerThemed.setAdapter(getAdapter());
        indicatorThemed.setViewPager(viewpagerThemed);
        indicatorThemed.setOnPageChangeListener(pagerSynchronizer);
    }

    @NonNull
    private ViewPager.SimpleOnPageChangeListener getSynchronizer() {
        return new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                viewpagerDefault.setCurrentItem(position, true);
                viewpagerThemed.setCurrentItem(position, true);
            }
        };
    }

    @NonNull
    private DemoPagerAdapter getAdapter() {
        return new DemoPagerAdapter(new GenericData(this).getContentWithTitle());
    }
}
