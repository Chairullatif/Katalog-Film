package com.khoirullatif.katalogfilm.ui.tvshows;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.khoirullatif.katalogfilm.R;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;
import com.khoirullatif.katalogfilm.databinding.ItemTvShowsBinding;

import java.util.ArrayList;
import java.util.List;

public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder> {

    private final List<TvShowsEntity> listTvShows = new ArrayList<>();
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(TvShowsAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setTvShows(ArrayList<TvShowsEntity> listTvShows) {
        this.listTvShows.clear();
        this.listTvShows.addAll(listTvShows);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvShowsAdapter.TvShowsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        com.khoirullatif.katalogfilm.databinding.ItemTvShowsBinding binding = ItemTvShowsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TvShowsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowsAdapter.TvShowsViewHolder holder, int position) {
        TvShowsEntity tvShowsEntity = listTvShows.get(position);
        holder.bind(tvShowsEntity);

        holder.itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(listTvShows.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listTvShows.size();
    }

    public static class TvShowsViewHolder extends RecyclerView.ViewHolder {
        private final ItemTvShowsBinding binding;

        public TvShowsViewHolder(@NonNull ItemTvShowsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(TvShowsEntity tvShows) {
            Glide.with(itemView.getContext())
                    .load(tvShows.getPosterTv())
                    .placeholder(R.drawable.ic_photo_load)
                    .error(R.drawable.ic_broken_image_error)
                    .transform(new RoundedCorners(20))
                    .into(binding.ivTvshows);

            binding.tvTitleTvshows.setText(tvShows.getTitleTv());
            binding.tvReleaseTvshows.setText(tvShows.getReleaseDateTv());
            binding.tvRatingTvshows.setText(tvShows.getRatingTv());
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(TvShowsEntity data);
    }
}
