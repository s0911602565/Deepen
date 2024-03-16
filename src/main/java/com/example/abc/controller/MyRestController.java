package com.example.abc.controller;
/*
@Controller     (O)轉HTML 舉例 return "index" 會成功
@RestController (X)轉HTML

@RequestParam
@PathVariable
@RequestBody (json)
@ResponseBody
@RequestPart 上傳檔案
@RequestHeader 標頭-資訊
@DateTimeFormat 日期格式(搜尋 getMessage9)
@ModelAttribute(沒參數) / (有參數)
@ConfigurationProperties prefix
@Value
@PostConstruct
* */

import com.example.abc.model.*;
import com.example.abc.sql.claasic.Car;
import com.example.abc.sql.dao.CarRepository;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("handle")
public class MyRestController {
    private static final Logger logger = LoggerFactory.getLogger(MyRestController.class);

    @Autowired UseTheValue1_Hard hard;
    @Autowired UseTheValue_Basic basic;
    @Autowired CarRepository carRepository;

    /* http://127.0.0.1:8080/form.html  */
    @RequestMapping
    public String getMessage(@RequestParam(name = "username", required = false, defaultValue = "johnlee") String username, @RequestParam String pwd) {
        MDC.put("my_tag_event","====location MyController.java ===");
        logger.info("have {} info",5);
        logger.debug("debug");
        logger.error("error");
        return "(handle) " + username + "/" + pwd;
    }

    /* http://127.0.0.1:8080/form.html */
    @RequestMapping("/obj")
    public String getMessage2(User user) {
        return "getMessage2: " + user.getUsername() + " " + user.getPwd();
    }


    //路徑變數 基本型別
    /* http://127.0.0.1:8080/form.html */
    @RequestMapping("/url/{id}/{userName}")
    public String getMessage3(@PathVariable("id") String p_Id, @PathVariable("userName") String p_UserName) {
        return "getMessage3: " + p_UserName + " " + p_Id;
    }

    /*
    開啟 post man ,  http://127.0.0.1:8080/handle/json
    * */
    @RequestMapping("/json")
    public ResponseEntity<User> getJson() {
        User user2 = new User();
        user2.setPwd("()");
        user2.setUsername("john1ee");
        return new ResponseEntity<User>(user2, HttpStatus.OK);
    }

    /*
    以下貼到post man
    使用網址取得資訊  http://127.0.0.1:8080/handle/json2
    {
    "username":"john",
    "pwd":"123"
    }
    */
    @RequestMapping("/json2")
    public void getJson2(@RequestBody User user) {
        System.out.println("getJson2:" + user.getUsername());
        System.out.println("getJson2:" + user.getPwd());
    }


    /*
    以下貼到post man
    http://127.0.0.1:8080/handle/json7

    * (先安裝httpie、設定PATH,把my.json丟到D槽, 打開cmd ,輸入->) http POST http://127.0.0.1:8080/handle/json7 < my.json
    [] = List 或 Array
    {} = json , ex: User.class
    引用 my.json
    */

    @RequestMapping("/json7")
    public void getJson7(@RequestBody List<User> user) {
        for(User u : user){
            System.out.println("getJson7:" + u.getUsername());
            System.out.println("getJson7:" + u.getPwd());
            for(String r : u.getArr()){
                System.out.println("arr: " + r);
            }
            List<Amt> m = u.getAmt();
            for(Amt m2 : m ){
                System.out.println("Amt:"+ m2.getId() + "/"+m2.getMoney());
            }

            System.out.println("--------End----------");
        }

    }

    /*
    目的:自訂_表頭_資訊
    以下貼到post man  or web,   http://127.0.0.1:8080/handle/json3

    點選 post man 的 Headers 可以看到 key and value
    web模式 > F12 > network > (ctrl + R 如果有提示的話) > 表頭Name 滑鼠右鍵 > 選擇 Response Headers > Manage Headers Column > 增加key(輸入:Content-Type) > 就會出現value了
    */
    @RequestMapping("/json3")
    public HttpEntity<String> getJson3() {
        HttpHeaders r = new HttpHeaders();
        r.set("my", "zzz");
        r.set("whoami", "lee");
        return new HttpEntity<String>("Hello World3", r);
    }

