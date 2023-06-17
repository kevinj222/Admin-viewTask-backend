package com.Daily.Userview.Controller;

import com.Daily.Userview.Entity.View;
import com.Daily.Userview.Repo.ViewRepo;
import com.Daily.Userview.Service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/admin")
public class ViewController {
    @Autowired
    public ViewService serv;
    @Autowired
    public ViewRepo repo;

    @PostMapping("/add")
    public View getview(@RequestBody View view) {
        return serv.Addusers(view);
    }

    @GetMapping("/getall")
    public List<View> getall() {
        return serv.getallusers();
    }

    @GetMapping("/getuser/{username}")
    public List<View> getuserbyname(@PathVariable String username) {
        return serv.getbyusername(username);
    }

    @GetMapping("/retrieve/{username}")
    public String retrieveById(@PathVariable String username) {
        String name = "";
        List<View> views = repo.findByUsername(username);
        if (!views.isEmpty()) {
            View view = views.get(0);
            name = view.getName();
        }
        return name;
    }

    @DeleteMapping("/{username}/{tasks}")
    public String deleteTaskForUser(@PathVariable String username, @PathVariable String tasks) {
        return serv.deleteTask(username, tasks);
    }

    @GetMapping("/getusers")
    public Set<String> getusersif()
    {
        return serv.getDistinctUsernames();
    }

    //    @PutMapping("/modify/{username}/{tasks}/{deadline}")
//    Public View putuser(@RequestBody View view,@P)
//    {
//        return serv.modify(username)
//    }
    @PatchMapping("/deadlinechange/{username}/{tasks}")
    public View changeDeadline(@PathVariable String username, @PathVariable String tasks, @RequestParam String newDeadline)
    {
        return serv.modify(username,tasks,newDeadline);
    }
}
