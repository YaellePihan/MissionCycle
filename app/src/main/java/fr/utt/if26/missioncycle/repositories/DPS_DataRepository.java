package fr.utt.if26.missioncycle.repositories;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.utt.if26.missioncycle.database.dao.DPS_Dao;
import fr.utt.if26.missioncycle.models.DailyPillStatus;

public class DPS_DataRepository {

    private final DPS_Dao dpsDao;

    public DPS_DataRepository(DPS_Dao dpsDao) { this.dpsDao = dpsDao; }

    // --- GET ---

    public LiveData<List<DailyPillStatus>> get_DPS(long userId){ return this.dpsDao.get_DPS(userId); }
    // --- CREATE ---


    public void create_DPS(DailyPillStatus dps){ dpsDao.insert_DPS(dps); }

    // --- DELETE ---

    public void delete_DPS(long dpsId){ dpsDao.delete_DPS(dpsId); }

    // --- UPDATE ---

    public void update_DPS(DailyPillStatus dps){ dpsDao.update_DPS(dps); }
}
