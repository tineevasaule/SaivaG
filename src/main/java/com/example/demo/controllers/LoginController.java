package com.example.demo.controllers;

import com.example.demo.configuration.MvcConf;
import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.models.User;
import com.example.demo.models.Role;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(MvcConf.class);

    @Autowired
    private ProductRepository productRepository;
 @Autowired
 private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;   }

        @RequestMapping(value={"/"}, method = RequestMethod.GET)
        public ModelAndView welcome() {
            log.info("Called  welcome method");
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("prods", productRepository.findAll());
            modelAndView.addObject("titles","");
            modelAndView.setViewName("welcome");

            return modelAndView;
        }
    @RequestMapping(value={"/poisk"}, method = RequestMethod.GET)
    public ModelAndView poisk() {

        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
//@RequestMapping("/register")
//public ModelAndView registrform(ModelAndView modelAndView) {
//    modelAndView.setViewName("register");
//    modelAndView.addObject("user", new User());
//    return modelAndView;
//}
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String register(@ModelAttribute User user) {
//        user.setActive(1);
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        Set<Role> roles = new HashSet<>();
////        roles.add(roleRepository.findByName("CLIENT"));
//        user.setRoles(roles);
//        userRepository.save(user);
//        return "redirect:/login";
//    }
@GetMapping("/registration")
public String registration(){
    return "registration";
}

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepository.findByUsername(user.getUserName());

        //Сообщаем если такой пользователь есть в базе данных
        if (userFromDb != null){
            model.put("message", "Данное имя пользователя не доступно!");
            return "registration";
        }

        user.setActive(true);
        //На вход ожидается коллекция в виде Set,
        //но так как у нас всего одно значение мы можем
        //использовать шорткат, из стандартной библиотеки,
        //который создает set с одним единственным значением
        user.setRoles(Collections.singleton(Role.ADMIN));
        userRepository.save(user);
        return "redirect:/login";
    }
    @RequestMapping(value="/product/registr", method = RequestMethod.GET)
    public ModelAndView registr(){
        ModelAndView modelAndView = new ModelAndView();
        Product product= new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("product/registr");
        return  modelAndView;
    }
    @RequestMapping(value="/product/vhod", method = RequestMethod.GET)
    public ModelAndView vhod(){
        ModelAndView modelAndView = new ModelAndView();
        Product product= new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("product/vhod");
        return  modelAndView;
    }
    @RequestMapping(value="/product/kont", method = RequestMethod.GET)
    public ModelAndView kont(){
        ModelAndView modelAndView = new ModelAndView();
        Product product= new Product();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("product/kont");
        return  modelAndView;
    }

}


