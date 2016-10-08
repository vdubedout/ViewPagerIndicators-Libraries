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
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setHasFixedSize(true);
        listView.setAdapter(getAdapter());
    }

    @NonNull
    private ViewPagerIndicatorSummaryAdapter getAdapter() {
        ViewPagerIndicatorSummaryAdapter adapter = new ViewPagerIndicatorSummaryAdapter(
                getLibrarySummaryList()
        );
        adapter.setOnClickListener(clazz -> navigator.launch(clazz));
    }

    /***
     * Evolve using
     * data : https://api.github.com/repos/JakeWharton/ViewPagerIndicator
     * last commit: https://api.github.com/repos/JakeWharton/ViewPagerIndicator/commits
     * @return
     */
    private List<ViewPagerIndicatorSummary> getLibrarySummaryList() {
        List<ViewPagerIndicatorSummary> list = new ArrayList<>();
        list.add(ViewPagerIndicatorSummary.builder()
                .setLibraryName("ViewPagerIndicator")
                .setStarNumber(8148)
                .setActiveIssues(127)
                .setActivePullRequests(80)
                .setLastUpdate("4 years")
                .setLinkedActivity(ViewPagerIndicatorActivity.class)
                .build());

        return null;
    }
}
