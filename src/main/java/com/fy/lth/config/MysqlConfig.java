package com.fy.lth.config;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.CellMatchers;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;
import org.springframework.shell.table.TableModelBuilder;

import com.fy.lth.common.ChinesSizeConstraints;

/**
 * @author fengyue
 * @date 2021/4/8
 */
@ShellComponent
@ShellCommandGroup(value = "mysqlconfig")
public class MysqlConfig {

    @ShellMethod(value = "mysqlConfigTable 导航", key = {"mysqlConfigTable"})
    public Table mysqlConfigTable() {
        TableModelBuilder builder = new TableModelBuilder<String>();
        builder.addRow().addValue("config params").addValue("explain");
        builder.addRow().addValue("innodb_read_io_threads =4").addValue("io读线程数");
        builder.addRow().addValue("innodb_write_io_threads = 4").addValue("io写线程数");
        builder.addRow().addValue("innodb_purge_threads = 1").addValue("purge线程用来回收事物提交后用不到的undo.log页");
        builder.addRow().addValue("innodb_buffer_pool_size").addValue("设置数据库缓冲池大小");
        builder.addRow().addValue("innodb_buffer_pool_instance").addValue("设置数据库缓冲池实例个数");

        builder.addRow().addValue("innodb_old_blocks_pct").addValue("将新读取到的页放置在整个lru列表的百分比位置（midpoint）。以此点将lru列表分为热点/非热点数据");
        builder.addRow().addValue("innodb_old_blocks_time").addValue("表示页读取到midpoint位置后需要等待多久才转化为热点数据");
        builder.addRow().addValue("innodb_log_buffer_size = 8M").addValue("重做日志redolog缓冲大小");

        builder.addRow().addValue("max_binlog_size").addValue("单个binlog文件最大大小");
        builder.addRow().addValue("binlog_cache_size").addValue("记录未提交的二进制日志缓存大小");
        builder.addRow().addValue("sync_binlog").addValue("缓存日志是否同步写");




        TableModel tableModel = builder.build();
        TableBuilder tableBuilder = new TableBuilder(tableModel);
        tableBuilder.on(CellMatchers.table()).addSizer(new ChinesSizeConstraints()).and();
        return tableBuilder.addFullBorder(BorderStyle.fancy_light).build();
    }


}
