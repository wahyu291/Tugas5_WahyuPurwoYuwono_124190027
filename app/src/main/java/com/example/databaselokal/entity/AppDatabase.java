package com.example.databaselokal.entity;
import android.content.Context;
import androidx.room.Database;
import androidx.room. Room;
import androidx.room. RoomDatabase;

@Database(entities {DataDesa.class}, version =1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataDesaDAO dao();

    private static AppDatabase appDatabase;

    public static AppDatabase inidb(Context context) {
        if (appDatabase == null)
            appDatabase =
                    Room.databaseBuilder(context, AppDatabase.class, "dbKampus").allowMainThreadQueries().build();
        return appDatabase;
    }
}