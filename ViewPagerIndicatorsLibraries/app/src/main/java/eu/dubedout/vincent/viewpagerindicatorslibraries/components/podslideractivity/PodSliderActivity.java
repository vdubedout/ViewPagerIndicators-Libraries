package eu.dubedout.vincent.viewpagerindicatorslibraries.components.podslideractivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bhargavms.podslider.PodSlider;
import com.rd.PageIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.DemoPagerAdapter;
import eu.dubedout.vincent.viewpagerindicatorslibraries.GenericData;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;

public class PodSliderActivity extends AppCompatActivity {

    @BindView(R.id.activity_pod_slider_indicator_default) PodSlider indicatorDefault;
    @BindView(R.id.activity_pod_slider_pager_default) ViewPager pagerDefault;
    @BindView(R.id.activity_pod_slider_indicator_themed) PodSlider indicatorThemed;
    @BindView(R.id.activity_pod_slider_pager_themed) ViewPager pagerThemed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pod_slider);
        ButterKnife.bind(this);

        ViewPager.OnPageChangeListener pagerSynchronizer = getPagerSynchronizer();

        setViewPager(pagerDefault, indicatorDefault, pagerSynchronizer);
        setViewPager(pagerThemed, indicatorThemed, pagerSynchronizer);
    }

    private void setViewPager(ViewPager pager, PodSlider indicator, ViewPager.OnPageChangeListener pagerSynchronizer) {
        pager.setAdapter(getAdapter());
        pager.addOnPageChangeListener(pagerSynchronizer);
        indicator.setUpWithViewPager(pager);
    }

    public DemoPagerAdapter getAdapter() {
        return new DemoPagerAdapter(new GenericData(this).getContentWithOneLetterTitle());
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
