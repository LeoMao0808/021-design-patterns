package org.leo.design.structural.bridge.right.level;

import org.leo.design.structural.bridge.right.channel.MsgSender;

/**
 * 模块名称: CRM
 * 模块描述: 正常通知
 *
 * @author xiaochuang.mao
 * @date 2020/5/28 21:34
 */
public class NormalNotification extends Notification{

    public NormalNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
