package eu.dubedout.vincent.viewpagerindicatorslibraries.components.inkpagerindicatoractivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.pixelcan.inkpageindicator.InkPageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.DemoPagerAdapter;
import eu.dubedout.vincent.viewpagerindicatorslibraries.GenericData;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;

public class InkPageIndicatorActivity extends AppCompatActivity {

    @BindView(R.id.activity_ink_page_indicator_indicator_default) InkPageIndicator indicatorDefault;
    @BindView(R.id.activity_ink_page_indicator_pager_default) ViewPager pagerDefault;
    @BindView(R.id.activity_ink_page_indicator_indicator_themed) InkPageIndicator indicatorThemed;
    @BindView(R.id.activity_ink_page_indicator_pager_themed) ViewPager pagerThemed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ink_page_indicator);
        ButterKnife.bind(this);

        ViewPager.OnPageChangeListener pagerSynchronizer = getPagerSynchronizer();
        setViewPager(pagerDefault, indicatorDefault, pagerSynchronizer);
        setViewPager(pagerThemed, indicatorThemed, pagerSynchronizer);
    }

    private void setViewPager(ViewPager pager, InkPageIndicator indicator, ViewPager.OnPageChangeListener pagerSynchronizer) {
        pager.setAdapter(getAdapter());
        pager.addOnPageChangeListener(pagerSynchronizer);
        indicator.setViewPager(pager);
    }

    public DemoPagerAdapter getAdapter() {
        return new DemoPagerAdapter(new GenericData(this).getContentWithoutTitle());
    }

    private ViewPager.OnPageChangeListener getPagerSynchronizer() {
        return new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                pagerDefault.setCurrentItem(position, true);
                pagerThemed.setCurrentItem(position, true);
            }
        };
    }
}
