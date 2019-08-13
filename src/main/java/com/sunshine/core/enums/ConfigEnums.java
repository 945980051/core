/**
 * 
 */
package com.health.core.enums;

/**
 * @author 张梓枫
 * @Description
 * @date:   2019年1月13日 下午5:44:16
 */
public interface ConfigEnums {

    public enum AccountStatusEnum {

        ENABLE(0, "启用"),
        DISABLE(1, "禁用");
        private int value;
        private String name;

        private AccountStatusEnum(int value, String name) {
            this.value = value;
            this.name = name;
        }

       public int getValue() {
           return this.value;
       }
       

       public String getName() {
           return this.name;
       }
        
    }
    
    public enum AccountTypeEnum {

        BACKGROUND_MANAGEMENT(1, "后台管理用户"),
        DEALER(2, "经销商用户"),
        MANUFACTURER(3, "厂家用户"),
        MEMBER(4, "会员用户"),
        HEALTHGATEKEEPER(5, "健管师"),
        KNOWLEDGEMANAGEMENT(6, "知识管理工作站"),
        OPERATIONSMANAGEMENT(7, "运营管理工作站"),
        ASKMEMBERS(8,"问问会员");

        private int value;
        private String name;

        private AccountTypeEnum(int value, String name) {
            this.value = value;
            this.name = name;
        }

       public int getValue() {
           return this.value;
       }
       

       public String getName() {
           return this.name;
       }
       
    }
    
    public enum DeleteFlagEnum {

        UN_DELETED(0, "未删除"),
        DELETED(1, "已删除");
        private int value;
        private String name;

        private DeleteFlagEnum(int value, String name) {
            this.value = value;
            this.name = name;
        }
        
        public int getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }
    
    public enum Gender {

        MAN(0,"男"),
        WOMAN(1,"女");
        
        private int code;
        private String name;
        
        public int getCode() {
            return code;
        }
        public String getName() {
            return name;
        }
        private Gender(int code, String name) {
            this.code = code;
            this.name = name;
        }
        
        // 普通方法
        public static String getName(int index) {
            for (Gender c : Gender.values()) {
                if (c.getCode() == index) {
                    return c.name;
                }
            }
            return null;
        }

    }
    
    public enum SmsContantEnum {

        SMS_LOGIN(1, "短信验证码登录"),
        REGISTER(2, "注册"),
        CHANGE_PHONE(3, "变更联系方式"),
        OTHER(9, "其他");

        private int value;
        private String name;

        private SmsContantEnum(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return this.value;
        }


        public String getName() {
            return this.name;
        }

    }
}
