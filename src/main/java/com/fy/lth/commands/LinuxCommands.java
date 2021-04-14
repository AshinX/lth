package com.fy.lth.commands;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableModelBuilder;

import com.fy.lth.common.util.TableUtil;

/**
 * @author fengyue
 * @date 2021/4/1
 */
@ShellComponent
@ShellCommandGroup(value = "linux")
public class LinuxCommands {

    @ShellMethod(value = "grepTable 导航", key = {"grepTable"})
    public Table grepTable() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("grep -v 'leo' a.txt").addValue("搜索文件中不包含 leo 字符串的行");
        builder.addRow().addValue("grep 'leo' a.txt").addValue("搜索文件中包含 leo 字符串的行");
        builder.addRow().addValue("grep -i 'leo' a.txt").addValue("搜索文件中包含 leo 字符串的行，并忽略leo的大小写");
        builder.addRow().addValue("grep -e 'a*' a.txt").addValue("搜索文件中搜索匹配a的字符串");
        builder.addRow().addValue("ps -ef | grep 'mysql' ").addValue("查看mysql进程");
        return TableUtil.build(builder);
    }

    @ShellMethod(value = "findTable 导航", key = {"findTable"})
    public Table findTable() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("find / -name '*.txt' ").addValue("查找根目录下所有以.txt结尾的文件");
        builder.addRow().addValue("find /test -perm 644").addValue("查找/test目录下，权限为644的文件");
        builder.addRow().addValue("find . -type f -name 'abc' ").addValue("查找当前目录下所有文件中包含abc字符串的文件");
        return TableUtil.build(builder);
    }

    @ShellMethod(value = "tailTable 导航", key = {"tailTable"})
    public Table tailTable() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("tail a.txt").addValue("查看文件内容，和cat效果一样");
        builder.addRow().addValue("tail -n 2 a.txt ").addValue("显示a.txt最后两行数据");
        builder.addRow().addValue("tail -f a.txt  /   tailf  a.txt").addValue("实时监控a.txt内容");
        builder.addRow().addValue("tail -1000f a.txt").addValue("实时监控a.txt内容(一开始会显示原有文本的末尾1000行)");
        return TableUtil.build(builder);
    }

    @ShellMethod(value = "headTable 导航", key = {"headTable"})
    public Table headTable() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("head -n 2 a.txt").addValue("显示文件的前两行");
        return TableUtil.build(builder);
    }


    @ShellMethod(value = "closeWaitTable 导航", key = {"closeWaitTable"})
    public Table closeWaitTable() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("netstat -n | awk '/^tcp/ {++S[$NF]} END {for(a in S) print a, S[a]}'")
            .addValue("查看close_wait");
        return TableUtil.build(builder);
    }


    @ShellMethod(value = "scoketStatusTable 导航", key = {"scoketStatusTable"})
    public Table scoketStatusTable() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("CLOSED").addValue("没有使用这个套接字[netstat 无法显示closed状态]");
        builder.addRow().addValue("LISTEN").addValue("套接字正在监听连接[调用listen后]");
        builder.addRow().addValue("SYN_SENT").addValue("套接字正在试图主动建立连接[发送SYN后还没有收到ACK]");
        builder.addRow().addValue("SYN_RECEIVED").addValue("正在处于连接的初始同步状态[收到对方的SYN，但还没收到自己发过去的SYN的ACK]");
        builder.addRow().addValue("ESTABLISHED").addValue("连接已建立");
        builder.addRow().addValue("CLOSE_WAIT").addValue("远程套接字已经关闭：正在等待关闭这个套接字[被动关闭的一方收到FIN]");
        builder.addRow().addValue("FIN_WAIT_1").addValue("套接字已关闭，正在关闭连接[发送FIN，没有收到ACK也没有收到FIN]");
        builder.addRow().addValue("CLOSING").addValue("套接字已关闭，远程套接字正在关闭，暂时挂起关闭确认[在FIN_WAIT_1状态下收到被动方的FIN]");
        builder.addRow().addValue("LAST_ACK").addValue("远程套接字已关闭，正在等待本地套接字的关闭确认[被动方在CLOSE_WAIT状态下发送FIN]");
        builder.addRow().addValue("FIN_WAIT_2").addValue("套接字已关闭，正在等待远程套接字关闭[在FIN_WAIT_1状态下收到发过去FIN对应的ACK]");
        builder.addRow().addValue("TIME_WAIT").addValue("这个套接字已经关闭，正在等待远程套接字的关闭传送[FIN、ACK、FIN、ACK都完毕，这是主动方的最后一个状态，在过了2MSL时间后变为CLOSED状态]");
        return TableUtil.build(builder);
    }

    @ShellMethod(value = "crontabTable(定时任务)", key = {"corntabTable"})
    public Table crontabTable() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("crontab -l").addValue("查看当前计划任务");
        builder.addRow().addValue("crontab -e").addValue("创建计划任务"
                                                        + "\n" + "minute(分) hour(小时) day(天) month(月) week(周) command(命令)"
                                                        + "\n" + "* * 1 * *  tar -czvf aa.tar.gz /bb  每天将bb文件夹归档一份");
        return TableUtil.build(builder);
    }





}
