package com.yrag.helperSpringBoot.utiles;

import com.yrag.helperSpringBoot.info.TimerInfo;
import org.quartz.*;

import java.util.Date;

public final class TimerUtils {

    public TimerUtils() {
    }

    public static JobDetail buildJobDetail(final Class clazz, final TimerInfo info) {
        final JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(clazz.getSimpleName(), info);

        return JobBuilder
                .newJob(clazz)
                .withIdentity(clazz.getSimpleName())
                .setJobData(jobDataMap)
                .build();
    }

    public static Trigger buildTrigger(final Class jobClass, final TimerInfo info) {
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(info.getRepeatIntervalMs());

        if (info.isRunForever()) {
            builder = builder.repeatForever();
        } else {
            builder = builder.withRepeatCount(info.getTotalFireCount() -1);
        }

        return TriggerBuilder
                .newTrigger()
                .withIdentity(jobClass.getSimpleName())
                .withSchedule(builder)
                .startAt(new Date(System.currentTimeMillis() + info.getInitialOffsetMs()))
                .build();
    }
}
