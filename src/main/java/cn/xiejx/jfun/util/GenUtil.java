package cn.xiejx.jfun.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.template.*;
import cn.xiejx.jfun.entity.GenConfig;
import cn.xiejx.jfun.service.vo.ColumnInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.naming.Name;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
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
    private static final String TIMESTAMP = "Timestamp";

    private static final String BIGDECIMAL = "BigDecimal";

    private static final String PK = "PRI";
    
    /*
     * @Author miv
     * @Description 代码生成
     * @Date 22:23 2019-04-07
     * @Param 生成器配置、需要生成的表名称、表的列信息
     * @return void
     */
    public static void generatorCode(GenConfig genConfig, String tableName, List<ColumnInfo> columnInfos) throws IOException {
        //设置配置信息
        Map<String, Object> map = new HashMap();
        map.put("package", genConfig.getPack());
        map.put("tableName", tableName);
        String className = NameUtil.toCapitalizeCamelCase(tableName);
        map.put("className", className);

        map.put("hasTimestamp", false);
        map.put("hasBigDecimal", false);


        List<Map<String, Object>> columns = new ArrayList<>();
        for (ColumnInfo column : columnInfos) {
            Map<String, Object> listMap = new HashMap();
            listMap.put("columnComment", column.getColumnComment());
            listMap.put("columnKey", column.getColumnKey());

            String colType = ColUtil.cloToJava(column.getColumnType().toString());
            if (PK.equals(column.getColumnKey())) {
                map.put("pkColumnType", colType);
            }
            if (TIMESTAMP.equals(colType)) {
                map.put("hasTimestamp", true);
            }
            if (BIGDECIMAL.equals(colType)) {
                map.put("hasBigDecimal", true);
            }
            listMap.put("columnType", colType);
            listMap.put("columnName", column.getColumnName());
            listMap.put("isNullable", column.getIsNullable());
            listMap.put("columnShow", column.getColumnShow());
            listMap.put("changeColumnName", NameUtil.toCamelCase(column.getColumnName().toString()));
            listMap.put("capitalColumnName", NameUtil.toCapitalizeCamelCase(column.getColumnName().toString()));

            if (!StringUtils.isEmpty(column.getColumnQuery())) {
                listMap.put("columnQuery", column.getColumnQuery());
                map.put("hasQuery", true);

            }

            columns.add(listMap);

        }
        map.put("columns", columns);

        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("template", TemplateConfig.ResourceMode.CLASSPATH));
        //生成后台代码
        List<String> templates = getBackTemplateNames();
        for (String templateName : templates) {
            Template template = engine.getTemplate("generator/back/" + templateName + ".ftl");
            String filePath = getBackFilePath(templateName, genConfig, className);
            File file = new File(filePath);

            // 如果非覆盖生成
            if (!genConfig.getCover()) {
                if (FileUtil.exist(file)) {
                    continue;
                }
            }
            // 生成代码
            renderFile(file, template, map);
        }
        //生成前端代码
    }

    public static String getBackFilePath(String templateName, GenConfig genConfig, String className) {
        String ProjectPath = System.getProperty("user.dir"); //genConfig.getModuleName();这里暂时不使用模块,默认在gen目录下生产后端文件
        String packagePath = ProjectPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator;

        log.info("ProjectPath:{}", ProjectPath);
        log.info("packagePath:{}", packagePath);

        if (!ObjectUtils.isEmpty(genConfig.getPack())) {
            packagePath += genConfig.getPack().replace(".", File.separator) + File.separator;
        }
        if ("Entity".equals(templateName)) {
            return packagePath + "entity" + File.separator + className + ".java";
        }

        return null;
    }

    /*
     * @Author miv
     * @Description 获取后端模板文件名称
     * @Date 22:31 2019-04-07
     */
    public static List<String> getBackTemplateNames() {
        List<String> templateNames = new ArrayList<>();
        templateNames.add("Entity");
//        templateNames.add("Mapper");
//        templateNames.add("Controller");
//        templateNames.add("Service");
//        templateNames.add("ServiceImpl");
//        templateNames.add("Dto");
        return templateNames;
    }

    /*
     * @Author miv
     * @Description 获取前端模板文件名称
     * @Date 22:34 2019-04-07
     */
    public static List<String> getFrontTemplateNames() {
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
    public static void renderFile(File file, Template template, Map<String, Object> map) throws IOException {
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
