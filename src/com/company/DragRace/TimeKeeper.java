package com.company.DragRace;

import java.time.Clock;
import java.util.Timer;
import java.util.TimerTask;

public class TimeKeeper {
    private Clock clock;
    private Timer timer;
    private TimerTask task;

    public TimeKeeper(Timer timer, TimerTask task) {
        this.timer = timer;
        this.task = task;
    }

    public void timePass() {
        task.run();
    }

}
