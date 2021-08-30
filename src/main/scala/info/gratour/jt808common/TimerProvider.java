package info.gratour.jt808common;


import java.util.concurrent.TimeUnit;

public interface TimerProvider {

    Timer newTimer(Object key, int time, TimeUnit timeUnit, Runnable job);
}
