package fr.utt.if26.missioncycle.models;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "userId"))
public class DailyPillStatus {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long userId;
    private String day; //transform in timestamp
    @Nullable
    private String hour; //transform in timestamp
    private String pillStatus;
    private Boolean is_protectedDay;

    public DailyPillStatus() {
    }

    public DailyPillStatus(long userId, String day, @Nullable String hour, String pillStatus, Boolean is_protectedDay) {
        this.userId = userId;
        this.day = day;
        this.hour = hour;
        this.pillStatus = pillStatus;
        this.is_protectedDay = is_protectedDay;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setPillStatus(String pillStatus) {
        this.pillStatus = pillStatus;
    }

    public void setIs_protectedDay(Boolean is_protectedDay) {
        this.is_protectedDay = is_protectedDay;
    }
}
