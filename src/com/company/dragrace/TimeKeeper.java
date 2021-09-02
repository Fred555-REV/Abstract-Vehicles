package com.company.dragrace;

import java.time.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimeKeeper {
    protected static Clock clock = Clock.system(ZoneId.systemDefault());
    protected static LocalDateTime endTime = LocalDateTime.now();
    public static void timePass() {
        endTime = endTime.plusSeconds(2L);
    }

    public static void passClockTime() {
        Duration duration = Duration.ofSeconds(1);
        clock = Clock.tick(clock, duration);

    }

    public static Clock getClock() {
        return clock;
    }
}
