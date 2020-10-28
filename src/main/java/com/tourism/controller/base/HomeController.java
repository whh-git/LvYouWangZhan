package com.tourism.controller.base;

import com.tourism.dao.ContentFlowDao;
import com.tourism.dao.SceneryDao;
import com.tourism.entity.ContentFlow;
import com.tourism.entity.Desktop;
import com.tourism.entity.Scenery;
import com.tourism.entity.TopFlow;
import com.tourism.service.ContentFlowService;
import com.tourism.service.DesktopService;
import com.tourism.service.TopFlowService;
import com.tourism.service.impl.ContentFlowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wmz on 2020/7/13.
 */
@Controller
@RequestMapping(value="/base")
public class HomeController {

    @Autowired
    ContentFlowService contentFlowService;
    @Autowired
    ContentFlowDao contentFlowDao;
    @Autowired
    SceneryDao sceneryDao;

    @Autowired
    ContentFlowServiceImpl contentFlowServiceImpl;

    @Autowired
    TopFlowService topFlowService;

    @Autowired
    DesktopService desktopService;


    @RequestMapping(value="/home")
    public String view(HttpServletRequest request){
        // iCBFileService.getICBImageUrl("http://10.4.3.13:6888/dacx/temp/10.4.199.174/440003/00004413000000000000064001/2.tif ","test" ,"00004413000000000000064001", 2);
        return "/base/home";
    }
    @RequestMapping(value="/test")
    public String test(HttpServletRequest request){
        // iCBFileService.getICBImageUrl("http://10.4.3.13:6888/dacx/temp/10.4.199.174/440003/00004413000000000000064001/2.tif ","test" ,"00004413000000000000064001", 2);
        return "/base/print";
    }

    /*@RequestMapping(value="/index")
    public String index(HttpServletRequest request){

        return "/lover/index";
    }*/

    @RequestMapping(value="/index")
    public String index(HttpServletRequest request){

        List<ContentFlow> contentFlowList = contentFlowService.getAllLabel();
        for (ContentFlow a:contentFlowList) {
            if(a.getPupNo()==null){
                a.setPupNo(0);
            }
            if(a.getTodayPupNo()==null){
                a.setTodayPupNo(0);
            }
        }
        Collections.sort(contentFlowList, new Comparator<ContentFlow>() {
            public int compare(ContentFlow o1, ContentFlow o2) {
                return   o2.getPupNo() -o1.getPupNo() ;
            }
        });
        List<ContentFlow> list = new ArrayList<ContentFlow>();


        for(int i = 0; i < 3; i++){
            list .add(contentFlowList.get(i));
        }

        List<TopFlow> topFlowList = topFlowService.getAll();
        request.setAttribute("contentFlowList",list);
        request.setAttribute("topFlowList",topFlowList);
        List<Desktop> desktopList = desktopService.getAll();
        if(desktopList!=null||desktopList.size()!=0){
            request.getSession().setAttribute("desktop",desktopList.get(0));
        }else{
            Desktop desktop = new Desktop();
            request.getSession().setAttribute("desktop",desktop);
        }
        return "/page/index";
    }

    @RequestMapping(value="/addPupNo")
    public void addPupNo(String id){
        Scenery scenery = sceneryDao.findById(id);
        if(scenery !=null) {
            contentFlowServiceImpl.updateCF(scenery.getKeyword());
        }
        System.out.println(id);
    }
}
