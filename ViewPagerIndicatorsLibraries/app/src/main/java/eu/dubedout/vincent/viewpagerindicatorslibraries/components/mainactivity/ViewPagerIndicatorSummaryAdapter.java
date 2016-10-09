package eu.dubedout.vincent.viewpagerindicatorslibraries.components.mainactivity;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.dubedout.vincent.viewpagerindicatorslibraries.R;
import eu.dubedout.vincent.viewpagerindicatorslibraries.architecture.OnObjectClick;

import static android.R.attr.onClick;

public class ViewPagerIndicatorSummaryAdapter extends RecyclerView.Adapter<ViewPagerIndicatorSummaryAdapter.ViewHolder> {
    private OnObjectClick<ViewPagerIndicatorSummary> onClickListener;

    interface OnPositionClick{
        void onClick(int position);
    }

    private final List<ViewPagerIndicatorSummary> list;

    public ViewPagerIndicatorSummaryAdapter(List<ViewPagerIndicatorSummary> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_indicators_summary, parent, false);
        return new ViewHolder(view, position -> onClickListener.onClick(list.get(position)));
    }

    public void setOnClickListener(OnObjectClick<ViewPagerIndicatorSummary> onClickListener){
        this.onClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewPagerIndicatorSummary summary = list.get(position);
        Resources res = holder.starNumberView.getContext().getResources();

        holder.starNumberView.setText(String.valueOf(summary.starNumber()));
        holder.libraryNameView.setText(summary.libraryName());
        holder.lastUpdateView.setText(res.getString(R.string.summary_adapter_last_update, summary.lastUpdate()));
        holder.activeIssuesView.setText(res.getString(R.string.summary_adapter_active_issues, summary.activeIssues()));
        holder.pullRequestsView.setText(res.getString(R.string.summary_adapter_active_pull_requests, summary.activePullRequests()));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_indicators_summary_star_number) TextView starNumberView;
        @BindView(R.id.item_indicators_summary_library_name) TextView libraryNameView;
        @BindView(R.id.item_indicators_summary_last_update) TextView lastUpdateView;
        @BindView(R.id.item_indicators_summary_active_issues) TextView activeIssuesView;
        @BindView(R.id.item_indicators_summary_pull_requests) TextView pullRequestsView;


        public ViewHolder(View itemView, OnPositionClick onPositionClick) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> onPositionClick.onClick(getLayoutPosition()));
        }
    }
}
