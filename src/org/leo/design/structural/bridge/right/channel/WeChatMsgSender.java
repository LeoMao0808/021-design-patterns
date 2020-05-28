package org.leo.design.structural.bridge.right.channel;

import java.util.List;

/**
 * 模块名称: CRM
 * 模块描述: 微信消息发送实现类
 *
 * @author xiaochuang.mao
 * @date 2020/5/28 21:23
 */
public class WeChatMsgSender implements MsgSender{
    private List<String> weChatIds;

    public WeChatMsgSender(List<String> weChatIds) {
        this.weChatIds = weChatIds;
    }

    @Override
    public void send(String msg) {
        //发送微信消息
    }
}
