package com.saurabh.BootJpa.controller;
import com.saurabh.BootJpa.dao.AlienRepo;
import com.saurabh.BootJpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepo alienRepo;

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

//    @RequestMapping("/addAlien")
//    public ModelAndView addAlien(Alien alien){
//        ModelAndView mv =  new ModelAndView("home.jsp");
//        alienRepo.save(alien);
//        return mv;
//    }

    @PostMapping(path = "/aliens",consumes = {"application/json"})
    public Alien addAlien(@RequestBody Alien alien){
        alienRepo.save(alien);
        return alien;
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        ModelAndView mv =  new ModelAndView("getAlien.jsp");
        Alien alien = alienRepo.findById(aid).orElse(new Alien());
        System.out.println(alienRepo.findByLang("Java"));
        System.out.println(alienRepo.findByAidGreaterThan(0));
        mv.addObject(alien);
        return mv;
    }

    @GetMapping(path="/aliens")
    @ResponseBody
    public List<Alien> getAlien(){
       return alienRepo.findAll();
    }

    @GetMapping("/aliens/{aid}")
    @ResponseBody
    public Optional<Alien> getAlienById(@PathVariable("aid") int aid){
        return alienRepo.findById(aid);
    }
}
