package cn.pompeybrain.business.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * category外部接口
 * Created by Administrator on 2017/5/10 0010.
 */

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryDao categoryDao;

    @RequestMapping("/available")
    String[] getAvailable() {
        String[] categories = categoryDao.findAvailable();
        return categories;
    }

    @RequestMapping("/list")
    List<Category> list() {
        List<Category> categories = categoryDao.findAll();
        return categories;
    }

}
