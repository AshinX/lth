package com.fy.lth.commands;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableModelBuilder;

import com.fy.lth.common.util.TableUtil;

/**
 * @author fengyue
 * @date 2021/4/15
 */
@ShellComponent
@ShellCommandGroup(value = "maven")
public class MavenCommands {

    @ShellMethod(value = "mvnTable" ,key = {"mvnTable"})
    public Table mvnTable(){
        TableModelBuilder tableModelBuilder = TableUtil.create(null);
        tableModelBuilder.addRow().addValue("mvn package -Dmaven.test.skip=true").addValue("不但跳过单元测试的运行，也跳过测试代码的编译。");
        tableModelBuilder.addRow().addValue("mvn package -DskipTests").addValue("跳过单元测试，但是会继续编译；如果没时间修改单元测试的bug，或者单元测试编译错误。使用上面的，不要用这个");
        return TableUtil.build(tableModelBuilder);
    }
}
