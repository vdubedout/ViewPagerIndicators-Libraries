package eu.dubedout.vincent.viewpagerindicatorslibraries.components.viewpagerindicatoractivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.IconPageIndicator;
import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitlePageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.DemoPagerAdapter;
import eu.dubedout.vincent.viewpagerindicatorslibraries.GenericData;
import eu.dubedout.vincent.viewpagerindicatorslibraries.PageData;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;

public class ViewPagerIndicatorActivity extends AppCompatActivity {

    @BindView(R.id.activity_view_pager_indicator_container) LinearLayout container;
    @BindView(R.id.activity_view_pager_indicator_title) TitlePageIndicator indicatorTitle;
    @BindView(R.id.activity_view_pager_indicator_viewpager_title) ViewPager viewpagerTitle;

    @BindView(R.id.activity_view_pager_indicator_tab) TabPageIndicator indicatorTab;
    @BindView(R.id.activity_view_pager_indicator_viewpager_tab) ViewPager viewpagerTab;

    @BindView(R.id.activity_view_pager_indicator_line) LinePageIndicator indicatorLine;
    @BindView(R.id.activity_view_pager_indicator_viewpager_line) ViewPager viewpagerLine;

    @BindView(R.id.activity_view_pager_indicator_underline) UnderlinePageIndicator indicatorUnderline;
    @BindView(R.id.activity_view_pager_indicator_viewpager_underline) ViewPager viewpagerUnderline;

    @BindView(R.id.activity_view_pager_indicator_circle) CirclePageIndicator indicatorCircle;
    @BindView(R.id.activity_view_pager_indicator_viewpager_circle) ViewPager viewpagerCircle;

    @BindView(R.id.activity_view_pager_indicator_icon) IconPageIndicator indicatorIcon;
    @BindView(R.id.activity_view_pager_indicator_viewpager_icon) ViewPager viewpagerIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_indicator);
        ButterKnife.bind(this);

        ViewPager.SimpleOnPageChangeListener pagerSyncronizer = getPagerSynchronizer();

        viewpagerTitle.setAdapter(getAdapter());
        indicatorTitle.setViewPager(viewpagerTitle);
        indicatorTitle.setOnPageChangeListener(pagerSyncronizer);

        viewpagerTab.setAdapter(getAdapter());
        indicatorTab.setViewPager(viewpagerTab);
        indicatorTab.setOnPageChangeListener(pagerSyncronizer);

        viewpagerLine.setAdapter(getAdapter());
        indicatorLine.setViewPager(viewpagerLine);
        indicatorLine.setOnPageChangeListener(pagerSyncronizer);

        viewpagerUnderline.setAdapter(getAdapter());
        indicatorUnderline.setViewPager(viewpagerUnderline);
        indicatorUnderline.setOnPageChangeListener(pagerSyncronizer);

        viewpagerCircle.setAdapter(getAdapter());
        indicatorCircle.setViewPager(viewpagerCircle);
        indicatorCircle.setOnPageChangeListener(pagerSyncronizer);

        viewpagerIcon.setAdapter(getIconAdapter());
        indicatorIcon.setViewPager(viewpagerIcon);
        indicatorIcon.setOnPageChangeListener(pagerSyncronizer);
    }

    @NonNull
    private DemoPagerAdapter getAdapter() {
        return new DemoPagerAdapter(new GenericData(this).getContentWithTitle());
    }

    private PagerAdapter getIconAdapter() {
        return new DemoIconPagerAdapter(new GenericData(this).getContentWithTitle());
    }

    private ViewPager.SimpleOnPageChangeListener getPagerSynchronizer() {
        return new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                viewpagerTitle.setCurrentItem(position, true);
                viewpagerTab.setCurrentItem(position, true);
                viewpagerLine.setCurrentItem(position, true);
                viewpagerUnderline.setCurrentItem(position, true);
                viewpagerCircle.setCurrentItem(position, true);
                viewpagerIcon.setCurrentItem(position, true);
            }
        };
    }

    class DemoIconPagerAdapter extends DemoPagerAdapter implements IconPagerAdapter {
        public DemoIconPagerAdapter(List<PageData> list) {
            super(list);
        }

        int[] icons = new int[]{R.drawable.brightness_1, R.drawable.brightness_3, R.drawable.brightness_4, R.drawable.brightness_5};

        @Override
        public int getIconResId(int index) {
            return icons[index % getCount()];
        }
    }


}
