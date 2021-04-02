package com.fy.lth.commands;

import com.fy.lth.common.ChinesSizeConstraints;
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
public class LinuxCommands {

    @ShellMethod("查找关键字")
    public Table grep() {
        TableModelBuilder builder = new TableModelBuilder<String>();
        builder.addValue("grep -v \"leo\" /etc/passwd").addValue("搜索不包含 leo 字符串的行").addValue(" ");

        TableModel tableModel = builder.build();
        TableBuilder tableBuilder = new TableBuilder(tableModel);
        tableBuilder.on(CellMatchers.table()).addSizer(new ChinesSizeConstraints()).and();
        return tableBuilder.addFullBorder(BorderStyle.fancy_light_triple_dash).build();
    }
}
