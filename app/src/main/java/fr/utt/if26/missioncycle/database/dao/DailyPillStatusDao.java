package fr.utt.if26.missioncycle.database.dao;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.utt.if26.missioncycle.models.DailyPillStatus;

public interface DailyPillStatusDao {

    @Query("SELECT * FROM DailyPillStatus WHERE userId = :userId")
    LiveData<List<DailyPillStatus>> getDailyPillStatus(long userId);

    @Query("SELECT * FROM DailyPillStatus WHERE userId = :userId")
    Cursor getDailyPillStatusWithCursor(long userId);

    @Insert

    long insertDailyPillStatus(DailyPillStatus dailyPillStatus);

    @Update

    int updateDailyPillStatus(DailyPillStatus dailyPillStatus);

    @Query("DELETE FROM DailyPillStatus WHERE id = :id")

    int deleteDailyPillStatus(long id);
}
