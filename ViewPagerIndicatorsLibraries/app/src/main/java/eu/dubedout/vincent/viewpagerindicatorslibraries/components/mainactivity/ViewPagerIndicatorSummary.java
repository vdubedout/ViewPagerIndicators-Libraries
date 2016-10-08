package eu.dubedout.vincent.viewpagerindicatorslibraries.components.mainactivity;

import com.google.auto.value.AutoValue;

import eu.dubedout.vincent.viewpagerindicatorslibraries.architecture.OnClickListener;

@AutoValue
public abstract class ViewPagerIndicatorSummary {
    public abstract int starNumber();
    public abstract String libraryName();
    public abstract String lastUpdate();
    public abstract int activeIssues();
    public abstract int activePullRequests();
    public abstract Class linkedActivity();

    public static Builder builder() {
        return new AutoValue_ViewPagerIndicatorSummary.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        public abstract Builder setStarNumber(int starNumber);
        public abstract Builder setLibraryName(String libraryName);
        public abstract Builder setLastUpdate(String lastUpdate);
        public abstract Builder setActiveIssues(int activeIssues);
        public abstract Builder setActivePullRequests(int activePullRequests);
        public abstract Builder setLinkedActivity(Class linkedActivity);

        public abstract ViewPagerIndicatorSummary build();
    }
}
