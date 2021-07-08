package com.khoirullatif.katalogfilm.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.khoirullatif.katalogfilm.data.source.local.entity.DetailMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.DetailTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteMoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.FavoriteTvShowsEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.MoviesEntity;
import com.khoirullatif.katalogfilm.data.source.local.entity.TvShowsEntity;

@Database(entities = {FavoriteMoviesEntity.class,
        FavoriteTvShowsEntity.class,
        MoviesEntity.class,
        TvShowsEntity.class,
        DetailMoviesEntity.class,
        DetailTvShowsEntity.class}, version = 1, exportSchema = false)
public abstract class CatalogRoomDatabase extends RoomDatabase {
    public abstract CatalogDao catalogDao();

    private static volatile CatalogRoomDatabase INSTANCE;

    public static CatalogRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CatalogRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CatalogRoomDatabase.class, "catalog_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
