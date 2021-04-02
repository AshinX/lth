package com.fy.lth.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author fengyue
 * @date 2021/4/1
 */
@ShellComponent
public class LinuxCommands {

    @ShellMethod("查找关键字")
    public void grep() {
        System.out.println("grep -v \"leo\" /etc/passwd   搜索不包含 leo 字符串的行");
    }
}