    /*
    目的:自訂_表頭_資訊
    以下貼到post man or web ,   http://127.0.0.1:8080/handle/json4_For_Web

    點選 post man 的 Headers 可以看到 key and value
    web模式 > F12 > network > (ctrl + R 如果有提示的話) > 表頭Name 滑鼠右鍵 > 選擇 Response Headers > Manage Headers Column > 增加key(輸入:Content-Type) > 就會出現value了
    */
    @RequestMapping("/json4_For_Web")
    public void getJson4(HttpServletResponse r) throws Exception {
        r.addHeader("Content-Type", "text/html;charset=UTF-8");
        PrintWriter out = r.getWriter();
        out.write("Hello World4");
        out.close();
    }

    /*
    目的: 建立user類別
    乾淨的
    @ModelAttribute User user 左邊等同 ->  new User()
    http://127.0.0.1:8080/handle/what/test123

    重要: PathVariable 的宣告名稱 不能跟User的欄位名稱一樣...
    舉例PathVariable(_username) vs User(username) 這樣會造成null(不知道原因)

    * */
    @RequestMapping("what/{_name}")
    @ResponseBody
    public Optional<User> getWhat(
            @PathVariable String _name,
            @ModelAttribute User user){
        if(user.getUsername().equals(_name))
            return Optional.of(user);

        return Optional.empty();
    }



    /*
    目的: 建立user類別
    有值
    @ModelAttribute("mUser") User user 左邊等同 ->  m.addAttribute("mUser" , new User())
    http://127.0.0.1:8080/handle/what2
    * */
    @RequestMapping("what2")
    @ResponseBody
    public String getWhat2(@ModelAttribute("mUser")User user , Model m){
        User user2 = (User)m.getAttribute("mUser");
        if(user2 != null){
            System.out.println(user2.getUsername());
            System.out.println(user2.getPwd());
        }

        return "getWhat2";
    }

    /*
    http://127.0.0.1:8080/handle/what3
    * */
    @RequestMapping("what3")
    public String getWhat3(User user){
        System.out.println("what3"+user.getUsername());
        System.out.println("what3"+user.getPwd());
        return "getWhat3";
    }


    //取得-路徑變數 map型態
    @RequestMapping("/url2/{id}/{userName}")
    public String getMessage4(@PathVariable Map pathMap) {/* http://127.0.0.1:8080/form.html */
        System.out.println(pathMap.get("id"));
        System.out.println(pathMap.get("userName"));
        return "getMessage4: " + pathMap;
    }

    //檔案上傳(1個)
    /* http://127.0.0.1:8080/index.html */
    @RequestMapping("/files")
    public String getMessage5(@RequestPart(name = "filez") MultipartFile mf) {
        System.out.println(mf.getOriginalFilename());
        System.out.println(mf.getSize());
        System.out.println();
        return "getMessage5: ";
    }

    //檔案上傳(n個)
    /* http://127.0.0.1:8080/index.html */
    @RequestMapping("/files2")
    public String getMessage6(@RequestPart(name = "filez") List<MultipartFile> mf) {

        for (int i = 0; i < mf.size(); i++) {
            MultipartFile mfs = mf.get(i);
            System.out.println(mfs.getOriginalFilename());
            System.out.println(mfs.getSize());
            System.out.println("----------");
        }
        return "getMessage6: ";
    }

    /*取得(User-Agent)標頭-資訊 Head */
    /* http://127.0.0.1:8080/index2.html */
    @RequestMapping("/head")
    public String getMessage7(@RequestHeader("User-Agent") String ua) {
        System.out.println(ua);
        return "getMessage7:" + ua;
    }

    /*取得(所有)標頭-資訊 Head */
    /* http://127.0.0.1:8080/index2.html */
    @RequestMapping("/head2")
    public String getMessage8(@RequestHeader Map ua) {
        System.out.println(ua);
        return "getMessage8: " + ua;
    }

