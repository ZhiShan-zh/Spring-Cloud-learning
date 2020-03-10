package thymeleafspringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thymeleafspringboot.entity.Student;
import thymeleafspringboot.entity.User;

@Controller
@RequestMapping("/index")
public class IndexHandler {

    @GetMapping("/index")
    public String index(Model model){
        System.out.println("index...");
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(1, "张三", 15));
        list.add(new Student(2, "李四", 16));
        list.add(new Student(3, "王五", 17));
        model.addAttribute("list",list);
        return "index";
    }
    @GetMapping("/validator")
    public void validatorUser(@Valid User user,BindingResult bindingResult){
      System.out.println(user);
      if(bindingResult.hasErrors()){
        List<ObjectError> list = bindingResult.getAllErrors();
        for(ObjectError objectError:list){
          System.out.println(objectError.getCode()+"-"+objectError.getDefaultMessage());
        }
      }
    }
}
