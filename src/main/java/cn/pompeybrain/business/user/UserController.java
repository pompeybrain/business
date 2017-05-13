package cn.pompeybrain.business.user;

import cn.pompeybrain.business.category.Category;
import cn.pompeybrain.business.commodity.Commodity;
import cn.pompeybrain.business.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户接口
 * Created by Administrator on 2017/5/12 0012.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    Map<String, List> list() {
        List<User> rawUsers = userDao.findAll();
        Map<String, List> result = new HashMap<>();
        List<User> availables = new ArrayList<>();
        List<User> unavailables = new ArrayList<>();
        for (User user : rawUsers) {
            if (user.isStatus()) {
                availables.add(user);
            } else {
                unavailables.add(user);
            }
        }
        result.put("availables", availables);
        result.put("unavailables", unavailables);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    int create(@RequestBody User user) {
        userDao.add(user);
        return user.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User update(@PathVariable int id) {
        return userDao.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    int update(@PathVariable int id, @RequestBody User user) {
        if (!BaseUtil.checkId(id, user))
            return 0;
        return userDao.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    int delete(@PathVariable int id) {
        return userDao.delete(id);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    int login(@RequestBody Map<String, String> loginForm, HttpSession session) {
        String userName = loginForm.get("name");
        String passwordDigest = loginForm.get("password");
        String role = loginForm.get("role");
        User user = userDao.findByNameAndPassword(userName, passwordDigest);
        if (user != null && user.getRole() == Integer.parseInt(role)) {
            session.setAttribute("userId", user.getId());
            session.setAttribute("user", userName);
            session.setAttribute("role", role);
            return user.getId();
        }
        return 0;
    }
}
