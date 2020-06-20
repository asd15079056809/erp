package com.bdqn.erp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Code {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("F:\\Program_Files\\java\\ideaworkspace\\erp"+ "/src/main/java");
        gc.setAuthor("熊伟");
        gc.setOpen(false);
        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        gc.setIdType(IdType.ASSIGN_ID);//雪花算法
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.43.227:3306/erp?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("erp");
        pc.setParent("com.bdqn");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//驼峰策略,不照搬
        strategy.setRestControllerStyle(true);
        // 公共父类
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude("sys_dept");
        strategy.setControllerMappingHyphenStyle(true);//url中驼峰连接符
        strategy.setTablePrefix("sys" + "_");//去掉表别名，表前缀
        strategy.setEntityLombokModel(true);//实体使用lombok
        strategy.setRestControllerStyle(true); //restful api风格控制器
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
