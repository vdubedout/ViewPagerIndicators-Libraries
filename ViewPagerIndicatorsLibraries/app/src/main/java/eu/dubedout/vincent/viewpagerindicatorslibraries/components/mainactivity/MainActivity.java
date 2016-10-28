package eu.dubedout.vincent.viewpagerindicatorslibraries.components.mainactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.Navigator;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;
import eu.dubedout.vincent.viewpagerindicatorslibraries.components.devlightnavigationtabstripactivity.DevLightNavigationTabStripActivity;
import eu.dubedout.vincent.viewpagerindicatorslibraries.components.inkpagerindicatoractivity.InkPageIndicatorActivity;
import eu.dubedout.vincent.viewpagerindicatorslibraries.components.pageindicatorviewdanylykactivity.PageIndicatorViewDanylykActivity;
import eu.dubedout.vincent.viewpagerindicatorslibraries.components.pagerslidingtabstripactivity.PagerSlidingTabStripActivity;
import eu.dubedout.vincent.viewpagerindicatorslibraries.components.rubberindicatoractivity.RubberIndicatorActivity;
import eu.dubedout.vincent.viewpagerindicatorslibraries.components.springindicatoractivity.SpringIndicatorActivity;
import eu.dubedout.vincent.viewpagerindicatorslibraries.components.stepperindicatoractivity.StepperIndicatorActivity;
import eu.dubedout.vincent.viewpagerindicatorslibraries.components.viewpagerindicatoractivity.ViewPagerIndicatorActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_viewpagerindicators_list) RecyclerView listView;

    private Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigator = new Navigator(this);

        initializeViews();
    }

    private void initializeViews() {
        listView.setAdapter(getAdapter());
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setHasFixedSize(true);
    }

    @NonNull
    private ViewPagerIndicatorSummaryAdapter getAdapter() {
        ViewPagerIndicatorSummaryAdapter adapter = new ViewPagerIndicatorSummaryAdapter(getLibrarySummaryList());
        adapter.setOnClickListener(summary -> navigator.launch(summary.linkedActivity()));
        return adapter;
    }

    /***
     * Evolve using
     * data : https://api.github.com/repos/JakeWharton/ViewPagerIndicator
     * last commit: https://api.github.com/repos/JakeWharton/ViewPagerIndicator/commits
     */
    private List<ViewPagerIndicatorSummary> getLibrarySummaryList() {
        List<ViewPagerIndicatorSummary> list = new ArrayList<>();
        list.add(ViewPagerIndicatorSummary.builder()
                .setLibraryName("ViewPagerIndicator")
                .setStarNumber(8148)
                .setActiveIssues(127)
                .setActivePullRequests(80)
                .setLastUpdate("09/2012")
                .setLinkedActivity(ViewPagerIndicatorActivity.class)
                .build());

        list.add(ViewPagerIndicatorSummary.builder()
                .setLibraryName("PagerSlidingTabStrip")
                .setStarNumber(5500)
                .setActiveIssues(153)
                .setActivePullRequests(53)
                .setLastUpdate("12/2013")
                .setLinkedActivity(PagerSlidingTabStripActivity.class)
                .build());

        list.add(ViewPagerIndicatorSummary.builder()
                .setLibraryName("SpringIndicator")
                .setStarNumber(1650)
                .setActiveIssues(15)
                .setActivePullRequests(3)
                .setLastUpdate("06/2016")
                .setLinkedActivity(SpringIndicatorActivity.class)
                .build());

        list.add(ViewPagerIndicatorSummary.builder()
                .setLibraryName("RubberIndicator")
                .setStarNumber(1316)
                .setActiveIssues(6)
                .setActivePullRequests(1)
                .setLastUpdate("11/2015")
                .setLinkedActivity(RubberIndicatorActivity.class)
                .build());

        list.add(ViewPagerIndicatorSummary.builder()
                .setLibraryName("NavigationTabStrip (DevLight)")
                .setStarNumber(1122)
                .setActiveIssues(4)
                .setActivePullRequests(0)
                .setLastUpdate("09/2016")
                .setLinkedActivity(DevLightNavigationTabStripActivity.class)
                .build());

        list.add(ViewPagerIndicatorSummary.builder()
                .setLibraryName("Stepper Indicator")
                .setStarNumber(838)
                .setActiveIssues(6)
                .setActivePullRequests(2)
                .setLastUpdate("09/2016")
                .setLinkedActivity(StepperIndicatorActivity.class)
                .build());

        list.add(ViewPagerIndicatorSummary.builder()
                .setLibraryName("PagerIndicatorView Danylyk")
                .setStarNumber(1017)
                .setActiveIssues(0)
                .setActivePullRequests(0)
                .setLastUpdate("10/2016")
                .setLinkedActivity(PageIndicatorViewDanylykActivity.class)
                .build());

        list.add(ViewPagerIndicatorSummary.builder()
                .setLibraryName("Ink Page Indicator")
                .setStarNumber(211)
                .setActiveIssues(9)
                .setActivePullRequests(1)
                .setLastUpdate("08/2016")
                .setLinkedActivity(InkPageIndicatorActivity.class)
                .build());

        return list;
    }
}
