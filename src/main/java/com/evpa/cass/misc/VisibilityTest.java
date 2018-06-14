package com.evpa.cass.misc;

import java.util.*;

public class VisibilityTest {

    public static void main(String...args) {

        String deviceId = "EVPA";
        String allowDuplicates = null;//"true";

        //allowDuplicates != null && allowDuplicates.equalsIgnoreCase("true"))
        if ("true".equalsIgnoreCase(allowDuplicates)) {
            System.out.println("First case: " + allowDuplicates);
        } else {
            System.out.println("Second case: " + allowDuplicates);
        }

        if (allowDuplicates != null && allowDuplicates.equalsIgnoreCase("true")) {
            System.out.println("3 case: " + allowDuplicates);
        } else {
            System.out.println("4 case: " + allowDuplicates);
        }

        Map<String, UUID> schedulersBySeries = new HashMap<>();
        Map<UUID, List<Long>> seriesSchedules = new HashMap<>();
        getExistingScheduleMaps(deviceId, schedulersBySeries, seriesSchedules);
    }

    protected static void getExistingScheduleMaps(String deviceId, Map<String, UUID> schedulersBySeries, Map<UUID, List<Long>> seriesSchedules) {
        for (int i = 0; i < 3; i++) {
            String seriesId = "seriesId - " + i;
            UUID schedulerId = UUID.randomUUID();
            addSchedulersBySeries(i, seriesId, schedulerId, schedulersBySeries);
            insertRecording(deviceId,schedulersBySeries,seriesSchedules,new Date().getTime());
        }

    }

    protected static Map<String, UUID> addSchedulersBySeries(int recType, String seriesId, UUID schedulerId, Map<String, UUID> schedulersBySeries) {
        //if (isSeriesSchedule(recType, schedulerId))
        //    if (StringUtils.isNotBlank(seriesId) && !schedulersBySeries.containsKey(seriesId))
                schedulersBySeries.put(seriesId, schedulerId);

        return schedulersBySeries;
    }

    protected static void insertRecording(String deviceId,  Map<String, UUID> schedulersBySeries,
                                   Map<UUID, List<Long>> seriesSchedules, long currentTime) {
        System.out.println(schedulersBySeries);
    }
}
