package cn.pompeybrain.business.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @RequestMapping("/list")
    List<Category> list() {
        List<Category> categories = categoryDao.findAll();
        return categories;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    Category create(@RequestBody Category category) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createTime = LocalDateTime.now().format(formatter);
        String updateTime = LocalDateTime.now().format(formatter);
        category.setCreateTime(createTime);
        category.setUpdateTime(updateTime);
        category.setCreateUserId(1); // 模拟当前用户为1
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
        System.out.println(id);
        if (id != category.getId()) {
            category.setId(-1);
            return 0;
        }
        return categoryDao.update(category);
    }

}