    /*取得日期 */
    /* http://127.0.0.1:8080/index3.html */
    @RequestMapping("/mydate")
    public String getMessage9(User user, Amt amt) {
        System.out.println(user.getBirthdayA());
        System.out.println(amt.getId() + " " + amt.getMoney());

        return "getMessage9: " + user.getBirthdayA();
    }

    /*
    在post man
    選用:Get
    網址:http://127.0.0.1:8080/handle/getMessageA1
    即可看到200:OK / 201:CREATED

    */
    @RequestMapping("/getMessageA1")
    public ResponseEntity<User> getMessageA1() {
        User user = new User();
        user.setUsername("john");
        user.setPwd("123");
        user.setPwd2("123");
        user.setBirthdayA(null);
        return new ResponseEntity<User>(user , HttpStatus.OK);
        //return new ResponseEntity<User>(user , HttpStatus.CREATED);

    }


    /*
    目的: Value
    http://127.0.0.1:8080/handle/getgj2
    */
    @RequestMapping("/getgj2")
    public void getGJ2() {
        //UseTheValue_Basic v = new UseTheValue_Basic();
        System.out.println(basic.getUsername());
        System.out.println(basic.getPassword());
    }

    /*
    目的: ConfigurationProperties (prefix)
    http://127.0.0.1:8080/handle/getgj
    */

    @RequestMapping("/getgj")
    public void getGJ() {
        System.out.println(hard.getId() + " " + hard.getName());
        System.out.println("-- Hobby");
        hard.getHobby().forEach(x->{
            System.out.println(x);
        });
        System.out.println("-- Food");
        Map m = hard.getFood();
        for(Object key : m.keySet()){
            System.out.println("(key) "+key + " (value) " + m.get(key));
        }
        System.out.println("-- Drink");
        hard.getDrink().forEach(x->{
            System.out.println(x);
        });
        System.out.println("-- Obj");
        for (UseTheValue2_Hard obj2 :hard.getObj2()){
            System.out.println(obj2.getCode() +" " + obj2.getCity() + " " + obj2.getHaveFun());
        }
    }

    @RequestMapping("objlistener")
    public Iterable<User> getGx2(){
        List<User> list = new ArrayList<User>();
        for(int i = 0 ; i < 5 ; i++){
            User u = new User();
            u.setUsername("round_"+i);
            list.add(u);
        }
        return list;
    }

    private final RestTemplate restTemplate = new RestTemplate();
    @RequestMapping("getgx3")
    public ResponseEntity<Iterable<User>> getGJ3()throws Exception{
        ResponseEntity  r = restTemplate.getForEntity("http://127.0.0.1:8080/handle/getgx2", List.class);
        List lists = (List)r.getBody();
        List<User> data = new ArrayList<User>();
        for(Object obj : lists){
            JSONObject json = JSONObject.fromObject(obj);
            User user = new User();
            user.setUsername(json.get("username").toString());
            data.add(user);
        }
        return new ResponseEntity<Iterable<User>>(data , HttpStatus.OK);
    }

    @RequestMapping("items/{isSave}")
    public List<Car> setItems(@PathVariable String isSave){
        return List.of(
                new Car("car1" , "excellent"),
                new Car("car2" , "top")
        );
    }

    /*
    127.0.0.1:8080/handle/save_item
     */
    @RequestMapping("save_item")
    public void saveItems()throws Exception{
        WebClient web = WebClient.create("http://127.0.0.1:8080/handle/items/Y");
        web.
            get().
            retrieve().
            bodyToFlux(Car.class).
            toStream().
            forEach(carRepository ::save);

        List list = carRepository.getAllCarData2("car2" , "top");
        System.out.println(list.size());
        for(int i = 0 ; i < list.size() ; i++){
            Map map = (Map)list.get(i);
            System.out.println(map.get("name")+" "+map.get("type"));
        }



    }


}