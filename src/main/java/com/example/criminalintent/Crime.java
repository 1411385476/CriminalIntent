package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTilte;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
      mId = UUID.randomUUID();
      mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTilte() {
        return mTilte;
    }

    public void setTilte(String tilte) {
        mTilte = tilte;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
