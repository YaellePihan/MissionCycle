package fr.utt.if26.missioncycle.repositories;

import androidx.lifecycle.LiveData;

import fr.utt.if26.missioncycle.database.dao.UserDao;
import fr.utt.if26.missioncycle.models.User;

public class UserDataRepository {
    private final UserDao userDao;

    public UserDataRepository(UserDao userDao) { this.userDao = userDao; }

    // --- GET USER ---

    public LiveData<User> getUser(long userId) { return this.userDao.getUser(userId); }
}
