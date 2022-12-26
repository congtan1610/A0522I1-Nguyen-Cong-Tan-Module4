package translation;

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
    public String getTrans(Model model , @RequestParam(value = "english",required = false) String english){
        String tmp=" ";
        for (int i=0;i<arr.size();i++){
            if (arr.get(i).equals(english)){
                tmp=arr.get(i+1);
            }
        }
        model.addAttribute("english",english);
        model.addAttribute("vietnamese",english !=null?tmp:null);
        return "/home";
    }
}
