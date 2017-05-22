package com.sharetest.shareutils;

/**
 * 规则实体类
 * Created by HuJiaCheng on 2017/5/16.
 */

public class RuleInfo {

    private String  ruleName;//规则名
    private Integer ruleId;  //规则绑定Id

    public RuleInfo() {}

    public RuleInfo(String ruleName, Integer ruleId) {
        this.ruleName = ruleName;
        this.ruleId = ruleId;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "ruleName='" + ruleName + '\'' +
                ", ruleId=" + ruleId +
                '}';
    }

    public String getRuleName() {
        return ruleName;
    }

    public RuleInfo setRuleName(String ruleName) {
        this.ruleName = ruleName;
        return this;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public RuleInfo setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
        return this;
    }
}
