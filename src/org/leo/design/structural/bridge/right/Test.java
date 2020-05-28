package org.leo.design.structural.bridge.right;

import org.leo.design.structural.bridge.right.channel.WeChatMsgSender;
import org.leo.design.structural.bridge.right.level.SevereNotification;

import java.util.Arrays;

/**
 * 模块名称: CRM
 * 模块描述: 测试
 *
 * 不同渠道的发送逻辑剥离出来，形成独立的消息发送类（MsgSender 相关类）。
 * 其中，Notification 类相当于抽象，MsgSender 类相当于实现，两者可以独立开发，
 * 通过组合关系（也就是桥梁）任意组合在一起。所谓任意组合的意思就是，
 * 不同紧急程度的消息和发送渠道之间的对应关系，不是在代码中固定写死的，
 * 我们可以动态地去指定（比如，通过读取配置来获取对应关系）。
 * @author xiaochuang.mao
 * @date 2020/5/28 21:38
 */
public class Test {
    public static void main(String[] args) {
        SevereNotification severeNotification = new SevereNotification(new WeChatMsgSender(Arrays.asList("123","456")));
        severeNotification.notify("严重警告");
    }
}
