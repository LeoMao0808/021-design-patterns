package org.leo.design.structural.bridge.wrong;

import org.leo.design.structural.bridge.NotificationEmergencyLevel;

import java.util.List;

/**
 * 模块名称: CRM
 * 模块描述: 通知类
 *
 * @author xiaochuang.mao
 * @date 2020/5/28 21:13
 */
public class Notification {
    private List<String> emailAddresses;
    private List<String> telephones;
    private List<String> weChatIds;

    public Notification() {
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public void setWeChatIds(List<String> weChatIds) {
        this.weChatIds = weChatIds;
    }

    public void notify(NotificationEmergencyLevel level, String message) {
        if (level.equals(NotificationEmergencyLevel.SEVERE)) {
            //...自动语音电话
        } else if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            //...发微信
        } else if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            //...发邮件
        } else if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            //...发邮件
        }
    }
}

class Test{
    public static void main(String[] args) {
        new Notification().notify(NotificationEmergencyLevel.NORMAL,"正常！");
    }
}
