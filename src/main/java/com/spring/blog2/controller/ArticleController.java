package com.spring.blog2.controller;

import com.spring.blog2.config.ImgConfig;
import com.spring.blog2.obj.Article;
import com.spring.blog2.obj.Category;
import com.spring.blog2.obj.Message;
import com.spring.blog2.service.ArticleService;
import com.spring.blog2.service.CategoryService;
import com.spring.blog2.util.TimeUtil;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ImgConfig imgConfig;

    @Resource
    private CategoryService categoryService;

    @Resource
    private ArticleService articleService;

    private final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @GetMapping("/see/{id}")
    public ModelAndView singleArticle(@PathVariable("id") String i, ModelAndView modelAndView) {
        long id = Long.parseLong(i);
        Article article = articleService.findById(id);
        article.setShortTime(TimeUtil.getShortTime(article.getCreatetime()));
        LOGGER.info("------see article--------" + article.toString() + "-----------------");
        modelAndView.addObject("article", article);
        modelAndView.setViewName("singlearticle");
        return modelAndView;
    }

    @PostMapping("/add")
    @ResponseBody
    public Message addArticle(@RequestBody Article article) {
        LOGGER.info("---------------添加文章:" + article.getTitle() + "---------------");
        LOGGER.info("----------------" + article + "---------------------------");
        LOGGER.info("----------------添加文章:" + article.toString() + "------------------------");
        article.setCreatetime(new Date());
        article.setAuthorId(1L);
        article.setAuthorName("yoke");
        if (articleService.insert(article) == 1) {
            return new Message(0, "success", "success");
        } else {
            return new Message(1, "false", "false");
        }
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(HttpServletRequest request, @Param("file") MultipartFile file) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String res = sdf.format(new Date());
        String uuid = java.util.UUID.randomUUID().toString(); //采用uui方式随机命名

//        String rootpath = "/uploa;
        String originalFilename = file.getOriginalFilename();
        String newFileName = uuid + originalFilename.substring(originalFilename.lastIndexOf("."));
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR)
                + File.separator + (date.get(Calendar.MONTH) + 1));
        File newFile = new File(imgConfig.getSaveLocation() + File.separator + newFileName);
        LOGGER.info("img store location : {}.", newFile.getAbsolutePath());
        //判断目标文件所在的目录是否存在
        if (!newFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        System.out.println(newFile);
        try {
            file.transferTo(newFile);
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }
        //完整的url
        String fileUrl = "/upload/" + newFileName;
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map.put("code", 0);//0表示成功，1失败
        map.put("msg", "上传成功");//提示消息
        map.put("data", map2);
        map2.put("src", fileUrl);//图片url
        map2.put("title", newFileName);//图片名称，这个会显示在输入框里
        return new JSONObject(map).toString();
    }

    @GetMapping("/findarticles/{id}")
    public ModelAndView findArticlesByCategory(@PathVariable("id") Long id, ModelAndView modelAndView) {
        List<Category> categorylist = categoryService.list();
        modelAndView.addObject("categorylist", categorylist);
        modelAndView.setViewName("categoryAndArticles");
//        return modelAndView.addObject("list", articleService.listCategoryArticle(id));
        List<Article> list = articleService.listCategoryArticle(id);
        modelAndView.addObject("list", list);
        return modelAndView;
    }
}
