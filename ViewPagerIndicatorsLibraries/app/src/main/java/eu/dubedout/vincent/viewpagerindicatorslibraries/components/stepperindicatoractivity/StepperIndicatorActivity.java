package eu.dubedout.vincent.viewpagerindicatorslibraries.components.stepperindicatoractivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.badoualy.stepperindicator.StepperIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.DemoPagerAdapter;
import eu.dubedout.vincent.viewpagerindicatorslibraries.GenericData;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;

public class StepperIndicatorActivity extends AppCompatActivity {

    @BindView(R.id.activity_stepper_indicator_indicator_default) StepperIndicator indicatorDefault;
    @BindView(R.id.activity_stepper_indicator_pager_default) ViewPager pagerDefault;
    @BindView(R.id.activity_stepper_indicator_indicator_themed) StepperIndicator indicatorThemed;
    @BindView(R.id.activity_stepper_indicator_pager_themed) ViewPager pagerThemed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepper_indicator);
        ButterKnife.bind(this);

        ViewPager.OnPageChangeListener pagerSynchronizer = getPagerSynchronizer();

        DemoPagerAdapter adapter = getAdapter();
        pagerDefault.setAdapter(adapter);
        pagerDefault.addOnPageChangeListener(pagerSynchronizer);
        indicatorDefault.setViewPager(pagerDefault);

        pagerThemed.setAdapter(getAdapter());
        pagerThemed.addOnPageChangeListener(pagerSynchronizer);
        indicatorThemed.setViewPager(pagerThemed);

    }

    private DemoPagerAdapter getAdapter() {
        return new DemoPagerAdapter(new GenericData(this).getContentWithoutTitle());
    }

    private ViewPager.OnPageChangeListener getPagerSynchronizer() {
        return new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                pagerDefault.setCurrentItem(position, true);
                pagerThemed.setCurrentItem(position, true);
            }
        };
    }
}
