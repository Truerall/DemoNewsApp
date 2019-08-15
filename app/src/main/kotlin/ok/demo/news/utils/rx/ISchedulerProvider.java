package ok.demo.news.utils.rx;

import io.reactivex.Scheduler;

public interface ISchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}