package fr.utt.if26.missioncycle.database.dao;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.utt.if26.missioncycle.models.DailyPillStatus;

@Dao
public interface DPS_Dao {

    @Query("SELECT * FROM DailyPillStatus WHERE userId = :userId")
    LiveData<List<DailyPillStatus>> get_DPS(long userId);

    @Query("SELECT * FROM DailyPillStatus WHERE userId = :userId")
    Cursor get_DPS_WithCursor(long userId);

    @Insert
    long insert_DPS(DailyPillStatus dps);

    @Update
    int update_DPS(DailyPillStatus dps);

    @Query("DELETE FROM DailyPillStatus WHERE id = :id")
    int delete_DPS(long id);
}
