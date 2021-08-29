package com.company.DragRace;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.Timer;
import java.util.TimerTask;

public class TimeKeeper {
    protected static Clock clock = Clock.system(ZoneId.systemDefault());
    protected static LocalDateTime endTime = LocalDateTime.now();
    private Timer timer;
    private TimerTask task;

    public TimeKeeper() {
        this.timer = new Timer();

    }

    public static void timePass() {
        endTime = endTime.plusSeconds(1L);
    }

    public static void passClockTime() {
        Duration duration = Duration.ofSeconds(1);
        clock = Clock.tick(clock, duration);

    }

    public Clock getClock() {
        return clock;
    }
}
