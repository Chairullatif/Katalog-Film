package com.khoirullatif.katalogfilm.ui.favorite.favmovies;

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
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.databinding.ItemFavMoviesBinding;

public class FavoriteMoviesAdapter extends PagedListAdapter<FavoriteMoviesEntity, FavoriteMoviesAdapter.FavoriteMoviesViewHolder> {

    private final FavoriteMoviesFragmentCallback callback;

    FavoriteMoviesAdapter(FavoriteMoviesFragmentCallback callback) {
        super(DIFF_CALLBACK);
        this.callback = callback;
    }

    private static final DiffUtil.ItemCallback<FavoriteMoviesEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FavoriteMoviesEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull FavoriteMoviesEntity oldItem, @NonNull FavoriteMoviesEntity newItem) {
                    return oldItem.getId().equals(newItem.getId());
                }
                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull FavoriteMoviesEntity oldItem, @NonNull FavoriteMoviesEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    @NonNull
    @Override
    public FavoriteMoviesAdapter.FavoriteMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFavMoviesBinding binding = ItemFavMoviesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavoriteMoviesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteMoviesAdapter.FavoriteMoviesViewHolder holder, int position) {
        FavoriteMoviesEntity favoriteMoviesEntity = getItem(position);
        holder.bind(favoriteMoviesEntity);

        holder.itemView.setOnClickListener(view -> callback.onItemClicked(getItem(holder.getAdapterPosition())));

    }

    public class FavoriteMoviesViewHolder extends RecyclerView.ViewHolder {
        private final ItemFavMoviesBinding binding;

        public FavoriteMoviesViewHolder(@NonNull ItemFavMoviesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(FavoriteMoviesEntity favoriteMoviesEntity) {

            Glide.with(itemView.getContext())
                    .load(favoriteMoviesEntity.getPoster())
                    .placeholder(R.drawable.ic_photo_load)
                    .error(R.drawable.ic_broken_image_error)
                    .transform(new RoundedCorners(20))
                    .into(binding.ivMovies);

            binding.tvTitleMovie.setText(favoriteMoviesEntity.getTitle());
            binding.tvReleaseMovie.setText(favoriteMoviesEntity.getReleaseDate());
            binding.tvRatingMovie.setText(favoriteMoviesEntity.getRating());

            binding.floatingActionButton.setOnClickListener(view -> callback.onFloatingActionClick(favoriteMoviesEntity));
        }
    }
}
