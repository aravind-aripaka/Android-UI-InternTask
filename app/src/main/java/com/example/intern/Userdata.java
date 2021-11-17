package com.example.intern;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Userdata {
    public int imageid;
    public String username;
    public String replyname;
    public int amount;
    public Date date;
    public  Userdata(int imageid, String username, String replyname, int amount){
        this.imageid = imageid;
        this.username = username;
        this.replyname = replyname;
        this.amount = amount;
        Date MIN_DATE = new Date(Long.MIN_VALUE);
        Date MAX_DATE = new Date(Long.MAX_VALUE);
        this.date = between( MIN_DATE, MAX_DATE);
    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }
}
