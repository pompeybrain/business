package cn.pompeybrain.business.util;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 一些杂乱的接口
 * Created by pompey on 2017/5/25.
 */
@RequestMapping("/util")
public class UtilController {
    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public String noLogin() {
        return "notLogin";
    }

    @RequestMapping(value = "/authorityError", method = RequestMethod.GET)
    public String authorityError() {
        return "authorityError";
    }
}
