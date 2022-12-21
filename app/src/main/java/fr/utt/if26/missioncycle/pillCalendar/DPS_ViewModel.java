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

    public LiveData<User> getUser() {
        return this.currentUser;
    }

    // -------------

    // FOR DAILY PILL STATUS

    // -------------

    public LiveData<List<DailyPillStatus>> get_DPS(long userId) {

        return dpsDataRepository.get_DPS(userId);

    }

    public void create_DPS(long userId, String day, String hour, String pillStatus, Boolean is_protectedDay) {

        executor.execute(() -> {

            dpsDataRepository.create_DPS(new DailyPillStatus(userId,day,hour,pillStatus,is_protectedDay));

        });

    }

    public void delete_DPS(long dpsId) {

        executor.execute(() -> dpsDataRepository.delete_DPS(dpsId));

    }

    public void update_DPS(DailyPillStatus dps) {

        executor.execute(() -> dpsDataRepository.update_DPS(dps));
    }
}
