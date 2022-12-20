package fr.utt.if26.missioncycle.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DailyPillStatus {
    private String day;
    private String hour; //transform in timestamp
    private String pillStatus;
    private Boolean is_protectedDay;
    @PrimaryKey(autoGenerate = true)
    private long id;
    //how to make user foreign key ?
    //some modif to test gitkraken repo 

}
