package org.leo.design.structural.bridge.right.channel;

import java.util.List;

/**
 * 模块名称: CRM
 * 模块描述: 邮件消息发送实现类
 *
 * @author xiaochuang.mao
 * @date 2020/5/28 21:23
 */
public class EmailMsgSender implements MsgSender{
    private List<String> emailAddresses;

    public EmailMsgSender(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    @Override
    public void send(String msg) {
        //发送邮箱消息
    }
}
