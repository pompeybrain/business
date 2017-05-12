package cn.pompeybrain.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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

    @RequestMapping(method = RequestMethod.POST)
    int create(@RequestBody User user) {
        userDao.add(user);
        return user.getId();
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
