package com.sharetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sharetest.shareutils.CreateQRCode;
import com.sharetest.shareutils.CreateQRCodeTest;
import com.sharetest.shareutils.GetShareDataList;
import com.sharetest.shareutils.RuleInfo;
import com.sharetest.shareutils.ViewInflate;
import com.sharetest.shareutils.ViewInfo;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Test
    public void test(){
        float x = (float)720/(float)480;
        System.out.println("x="+x);
        float result = x*300;
        System.out.println("result="+result);
        float y = 1.38f;
        System.out.println("y*2="+(int)(y*2));

//        List<ViewInfo> viewInfos = GetShareDataList.getViewInfoList(123.45,1.01,url,url);
//        for (ViewInfo viewInfo : viewInfos) {
//            System.out.println(viewInfo);
//        }
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(viewInfos));

        DecimalFormat df   = new DecimalFormat("######0.00");

        double d1 = 99999993.23456;
        double d2 = 0.0;
        double d3 = 2.0;
        System.out.println(df.format(d1));
        System.out.println(df.format(d2));
        System.out.println(df.format(d3));
    }

    @Test
    public void showJson(){
        String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1494843119&di=f3e3aa72a959ec28dcad4f6fe00ab233&src=http://img1.qqdawang.com/file/20160930/67f48f87b7cbeb66eca361d277f84ef6.jpg";
        List<ViewInfo> viewInfos = new ArrayList<>();
        ViewInfo viewInfo = new ViewInfo();
        viewInfo.setViewType("ImageView");
        viewInfo.setWidth(78);
        viewInfo.setHeight(78);
        viewInfo.setMarginLeft(0);
        viewInfo.setMarginTop(136);
        viewInfo.setMarginBottom(0);
        viewInfo.setMarginRight(0);
        List<RuleInfo> rule = new ArrayList<>();
        rule.add(new RuleInfo(ViewInflate.ParamsRule.CENTER_HORIZONTAL,-2));
        viewInfo.setRules(rule);
        //图片
        viewInfo.setTransform(1);
        viewInfo.setStrokeWidth(6);
        viewInfo.setStrokeColor("#f9c021");
        viewInfo.setBackground(url);
        viewInfo.setCornersRadius(0);
        //文字
//        viewInfo.setText("抢好友");
//        viewInfo.setTypeface("reznor");
//        viewInfo.setTextSize(22);
//        viewInfo.setTextColor("#291109");
//        viewInfo.setTextStyle("bold");

        viewInfos.add(viewInfo);
        viewInfos.add(viewInfo);

        Gson gson = new Gson();
        System.out.println(gson.toJson(viewInfos));
        String jsonstr = gson.toJson(viewInfos);
        String jsonstrs = "[\n" +
                "    {\n" +
                "        \"viewId\": -2,\n" +
                "        \"viewType\": \"ImageView\",\n" +
                "        \"width\": 78,\n" +
                "        \"height\": 78,\n" +
                "        \"marginLeft\": 0,\n" +
                "        \"marginTop\": 136,\n" +
                "        \"marginRight\": 0,\n" +
                "        \"marginBottom\": 0,\n" +
                "        \"rules\": [\n" +
                "            {\n" +
                "                \"ruleName\": \"CENTER_HORIZONTAL\",\n" +
                "                \"ruleId\": -2\n" +
                "            }\n" +
                "        ],\n" +
                "        \"typeface\": \"\",\n" +
                "        \"textStyle\": \"normal\",\n" +
                "        \"background\": \"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1494843119&di=f3e3aa72a959ec28dcad4f6fe00ab233&src=http://img1.qqdawang.com/file/20160930/67f48f87b7cbeb66eca361d277f84ef6.jpg\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"viewId\": -2,\n" +
                "        \"viewType\": \"ImageView\",\n" +
                "        \"width\": 78,\n" +
                "        \"height\": 78,\n" +
                "        \"marginLeft\": 0,\n" +
                "        \"marginTop\": 136,\n" +
                "        \"marginRight\": 0,\n" +
                "        \"marginBottom\": 0,\n" +
                "        \"rules\": [\n" +
                "            {\n" +
                "                \"ruleName\": \"CENTER_HORIZONTAL\",\n" +
                "                \"ruleId\": -2\n" +
                "            }\n" +
                "        ],\n" +
                "        \"typeface\": \"\",\n" +
                "        \"textStyle\": \"normal\",\n" +
                "        \"background\": \"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1494843119&di=f3e3aa72a959ec28dcad4f6fe00ab233&src=http://img1.qqdawang.com/file/20160930/67f48f87b7cbeb66eca361d277f84ef6.jpg\"\n" +
                "    }\n" +
                "]";

        List<ViewInfo> viewInfoList = gson.fromJson(jsonstrs, new TypeToken<List<ViewInfo>>(){}.getType());
        for (ViewInfo info : viewInfoList) {
            System.out.println(info);
        }
    }
    String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1494843119&di=f3e3aa72a959ec28dcad4f6fe00ab233&src=http://img1.qqdawang.com/file/20160930/67f48f87b7cbeb66eca361d277f84ef6.jpg";

    String qrcode = "http://live.quji.com/l/friendbonus?key=4OoZDvIcxIv7QmmdMQmQYvMvUethyFeLq9qTj6Fhqbo=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addfirstlayout();
        addnextlayout2();
        addnextlayout3();
        addnextlayout4();
    }

    private void addnextlayout4(){
        List<ViewInfo> viewInfos = GetShareDataList.getViewInfoList4(1.11,3.33,qrcode,url);
        RelativeLayout re4 = (RelativeLayout) findViewById(R.id.relative4);
        CreateQRCodeTest.context = this;
        CreateQRCode.context = this;
        ViewInflate.ViewInflateBuilder builder = new ViewInflate.ViewInflateBuilder();
        for (int i = 0; i < viewInfos.size(); i++) {
            if(i == 0){
                builder.with(this)
                        .initialMultipleByWidth(viewInfos.get(i).getWidth())
                        .loadViewInfo(viewInfos.get(i))
                        .buildInto(re4);
            }else {
                builder.with(this)
                        .loadViewInfo(viewInfos.get(i))
                        .buildInto(re4);
            }
        }
    }

    private void addfirstlayout(){
        List<ViewInfo> viewInfos = GetShareDataList.getViewInfoList2(1.11,3.33,qrcode,url);
        RelativeLayout re3 = (RelativeLayout) findViewById(R.id.relative);
        CreateQRCode.context = this;
        ViewInflate.ViewInflateBuilder builder = new ViewInflate.ViewInflateBuilder();
        for (int i = 0; i < viewInfos.size(); i++) {
            if(i == 0){
                builder.with(this)
                        .initialMultipleByWidth(viewInfos.get(i).getWidth())
                        .loadViewInfo(viewInfos.get(i))
                        .buildInto(re3);
            }else {
                builder.with(this)
                        .loadViewInfo(viewInfos.get(i))
                        .buildInto(re3);
            }

        }
    }

    private void addnextlayout2() {
        List<ViewInfo> viewInfos = GetShareDataList.getViewInfoList(1.11,3.33,qrcode,url);
        RelativeLayout re3 = (RelativeLayout) findViewById(R.id.relative2);
        CreateQRCodeTest.context = this;
        CreateQRCode.context = this;
        ViewInflate.ViewInflateBuilder builder = new ViewInflate.ViewInflateBuilder();
        for (int i = 0; i < viewInfos.size(); i++) {
            if(i == 0){
                builder.with(this)
                        .initialMultipleByWidth(viewInfos.get(i).getWidth())
                        .loadViewInfo(viewInfos.get(i))
                        .buildInto(re3);
            }else {
                builder.with(this)
                        .loadViewInfo(viewInfos.get(i))
                        .buildInto(re3);
            }

        }
    }

    private void addnextlayout3() {
        List<ViewInfo> viewInfos = GetShareDataList.getViewInfoList3(1.11,3.33,qrcode,url);
        RelativeLayout re3 = (RelativeLayout) findViewById(R.id.relative3);
        CreateQRCodeTest.context = this;
        CreateQRCode.context = this;
        ViewInflate.ViewInflateBuilder builder = new ViewInflate.ViewInflateBuilder();
        for (int i = 0; i < viewInfos.size(); i++) {
            if(i == 0){
                builder.with(this)
                        .initialMultipleByWidth(viewInfos.get(i).getWidth())
                        .loadViewInfo(viewInfos.get(i))
                        .buildInto(re3);
            }else {
                builder.with(this)
                        .loadViewInfo(viewInfos.get(i))
                        .buildInto(re3);
            }

        }
    }

}
