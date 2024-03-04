package com.example.abc.controller.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("zx3")
public class Zx3 extends SimpleTagSupport {

    private String id ;
    private Map<String, String> kind;
    public void setId(String id){this.id = id;}
    public void setKind(Map<String, String> kind){this.kind = kind;}

    @Override
    public void doTag() throws JspException, IOException {

        System.out.println("id: " +this.id + " map size:" +this.kind.size());

        for (int i = 0; i < 10; i++) {
            getJspContext().setAttribute("msg", "第一列"+i + "   ");
            getJspContext().setAttribute("counts", "第二列:"+i);
            getJspBody().invoke(null);
        }
    }
    /*
    http://127.0.0.1:8080/zx3/zx3_method1
     */
    @RequestMapping("zx3_method1")
    public String zx3_method1(Model m){
        Map<String , String> map = new TreeMap<String , String>();
        map.put("z001" , "x001");
        map.put("z003" , "x002");
        m.addAttribute("map" , map);
        return "zx3";
    }
}
