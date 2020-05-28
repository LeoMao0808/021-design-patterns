package org.leo.design.structural.bridge.right.level;

import org.leo.design.structural.bridge.right.channel.MsgSender;

/**
 * 模块名称: CRM
 * 模块描述: 通知抽象类
 *
 * @author xiaochuang.mao
 * @date 2020/5/28 21:32
 */
public abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);
}
