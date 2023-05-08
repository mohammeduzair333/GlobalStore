package com.ltp.globalsuperstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class Store {

    List<Item>li=new ArrayList<Item>();
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id){
        Item item;
        if(findById(id)==-1000){
            item=new Item();
        }
        else{
            item=li.get(findById(id));
        }
        model.addAttribute("item",item);
        model.addAttribute("categories",Constants.CATEGORIES);
        return"form";
    }
    @GetMapping("/inventory")
    public String getInventory(Model model){
        model.addAttribute("item",li);
        return"inventory";
    }
    @PostMapping("/handlesubmit")
    public String submit(Item item,RedirectAttributes redirectAttributes  ){
        int index=findById(item.getId());
        String status=Constants.SUCCESS_STATUS;
        if(index==-1000) {
            li.add(item);
        }
        else if(within5Days(item.getDate(),li.get(index).getDate())){
            li.set(index,item);
        }
        else{
            status=Constants.FAILED_STATUS;
        }
        redirectAttributes.addFlashAttribute("status",status);
        return "redirect:/inventory";
    }

    public Integer findById(String id){
      for(int i=0;i< li.size();i++){
          if(li.get(i).getId().equals(id)){
              return i;
          }
      }
      return Constants.Not_Found;
    }
    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }



}
