package cn.pompeybrain.business.category;

import cn.pompeybrain.business.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
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
    List<String> getAvailable() {
        List<String> categories = categoryDao.findAvailable();
        return categories;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    Map<String, List> list() {
        List<Category> rawRategories = categoryDao.findAll();
        Map<String, List> result = new HashMap<>();
        List<Category> availables = new ArrayList<>();
        List<Category> unavailables = new ArrayList<>();
        for (Category category : rawRategories) {
            if (category.isAvailable()) {
                availables.add(category);
            } else {
                unavailables.add(category);
            }
        }
        result.put("availables", availables);
        result.put("unavailables", unavailables);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    Category create(@RequestBody Category category) {
        BaseUtil.setCommon(category);
        categoryDao.add(category);
        return category;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Category get(@PathVariable int id) {
        return categoryDao.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    int delete(@PathVariable int id) {
        return categoryDao.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    int update(@PathVariable int id, @RequestBody Category category) {
        if (!BaseUtil.checkId(id, category))
            return 0;
        return categoryDao.update(category);
    }


}
