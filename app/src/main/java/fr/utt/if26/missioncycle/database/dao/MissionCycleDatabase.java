package fr.utt.if26.missioncycle.database.dao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import fr.utt.if26.missioncycle.models.User;

public abstract class MissionCycleDatabase extends RoomDatabase {
    // --- SINGLETON ---

    private static volatile MissionCycleDatabase INSTANCE;

    // --- DAO ---

    public abstract UserDao userDao();

    // --- INSTANCE ---

    public static MissionCycleDatabase getInstance(Context context) {

        if (INSTANCE == null) {

            synchronized (MissionCycleDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),

                                    MissionCycleDatabase.class, "MyDatabase.db")

                            .addCallback(prepopulateDatabase())

                            .build();

                }

            }

        }

        return INSTANCE;

    }

    private static Callback prepopulateDatabase() {

        return new Callback() {

            @Override

            public void onCreate(@NonNull SupportSQLiteDatabase db) {

                super.onCreate(db);

                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.userDao().createUser(new User("Yaya")));

            }

        };

    }
}
