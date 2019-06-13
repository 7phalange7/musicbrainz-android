package org.metabrainz.mobile.presentation.features.collection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.metabrainz.mobile.R;
import org.metabrainz.mobile.data.sources.api.entities.mbentity.Event;

import java.util.List;

public class CollectionAdapterEvent extends CollectionAdapter {
    private List<Event> data;

    public CollectionAdapterEvent(List<Event> data) {
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EventViewHolder viewHolder = (EventViewHolder) holder;
        Event event = data.get(position);
        viewHolder.eventName.setText(event.getName());
        if (event.getLifeSpan() != null && event.getLifeSpan().getTimePeriod() != null)
            setViewVisibility(event.getLifeSpan().getTimePeriod(), viewHolder.eventTimePeriod);
        else viewHolder.eventTimePeriod.setVisibility(View.GONE);
        setViewVisibility(event.getType(), viewHolder.eventType);
        setViewVisibility(event.getDisambiguation(), viewHolder.eventDisambiguation);
        setAnimation(viewHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private static class EventViewHolder extends EntityViewHolder {
        TextView eventName, eventType, eventDisambiguation, eventTimePeriod;

        EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.event_name);
            eventTimePeriod = itemView.findViewById(R.id.event_time_period);
            eventDisambiguation = itemView.findViewById(R.id.event_disambiguation);
            eventType = itemView.findViewById(R.id.event_type);
        }

    }
}
