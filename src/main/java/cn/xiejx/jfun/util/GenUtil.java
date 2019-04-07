package cn.xiejx.jfun.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.template.*;
import cn.xiejx.jfun.entity.GenConfig;
import cn.xiejx.jfun.service.vo.ColumnInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: miv
 * @Date: 2019-04-07 22:05
 * @Web: www.xiejx.cn
 * @Email: 787824374@qq.com
 * @Description: 代码生成器
 */
@Slf4j
public class GenUtil {

    /*
     * @Author miv
     * @Description 代码生成
     * @Date 22:23 2019-04-07
     * @Param 生成器配置、需要生成的表名称、表的列信息
     * @return void
     */
    public static void generatorCode(GenConfig genConfig, String tableName, List<ColumnInfo> columnInfos) {
        //设置配置信息


        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("template", TemplateConfig.ResourceMode.CLASSPATH));

        //生成前端代码

        //生成后台代码
    }
    public static String getBackFilePath(String templateName,GenConfig genConfig,String className){

        return null;
    }
    /*
     * @Author miv
     * @Description 获取后端模板文件名称
     * @Date 22:31 2019-04-07
     */
    public static List<String> getBackTemplateNames(){
        List<String> templateNames = new ArrayList<>();
        templateNames.add("Entity");
        templateNames.add("Mapper");
        templateNames.add("Controller");
        templateNames.add("Service");
        templateNames.add("ServiceImpl");
        templateNames.add("Dto");
        return templateNames;
    }
    /*
     * @Author miv
     * @Description 获取前端模板文件名称
     * @Date 22:34 2019-04-07
     */
    public static List<String> getFrontTemplateNames(){
        List<String> templateNames = new ArrayList<>();
        templateNames.add("api");
        templateNames.add("index");
        templateNames.add("header");
        templateNames.add("edit");
        templateNames.add("eForm");
        return templateNames;
    }
    /*
     * @Author miv
     * @Description 渲染生成模板文件
     * @Date 22:34 2019-04-07
     */
    public static void genFile(File file, Template template, Map<String,Object> map) throws IOException {
        // 生成目标文件
        Writer writer = null;
        try {
            FileUtil.touch(file);
            writer = new FileWriter(file);
            template.render(map, writer);//渲染生成
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
    }
}
