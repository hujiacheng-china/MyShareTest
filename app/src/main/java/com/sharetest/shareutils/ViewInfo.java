package com.sharetest.shareutils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuJiaCheng on 2017/5/15.
 */

public class ViewInfo {
    //View Id
    private Integer viewId = -2;
    //view类型
    private String viewType;
    //子view集合
    private List<ViewInfo> childViews = new ArrayList<>();

    //宽高：MATCH_PARENT = -1，WRAP_CONTENT = -2
    private Integer width = -2;
    private Integer height = -2;
    //左边距
    private Integer marginLeft = 0;
    //上边距
    private Integer marginTop = 0;
    //右边距
    private Integer marginRight = 0;
    //底边距
    private Integer marginBottom = 0;

    //规则
    private List<RuleInfo> rules = new ArrayList<>();

    //文字设置
    //文字消息
    private String text;
    //字体 （如:Reznor）
    private String typeface = "";
    //字体大小
    private Integer textSize;
    //字体颜色
    private String textColor;
    //字体风格 (粗体:bold， 斜体:italic， 正常:normal)
    private String textStyle = "normal";

    //图片设置
    //背景URL或"#ffffff"
    private String background;
    //背景图片类型 "URL","QRCODE","COLOR"
    private String backgroundType = "URL";
    //图片处理 0:不处理，1:圆形， 2:圆角
    private Integer transform = 0;
    //描边宽度
    private Integer strokeWidth;
    //描边颜色
    private String strokeColor;
    //圆角半径
    private Integer cornersRadius = 0;

    public ViewInfo() {}

    @Override
    public String toString() {
        return "ViewInfo{" +
                "viewId=" + viewId +
                ", viewType='" + viewType + '\'' +
                ", childViews=" + childViews +
                ", width=" + width +
                ", height=" + height +
                ", marginLeft=" + marginLeft +
                ", marginTop=" + marginTop +
                ", marginRight=" + marginRight +
                ", marginBottom=" + marginBottom +
                ", rules=" + rules +
                ", text='" + text + '\'' +
                ", typeface='" + typeface + '\'' +
                ", textSize=" + textSize +
                ", textColor='" + textColor + '\'' +
                ", textStyle='" + textStyle + '\'' +
                ", background='" + background + '\'' +
                ", backgroundType='" + backgroundType + '\'' +
                ", transform=" + transform +
                ", strokeWidth=" + strokeWidth +
                ", strokeColor='" + strokeColor + '\'' +
                ", cornersRadius=" + cornersRadius +
                '}';
    }

    public Integer getViewId() {
        return viewId;
    }

    public ViewInfo setViewId(Integer viewId) {
        this.viewId = viewId;
        return this;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public List<ViewInfo> getChildViews() {
        return childViews;
    }

    public ViewInfo setChildViews(List<ViewInfo> childViews) {
        this.childViews = childViews;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(Integer marginLeft) {
        this.marginLeft = marginLeft;
    }

    public Integer getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(Integer marginTop) {
        this.marginTop = marginTop;
    }

    public Integer getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(Integer marginRight) {
        this.marginRight = marginRight;
    }

    public Integer getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
    }

    public List<RuleInfo> getRules() {
        return rules;
    }

    public void setRules(List<RuleInfo> rules) {
        this.rules = rules;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTypeface() {
        return typeface;
    }

    public void setTypeface(String typeface) {
        this.typeface = typeface;
    }

    public Integer getTextSize() {
        return textSize;
    }

    public void setTextSize(Integer textSize) {
        this.textSize = textSize;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(String textStyle) {
        this.textStyle = textStyle;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBackgroundType() {
        return backgroundType;
    }

    public ViewInfo setBackgroundType(String backgroundType) {
        this.backgroundType = backgroundType;
        return this;
    }

    public Integer getTransform() {
        return transform;
    }

    public void setTransform(Integer transform) {
        this.transform = transform;
    }

    public Integer getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(Integer strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public Integer getCornersRadius() {
        return cornersRadius;
    }

    public void setCornersRadius(Integer cornersRadius) {
        this.cornersRadius = cornersRadius;
    }
}
