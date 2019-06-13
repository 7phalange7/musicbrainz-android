package org.metabrainz.mobile.presentation.features.collection;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EntityViewHolder extends RecyclerView.ViewHolder {
    public View itemView;

    public EntityViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
    }
}
