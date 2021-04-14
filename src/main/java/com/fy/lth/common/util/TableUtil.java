package com.fy.lth.common.util;

import java.util.List;
import java.util.Objects;

import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.CellMatchers;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;
import org.springframework.shell.table.TableModelBuilder;
import org.springframework.util.CollectionUtils;

import com.fy.lth.common.ChinesSizeConstraints;

/**
 * @author fengyue
 * @date 2021/4/14
 */
public class TableUtil {

    public static Table build(TableModelBuilder builder){
        TableModel tableModel = builder.build();
        TableBuilder tableBuilder = new TableBuilder(tableModel);
        tableBuilder.on(CellMatchers.table()).addSizer(new ChinesSizeConstraints()).and();
        return tableBuilder.addFullBorder(BorderStyle.fancy_light).build();
    }


    public static TableModelBuilder create(List<String> args){
        TableModelBuilder builder = new TableModelBuilder<String>();
        if(CollectionUtils.isEmpty(args) || Objects.isNull(args)){
            builder.addRow().addValue("---------------command---------------").addValue("---------------explain---------------");
            return builder;
        }
        for (String arg : args) {
            builder.addRow().addValue("---------------"+arg+"---------------");
        }
        return builder;
    }
}
