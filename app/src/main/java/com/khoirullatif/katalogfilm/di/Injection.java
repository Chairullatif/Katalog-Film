package com.khoirullatif.katalogfilm.di;

import android.content.Context;

import com.khoirullatif.katalogfilm.data.CatalogRepository;
import com.khoirullatif.katalogfilm.data.source.local.LocalDataSource;
import com.khoirullatif.katalogfilm.data.source.local.room.CatalogRoomDatabase;
import com.khoirullatif.katalogfilm.data.source.remote.RemoteDataSource;
import com.khoirullatif.katalogfilm.utils.AppExecutors;

public class Injection {
    public static CatalogRepository provideRepository(Context context) {
        CatalogRoomDatabase database = CatalogRoomDatabase.getDatabase(context);

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance();
        LocalDataSource localDataSource = LocalDataSource.getInstance(database.catalogDao());
        AppExecutors appExecutors = new AppExecutors();

        return CatalogRepository.getInstance(remoteDataSource, localDataSource, appExecutors);
    }
}
