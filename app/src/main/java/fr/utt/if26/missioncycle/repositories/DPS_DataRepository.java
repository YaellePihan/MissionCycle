package fr.utt.if26.missioncycle.repositories;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.utt.if26.missioncycle.database.dao.DailyPillStatusDao;
import fr.utt.if26.missioncycle.models.DailyPillStatus;

public class DPS_DataRepository {

    private final DailyPillStatusDao dailyPillStatusDao;

    public DPS_DataRepository(DailyPillStatusDao dailyPillStatusDao) { this.dailyPillStatusDao = dailyPillStatusDao; }

    // --- GET ---

    public LiveData<List<DailyPillStatus>> getDailyPillStatus(long userId){ return this.dailyPillStatusDao.getDailyPillStatus(userId); }
    // --- CREATE ---


    public void createDailyPillStatus(DailyPillStatus dailyPillStatus){ dailyPillStatusDao.insertDailyPillStatus(dailyPillStatus); }

    // --- DELETE ---

    public void deleteDailyPillStatus(long dailyPillStatusId){ dailyPillStatusDao.deleteDailyPillStatus(dailyPillStatusId); }

    // --- UPDATE ---

    public void updateDailyPillStatus(DailyPillStatus dailyPillStatus){ dailyPillStatusDao.updateDailyPillStatus(dailyPillStatus); }
}
