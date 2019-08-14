package nl.tmg.dutchnews.utils.rx;

import io.reactivex.Scheduler;

public interface ISchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}