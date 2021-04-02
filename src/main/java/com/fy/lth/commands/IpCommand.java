package com.fy.lth.commands;

import com.fy.lth.common.util.ClipboardUtils;
import com.fy.lth.common.util.IpUtils;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author fengyue
 * @date 2021/4/1
 */
@ShellComponent
@ShellCommandGroup(value = "ip")
public class IpCommand {

    @ShellMethod(value = "获取本机ip地址信息")
    public String ip() {
        String ip = IpUtils.getIpAddress();
        String formatStr = String.format(ClipboardUtils.CLIPBOARD_TEXT,ip+" ");
        ClipboardUtils.setClipboardString(ip);
        return formatStr;
    }
}
