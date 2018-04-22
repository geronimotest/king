package com.geronimo.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.geronimo.view.Geronimo;
import com.geronimo.model.King;
import com.geronimo.R;
import com.geronimo.presenter.KingPresenterImpl;


import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Babacar Cisse on 01/03/2017.
 */

public class KingAdapter extends
        RecyclerView.Adapter<KingAdapter.ViewHolder> {

    private List<King> kingItems;
    private Context context;
    @Inject
    KingPresenterImpl kingPresenter;

    public KingAdapter(Context context, List<King> kingItems) {
        this.context = context;
        this.kingItems = kingItems;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View appView = inflater.inflate(R.layout.king_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(appView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final King kingItem = kingItems.get(position);
        holder.share.setTag(kingItem);
        holder.details.setTag(kingItem);
        TextView title = holder.title;
        TextView description = holder.description;
        title.setText(kingItem.getTitle());
        description.setText(kingItem.getDescription());
        ImageView image = holder.image;
        if (kingItem.getPictureUrl() != null && kingItem.getPictureUrl() != null) {
            Glide.with(context).load(kingItem.getPictureUrl()).apply(new RequestOptions()
                    .placeholder(R.drawable.placeholder)).into(image);
        }

    }

    @Override
    public int getItemCount() {
        return kingItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        public TextView title;

        @BindView(R.id.description)
        public TextView description;

        @BindView(R.id.details)
        public Button details;

        @BindView(R.id.share)
        public Button share;


        @BindView(R.id.image)
        public ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.share)
        void shareButton(View view) {
                King king = (King) view.getTag();
            ((Geronimo)context).share(king);
        }

        @OnClick(R.id.details)
        void detailButton(View view) {
            King king = (King) view.getTag();
            ((Geronimo)context).showDetailsAsToast(king);

        }
    }
}
