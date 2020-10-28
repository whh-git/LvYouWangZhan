package com.tourism.common;

import com.show.api.ShowApiRequest;

public class ApiData {

    public String getApiData(String keyword){
        String res = new ShowApiRequest("http://route.showapi.com/268-1","163018","bf346b8dd7d74be590bed319cef96e1a")
                .addTextPara("keyword",keyword)
                .addTextPara("proId","")
                .addTextPara("cityId","")
                .addTextPara("areaId","")
                .addTextPara("page","")
                .post();

        return res;
    }

}
