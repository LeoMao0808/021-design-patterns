package org.leo.design.structural.bridge.right.level;

import org.leo.design.structural.bridge.right.channel.MsgSender;

/**
 * 模块名称: CRM
 * 模块描述: 严重级别通知
 *
 * @author xiaochuang.mao
 * @date 2020/5/28 21:34
 */
public class SevereNotification extends Notification{

    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
