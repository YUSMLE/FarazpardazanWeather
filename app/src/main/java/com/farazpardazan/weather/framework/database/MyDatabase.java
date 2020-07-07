package com.farazpardazan.weather.framework.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.farazpardazan.weather.framework.database.dao.CityDao;
import com.farazpardazan.weather.framework.database.entity.CityEntity;

@Database(
        entities = {
                CityEntity.class
        },
        version = 1
)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "open_cities_database";

    /**
     * Define the DAOs that work with the database.
     * Provide an abstract "getter" method for each @Dao.
     */

    public abstract CityDao getCityDao();

    /**
     * Make the `MyDatabase` a singleton to prevent having
     * multiple instances of the database opened at the same time.
     */

    private static volatile MyDatabase INSTANCE;

    public static MyDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room
                            .databaseBuilder(
                                    context.getApplicationContext(),
                                    MyDatabase.class,
                                    DATABASE_NAME
                            )
                            .addCallback(roomDatabaseCallback)
                            .allowMainThreadQueries()
                            //.fallbackToDestructiveMigration()
                            //.addMigrations(new Migration0_1())
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    /**
     * Prepare callback for when the database is opened.
     * <p>
     * To delete all content and repopulate the database whenever the app is started,
     * you create a `RoomDatabase.Callback` and override the `onOpen()` method.
     * Because you cannot do Room database operations on the UI thread, `onOpen()` creates and
     * executes an `AsyncTask` to add content to the database.
     */

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new InitializeDbAsync(INSTANCE).execute();
        }
    };

    /**
     * Populate the database
     */

    private static class InitializeDbAsync extends AsyncTask<Void, Void, Void> {
        private final CityDao cityDao;

        InitializeDbAsync(MyDatabase db) {
            cityDao = db.getCityDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            /* Initial and store default entities here */

            return null;
        }
    }
}
