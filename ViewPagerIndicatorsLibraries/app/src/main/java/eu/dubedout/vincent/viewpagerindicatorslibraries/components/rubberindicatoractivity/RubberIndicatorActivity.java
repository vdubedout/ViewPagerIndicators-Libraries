package eu.dubedout.vincent.viewpagerindicatorslibraries.components.rubberindicatoractivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.liangfeizc.RubberIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.DemoPagerAdapter;
import eu.dubedout.vincent.viewpagerindicatorslibraries.GenericData;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;

import static android.os.Build.VERSION_CODES.M;

public class RubberIndicatorActivity extends AppCompatActivity {

    @BindView(R.id.activity_rubber_indicator_indicator_default) RubberIndicator indicatorDefault;
    @BindView(R.id.activity_rubber_indicator_viewpager_default) ViewPager viewpagerDefault;
    @BindView(R.id.activity_rubber_indicator_indicator_themed) RubberIndicator indicatorThemed;
    @BindView(R.id.activity_rubber_indicator_viewpager_themed) ViewPager viewpagerThemed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rubber_indicator);
        ButterKnife.bind(this);

        DemoPagerAdapter adapter = getAdapter();
        indicatorDefault.setCount(adapter.getCount());
        viewpagerDefault.setAdapter(adapter);
        viewpagerDefault.addOnPageChangeListener(new OnRubberPageChangeListener(indicatorDefault));

        DemoPagerAdapter adapterThemed = getAdapter();
        indicatorThemed.setCount(adapter.getCount());
        viewpagerThemed.setAdapter(adapterThemed);
        viewpagerThemed.addOnPageChangeListener(new OnRubberPageChangeListener(indicatorThemed));
    }

    private DemoPagerAdapter getAdapter(){
        return new DemoPagerAdapter(new GenericData(this).getContentWithoutTitle());
    }

    private class OnRubberPageChangeListener implements ViewPager.OnPageChangeListener {

        private final RubberIndicator indicator;

        public OnRubberPageChangeListener(RubberIndicator indicator) {
            this.indicator = indicator;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            int focusPosition = this.indicator.getFocusPosition();
            if (position > focusPosition){
                this.indicator.moveToRight();
            } else if (position < focusPosition){
                this.indicator.moveToLeft();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
