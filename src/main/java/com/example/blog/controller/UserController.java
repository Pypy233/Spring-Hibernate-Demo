package com.example.blog.controller;

import com.example.blog.entity.User;
import com.example.blog.util.ResultMessage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    public static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        ArrayList<User> list = new ArrayList(users.values());
        return list;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultMessage postUser(@ModelAttribute User user){
        users.put(user.getId(), user);
        return ResultMessage.Success;
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id){
        return users.get(id);
    }



    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "")
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
