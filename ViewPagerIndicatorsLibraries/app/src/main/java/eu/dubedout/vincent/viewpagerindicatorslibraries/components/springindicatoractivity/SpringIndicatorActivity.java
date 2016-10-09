package eu.dubedout.vincent.viewpagerindicatorslibraries.components.springindicatoractivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.DemoPagerAdapter;
import eu.dubedout.vincent.viewpagerindicatorslibraries.GenericData;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;
import github.chenupt.springindicator.SpringIndicator;

public class SpringIndicatorActivity extends AppCompatActivity {

    @BindView(R.id.activity_spring_indicator_indicator_default) SpringIndicator indicatorDefault;
    @BindView(R.id.activity_spring_indicator_viewpager_default) ViewPager viewpagerDefault;
    @BindView(R.id.activity_spring_indicator_indicator_themed) SpringIndicator indicatorThemed;
    @BindView(R.id.activity_spring_indicator_viewpager_themed) ViewPager viewpagerThemed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_indicator);
        ButterKnife.bind(this);

        ViewPager.SimpleOnPageChangeListener synchronizer = getSynchronizer();

        viewpagerDefault.setAdapter(getAdapter());
        viewpagerDefault.addOnPageChangeListener(synchronizer);
        indicatorDefault.setViewPager(viewpagerDefault);

        viewpagerThemed.setAdapter(getAdapter());
        viewpagerThemed.addOnPageChangeListener(synchronizer);
        indicatorThemed.setViewPager(viewpagerThemed);
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
        return new DemoPagerAdapter(new GenericData(this).getContent());
    }
}
