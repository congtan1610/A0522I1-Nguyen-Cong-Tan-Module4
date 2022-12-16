package Translation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class TranSlationController {
    private static ArrayList<String> arr;
    static {
        arr=new ArrayList<>();
        arr.add("one");
        arr.add("một");
    }
    @GetMapping("/home")
    public String getTrans(Model model , @RequestParam(value = "e",required = false) String e){
        String a=" ";
        for (int i=0;i<arr.size();i++){
            if (arr.get(i).equals(e)){
                a=arr.get(i+1);
            }
        }
        model.addAttribute("e",e);
        model.addAttribute("v",e !=null?a:null);
        return "/home";
    }
}
