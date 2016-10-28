package eu.dubedout.vincent.viewpagerindicatorslibraries.components.pageindicatorviewdanylykactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.rd.PageIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.DemoPagerAdapter;
import eu.dubedout.vincent.viewpagerindicatorslibraries.GenericData;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;

public class PageIndicatorViewDanylykActivity extends AppCompatActivity {

    @BindView(R.id.activity_page_indicator_view_danylyk_indicator_default) PageIndicatorView indicatorDefault;
    @BindView(R.id.activity_page_indicator_view_danylyk_pager_default) ViewPager pagerDefault;
    @BindView(R.id.activity_page_indicator_view_danylyk_indicator_color) PageIndicatorView indicatorColor;
    @BindView(R.id.activity_page_indicator_view_danylyk_pager_color) ViewPager pagerColor;
    @BindView(R.id.activity_page_indicator_view_danylyk_indicator_scale) PageIndicatorView indicatorScale;
    @BindView(R.id.activity_page_indicator_view_danylyk_pager_scale) ViewPager pagerScale;
    @BindView(R.id.activity_page_indicator_view_danylyk_indicator_slide) PageIndicatorView indicatorSlide;
    @BindView(R.id.activity_page_indicator_view_danylyk_pager_slide) ViewPager pagerSlide;
    @BindView(R.id.activity_page_indicator_view_danylyk_indicator_worm) PageIndicatorView indicatorWorm;
    @BindView(R.id.activity_page_indicator_view_danylyk_pager_worm) ViewPager pagerWorm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_indicator_view_danylyk);
        ButterKnife.bind(this);

        ViewPager.OnPageChangeListener pagerSynchronizer = getPagerSynchronizer();

        setViewPager(pagerDefault, indicatorDefault, pagerSynchronizer);
        setViewPager(pagerColor, indicatorColor, pagerSynchronizer);
        setViewPager(pagerScale, indicatorScale, pagerSynchronizer);
        setViewPager(pagerSlide, indicatorSlide, pagerSynchronizer);
        setViewPager(pagerWorm, indicatorWorm, pagerSynchronizer);
    }

    private void setViewPager(ViewPager pager, PageIndicatorView indicator, ViewPager.OnPageChangeListener pagerSynchronizer) {
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
                pagerColor.setCurrentItem(position, true);
                pagerScale.setCurrentItem(position, true);
                pagerSlide.setCurrentItem(position, true);
                pagerWorm.setCurrentItem(position, true);
            }
        };
    }
}
