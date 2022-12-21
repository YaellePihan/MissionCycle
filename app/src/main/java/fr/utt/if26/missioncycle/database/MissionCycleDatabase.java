package fr.utt.if26.missioncycle.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import fr.utt.if26.missioncycle.database.dao.DailyPillStatusDao;
import fr.utt.if26.missioncycle.database.dao.UserDao;
import fr.utt.if26.missioncycle.models.DailyPillStatus;
import fr.utt.if26.missioncycle.models.User;

public abstract class MissionCycleDatabase extends RoomDatabase {
    // --- SINGLETON ---

    private static volatile MissionCycleDatabase INSTANCE;

    // --- DAO ---

    public abstract UserDao userDao();

    public abstract DailyPillStatusDao dailyPillStatusDao();

    // --- INSTANCE ---

    public static MissionCycleDatabase getInstance(Context context) {

        if (INSTANCE == null) {

            synchronized (MissionCycleDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),

                                    MissionCycleDatabase.class, "MissionCycleDatabase.db")

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
                User user1 = new User("Yaya");
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.userDao().insertUser(user1));
                DailyPillStatus dailyPillStatus1 = new DailyPillStatus(user1.getId(), "20-12-2022", null, "TAKEN", true);
                DailyPillStatus dailyPillStatus2 = new DailyPillStatus(user1.getId(), "22-12-2022", "13:00", "TAKEN", true);
                DailyPillStatus dailyPillStatus3 = new DailyPillStatus(user1.getId(), "22-12-2022", "13:00", "TAKEN", true);
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.dailyPillStatusDao().insertDailyPillStatus(dailyPillStatus1));
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.dailyPillStatusDao().insertDailyPillStatus(dailyPillStatus2));
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.dailyPillStatusDao().insertDailyPillStatus(dailyPillStatus3));

            }

        };

    }
}
