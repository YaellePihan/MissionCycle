package fr.utt.if26.missioncycle.pillCalendar;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.Executor;

import fr.utt.if26.missioncycle.models.DailyPillStatus;
import fr.utt.if26.missioncycle.models.User;
import fr.utt.if26.missioncycle.repositories.DPS_DataRepository;
import fr.utt.if26.missioncycle.repositories.UserDataRepository;

public class DPS_ViewModel extends ViewModel {
    // REPOSITORIES

    private final DPS_DataRepository dpsDataRepository;

    private final UserDataRepository userDataRepository;

    private final Executor executor;

    // DATA

    @Nullable

    private LiveData<User> currentUser;

    public DPS_ViewModel(DPS_DataRepository itemDataSource, UserDataRepository userDataSource, Executor executor) {

        this.dpsDataRepository = itemDataSource;

        this.userDataRepository = userDataSource;

        this.executor = executor;

    }

    public void init(long userId) {

        if (this.currentUser != null) {

            return;

        }

        currentUser = userDataRepository.getUser(userId);

    }

    // -------------

    // FOR USER

    // -------------

    public LiveData<User> getUser() { return this.currentUser;  }

    // -------------

    // FOR DAILY PILL STATUS

    // -------------

    public LiveData<List<DailyPillStatus>> getDailyPillStatus(long userId) {

        return dpsDataRepository.getDailyPillStatus(userId);

    }

    public void createDailyPillStatus() {

        executor.execute(() -> {

            dpsDataRepository.createDailyPillStatus(new DailyPillStatus());

        });

    }

    public void deleteDailyPillStatus(long dpsId) {

        executor.execute(() -> dpsDataRepository.deleteDailyPillStatus(dpsId));

    }

    public void updateDailyPillStatus(DailyPillStatus dps) {

        executor.execute(() -> dpsDataRepository.updateDailyPillStatus(dps));
    }
}
