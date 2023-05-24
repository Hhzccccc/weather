package com.shawnliang.weather;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.val;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/9/13
 */
public class CodeGenerator {

    public static void main(String[] args) throws IOException {
        val codeGenerator = new CodeGenerator();
        codeGenerator.autoGen();
    }

    public void autoGen() throws IOException {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        File f = new File(this.getClass().getResource("").getPath());
        String s = URLDecoder.decode(f.getPath(), "UTF-8");
        String absPath = StringUtils.substringBefore(s, System.getProperty("file.separator")+ "target");
        gc.setOutputDir(absPath + "/src/main/java")
                .setAuthor(StringUtils.defaultIfBlank(System.getProperty("user.name"), "admin")).
                setIdType(IdType.AUTO)
                .setBaseResultMap(true)
                .setOpen(false)
                .setServiceImplName("%sDoRepository")
                .setEntityName("%sDo")
        ;
        mpg.setGlobalConfig(gc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("weather_market")
                .setParent("com.shawnliang.weather.dao")
                .setMapper("mapper")
                .setEntity("entity")
                .setServiceImpl("repository")
                .setController("")
                .setService("")
                .setXml("")
        ;
        mpg.setPackageInfo(pc);

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";

        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return absPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        String repoPath = "/vm/repositoryImpl.java.vm";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(repoPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String path= absPath + "/src/main/java/" + pc.getParent().replace(".", "/")
                        + "/" + pc.getServiceImpl()
                        + "/" + tableInfo.getEntityName() + "Repository" + StringPool.DOT_JAVA;
                System.out.println(path);
                return path;
            }
        });

        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        injectionConfig.setFileCreate((configBuilder, fileType, filePath) ->{
                    if (fileType == FileType.CONTROLLER) {
                        return false;
                    } else if (fileType == FileType.SERVICE) {
                        return false;
                    } else if (fileType == FileType.SERVICE_IMPL) {
                        return false;
                    } else if (fileType == FileType.XML) {
                        return false;
                    }
                 else if (fileType == FileType.MAPPER) {
                     // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                     return !new File(filePath).exists();
                 }
                    return true;
                }
        );

        injectionConfig.setFileOutConfigList(focList);
        mpg.setCfg(injectionConfig);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://159.75.25.120:3306/market_weather?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("1s8d!Api42&23");
        mpg.setDataSource(dsc);



        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setEntityBuilderModel(true);
        strategy.setInclude("user_log");
        mpg.setStrategy(strategy);

        mpg.execute();
    }


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入").append(tip).append("：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

}
