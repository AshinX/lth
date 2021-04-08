package com.fy.lth.commands;

import com.fy.lth.common.ChinesSizeConstraints;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.CellMatchers;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;
import org.springframework.shell.table.TableModelBuilder;

/**
 * @author fengyue
 * @date 2021/4/1
 */
@ShellComponent
@ShellCommandGroup(value = "linux")
public class LinuxCommands {

    @ShellMethod(value = "grepTable 导航", key = {"grepTable"})
    public Table grepTable() {
        TableModelBuilder builder = new TableModelBuilder<String>();
        builder.addRow().addValue("command  ").addValue("explain  ");
        builder.addRow().addValue("grep -v \"leo\"  file").addValue("搜索file中不包含 leo 字符串的行");
        //builder.addRow().addValue(" Summary JVM monitoring").addValue(" ").addValue("https://www.cnblogs.com/wxisme/p/9878494.html");
        //builder.addRow().addValue(" jps -l").addValue("jps -l -v").addValue("查看java进程");
        //builder.addRow().addValue("jstat -gcutil pid 1000 3(3 times every 1s)").addValue("percentage used (man jstat)").addValue("https://blog.csdn.net/fenglibing/article/details/6321453 ");
        //builder.addRow().addValue("jstat -gc pid 1000 3").addValue("actual value ").addValue("https://www.iteye.com/blog/bijian1013-2221351");
        //builder.addRow().addValue("jstack -l pid").addValue("thread snapshot,deadlock,loop").addValue("http://www.hollischuang.com/archives/110");
        //builder.addRow().addValue("jstack -l -F  pid").addValue("").addValue("to force a thread dump");
        //builder.addRow().addValue("jstack -l -m  pid").addValue(" ").addValue("to print both java and native frames (mixed mode)");
        //builder.addRow().addValue("jmap -dump:live,format=b,file=/tmp/livedump.hprof pid").addValue("").addValue("https://www.jianshu.com/p/a4ad53179df3");
        //builder.addRow().addValue("jmap -dump:format=b,file=/tmp/dump.hprof pid").addValue("").addValue(" ");
        //builder.addRow().addValue("jmap -heap pid").addValue("memory usage information of each memory area").addValue("内存占用统计");
        //builder.addRow().addValue("jmap -histo:live pid").addValue("show statistics for objects in the heap").addValue("活着对象统计");
        //builder.addRow().addValue("jmap -clstats pid").addValue("to print class loader statistics").addValue("类加载器信息");
        //builder.addRow().addValue("jmap -finalizerinfo pid").addValue("print information on objects awaiting finalization").addValue("等待终结的对象");
        TableModel tableModel = builder.build();
        TableBuilder tableBuilder = new TableBuilder(tableModel);
        tableBuilder.on(CellMatchers.table()).addSizer(new ChinesSizeConstraints()).and();
        return tableBuilder.addFullBorder(BorderStyle.fancy_light).build();
    }
}
