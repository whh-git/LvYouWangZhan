package com.tourism.utils;


import com.tourism.dao.ContentFlowDao;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Calendar;
import java.util.Date;

public class cleanPup extends QuartzJobBean {

    @Autowired
    private ContentFlowDao contentFlowDao;

    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        String week = "";
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
            if (weekday == 1) {
                week = "星期日";
            }else if (weekday == 2) {
                week = "星期一";
            } else if (weekday == 3) {
                week = "星期二";
            } else if (weekday == 4) {
                week = "星期三";
            } else if (weekday == 5) {
                week = "星期四";
            } else if (weekday == 6) {
                week = "星期五";
            } else if (weekday == 7) {
                week = "星期六";
           }
            if(week.equals("星期一")){
                contentFlowDao.updatePup();
                contentFlowDao.updateTPup();
            }else{
                contentFlowDao.updateTPup();
            }
    }
}
