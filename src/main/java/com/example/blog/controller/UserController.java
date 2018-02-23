package com.example.blog.controller;

import com.example.blog.entity.User;
import com.example.blog.util.ResultMessage;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    public static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        ArrayList<User> list = new ArrayList(users.values());
        return list;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultMessage postUser(@ModelAttribute User user){
        users.put(user.getId(), user);
        return ResultMessage.Success;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id){
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResultMessage putUser(@PathVariable int id, @ModelAttribute User user){
        User u = users.get(id);
        u.setAge(user.getAge());
        u.setId(user.getId());
        u.setName(user.getName());
        return ResultMessage.Success;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultMessage deleteUser(@PathVariable int id){
        users.remove(id);
        return ResultMessage.Success;
    }
}
