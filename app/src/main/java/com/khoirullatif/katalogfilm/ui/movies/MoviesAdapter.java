package com.khoirullatif.katalogfilm.ui.movies;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.khoirullatif.katalogfilm.R;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.databinding.ItemMoviesBinding;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private final List<MoviesEntity> listMovies = new ArrayList<>();
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public void setMovies(ArrayList<MoviesEntity> listMovies) {
        this.listMovies.clear();
        this.listMovies.addAll(listMovies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MoviesAdapter.MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        com.khoirullatif.katalogfilm.databinding.ItemMoviesBinding binding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MoviesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MoviesViewHolder holder, int position) {
        MoviesEntity movies = listMovies.get(position);
        holder.bind(movies);

        holder.itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(listMovies.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public static class MoviesViewHolder extends RecyclerView.ViewHolder {
        private final ItemMoviesBinding binding;
        public MoviesViewHolder(@NonNull ItemMoviesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(MoviesEntity movies) {
            Log.d("onMA getImage", String.valueOf(movies.getPoster()));

            Glide.with(itemView.getContext())
                    .load(movies.getPoster())
                    .placeholder(R.drawable.ic_photo_load)
                    .error(R.drawable.ic_broken_image_error)
                    .transform(new RoundedCorners(30))
                    .into(binding.ivMovies);

            binding.tvTitleMovie.setText(movies.getTitle());
            binding.tvReleaseMovie.setText(movies.getReleaseDate());
            binding.tvRatingMovie.setText(movies.getRating());
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(MoviesEntity data);
    }
}
