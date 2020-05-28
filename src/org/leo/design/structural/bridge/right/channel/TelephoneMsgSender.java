package org.leo.design.structural.bridge.right.channel;

import java.util.List;

/**
 * 模块名称: CRM
 * 模块描述: 手机消息发送实现类
 *
 * @author xiaochuang.mao
 * @date 2020/5/28 21:23
 */
public class TelephoneMsgSender implements MsgSender{
    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String msg) {
        //发送手机消息
    }
}
