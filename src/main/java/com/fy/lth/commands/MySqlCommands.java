package com.fy.lth.commands;

import com.fy.lth.common.ChinesSizeConstraints;
import com.fy.lth.common.util.TableUtil;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.*;

@ShellComponent
@ShellCommandGroup(value = "mysql")
public class MySqlCommands {


    @ShellMethod(value = "数据库日志配置", key = {"mysqlLogLookTable"})
    public Table mysqlLogLookTable() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("show VARIABLES LIKE 'log_error'").addValue("查找mysql错误日志路径");
        builder.addRow().addValue("show VARIABLES LIKE 'log_slow_queries  =  ON'").addValue("查看是否打开慢日志");
        builder.addRow().addValue("show VARIABLES LIKE 'long_query_time'").addValue("慢日志的时间（记录执行大于此时间的sql）");
        builder.addRow().addValue("show VARIABLES LIKE 'long_queries_not_using_indexes  =  ON'").addValue("（记录没有使用索引的sql语句）");
        builder.addRow().addValue("show VARIABLES LIKE 'long_throttle_queries_not_using_indexes  =  0'").addValue("每分钟允许记录没有使用索引的sql语句的条数，" +
                "0表示不限制，主要用来防止慢日志过大");
        builder.addRow().addValue("mysqldumpslow -s al -n 10  xxx.log").addValue("获取执行时间最长的10条sql");
        builder.addRow().addValue("show VARIABLES LIKE 'datadir'").addValue("查询binlog日志存储位置");

        TableModel tableModel = builder.build();
        TableBuilder tableBuilder = new TableBuilder(tableModel);
        tableBuilder.on(CellMatchers.table()).addSizer(new ChinesSizeConstraints()).and();
        return tableBuilder.addFullBorder(BorderStyle.fancy_light).build();
    }

}
