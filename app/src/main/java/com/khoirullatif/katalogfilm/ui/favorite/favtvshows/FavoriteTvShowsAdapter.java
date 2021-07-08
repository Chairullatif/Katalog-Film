package com.khoirullatif.katalogfilm.ui.favorite.favtvshows;



import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.khoirullatif.katalogfilm.R;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.databinding.ItemFavTvshowsBinding;

public class FavoriteTvShowsAdapter extends PagedListAdapter<FavoriteTvShowsEntity, FavoriteTvShowsAdapter.FavoriteTvShowsViewHolder> {

    private final FavoriteTvShowFragmentCallback callback;

    FavoriteTvShowsAdapter(FavoriteTvShowFragmentCallback callback) {
        super(DIFF_CALLBACK);
        this.callback = callback;
    }

    private static final DiffUtil.ItemCallback<FavoriteTvShowsEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FavoriteTvShowsEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull FavoriteTvShowsEntity oldItem, @NonNull FavoriteTvShowsEntity newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }
                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull FavoriteTvShowsEntity oldItem, @NonNull FavoriteTvShowsEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public FavoriteTvShowsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFavTvshowsBinding binding = ItemFavTvshowsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavoriteTvShowsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteTvShowsViewHolder holder, int position) {
        FavoriteTvShowsEntity favoriteTvShowsEntity = getItem(position);
        holder.bind(favoriteTvShowsEntity);

        holder.itemView.setOnClickListener(view -> callback.onItemClicked(getItem(holder.getAdapterPosition())));
    }

    public class FavoriteTvShowsViewHolder extends RecyclerView.ViewHolder {
        private final ItemFavTvshowsBinding binding;


        public FavoriteTvShowsViewHolder(@NonNull ItemFavTvshowsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(FavoriteTvShowsEntity favoriteTvShowsEntity) {
            Glide.with(itemView.getContext())
                    .load(favoriteTvShowsEntity.getPoster())
                    .placeholder(R.drawable.ic_photo_load)
                    .error(R.drawable.ic_broken_image_error)
                    .transform(new RoundedCorners(20))
                    .into(binding.ivMovies);

            binding.tvTitleMovie.setText(favoriteTvShowsEntity.getTitle());
            binding.tvReleaseMovie.setText(favoriteTvShowsEntity.getReleaseDate());
            binding.tvRatingMovie.setText(favoriteTvShowsEntity.getRating());

            binding.floatingActionButton.setOnClickListener(view -> callback.onFloatingActionClick(favoriteTvShowsEntity));
        }
    }
}
