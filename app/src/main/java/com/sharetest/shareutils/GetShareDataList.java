package com.sharetest.shareutils;

import com.google.gson.Gson;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.sharetest.shareutils.ViewInflate.ParamsRule.ALIGN_BOTTOM;
import static com.sharetest.shareutils.ViewInflate.ParamsRule.ALIGN_LEFT;
import static com.sharetest.shareutils.ViewInflate.ParamsRule.ALIGN_RIGHT;
import static com.sharetest.shareutils.ViewInflate.ParamsRule.ALIGN_TOP;
import static com.sharetest.shareutils.ViewInflate.ParamsRule.BELOW;
import static com.sharetest.shareutils.ViewInflate.ParamsRule.CENTER_HORIZONTAL;
import static com.sharetest.shareutils.ViewInflate.ParamsRule.RIGHT_OF;

/**
 * Created by HuJiaCheng on 2017/5/17.
 */

public class GetShareDataList {

    @Test
    public void showJson(){
        String qrurl = "http://live.quji.com/l/friendbonus?key=phqAnFrs0EMSpwJH6FBkEZWUSr8x3mXwe0H9YcKAEhs=";
        String head = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2097810229,3516784541&fm=11&gp=0.jpg";
        Gson gson = new Gson();
        System.out.println(gson.toJson(getViewInfoList(3.64,1.2,qrurl,head)));
        System.out.println(gson.toJson(getViewInfoList2(3.64,1.2,qrurl,head)));
        System.out.println(gson.toJson(getViewInfoList3(3.64,1.2,qrurl,head)));
    }

    static String qrurl = "http://live.quji.com/l/friendbonus?key=phqAnFrs0EMSpwJH6FBkEZWUSr8x3mXwe0H9YcKAEhs=";
//    public static String headurl = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2097810229,3516784541&fm=11&gp=0.jpg";
    public static String headurl = "http://p1.qzone.la/upload/6/okyhfbu4.jpg";

    static DecimalFormat df = new DecimalFormat("######0.00");

    public static List<ViewInfo> getViewInfoList(double rmb, double brmb, String qrcodeurl,String head){
        rmb = 3.64;brmb = 1.2;qrcodeurl = qrurl;head = headurl;
        List<ViewInfo> viewInfos = new ArrayList<>();
        List<RuleInfo> ruleInfos = new ArrayList<>();
        ViewInfo viewInfo = new ViewInfo();
        viewInfo.setWidth(480);
        viewInfo.setHeight(300);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
        viewInfo.setBackground("http://chuantu.biz/t5/88/1495008546x2728329053.png");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(140);
        viewInfo.setHeight(140);
        viewInfo.setMarginLeft(312);
        viewInfo.setMarginTop(136);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
        viewInfo.setBackground(qrcodeurl);
        viewInfo.setBackgroundType(ViewInflate.ViewInflateBuilder.BackgroundType.QRCODE.toString());
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(78);
        viewInfo.setHeight(78);
        viewInfo.setMarginTop(84);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
            ruleInfos = new ArrayList<>();
            ruleInfos.add(new RuleInfo(ViewInflate.ParamsRule.CENTER_HORIZONTAL,null));
        viewInfo.setRules(ruleInfos);
        viewInfo.setTransform(1);
        viewInfo.setBackground(head);
        viewInfo.setStrokeColor("#f5f03c");
        viewInfo.setStrokeWidth(4);
        viewInfo.setBackgroundType("URL");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(210);
        viewInfo.setHeight(100);
        viewInfo.setMarginLeft(-16);
        viewInfo.setMarginTop(-6);
        viewInfo.setMarginRight(-16);
        viewInfo.setMarginBottom(-6);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.RelativeLayout.toString());
            ruleInfos = new ArrayList<>();
            ruleInfos.add(new RuleInfo(ALIGN_RIGHT,110002));
            ruleInfos.add(new RuleInfo(ALIGN_LEFT,110000));
            ruleInfos.add(new RuleInfo(ALIGN_TOP,110001));
            ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,120000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setCornersRadius(20);
        viewInfo.setBackground("#aaffffff");
        viewInfo.setBackgroundType("COLOR");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(100000);
        viewInfo.setMarginLeft(24);
        viewInfo.setMarginTop(110);
        viewInfo.setText("潘多拉");
        viewInfo.setTextSize(26);
        viewInfo.setTextColor("#ffffff");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(100001);
        viewInfo.setMarginLeft(24);
            ruleInfos = new ArrayList<>();
            ruleInfos.add(new RuleInfo(BELOW,100000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("ID:12345678");
        viewInfo.setTextSize(18);
        viewInfo.setTextColor("#ffffff");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110000);
        viewInfo.setMarginLeft(40);
        viewInfo.setMarginTop(194);
        viewInfo.setText("偷好友");
        viewInfo.setTextSize(24);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110001);
        viewInfo.setMarginLeft(5);
        viewInfo.setMarginBottom(-4);
            ruleInfos = new ArrayList<>();
            ruleInfos.add(new RuleInfo(RIGHT_OF,110000));
            ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
            viewInfo.setRules(ruleInfos);
        viewInfo.setText(df.format(rmb) + "");
        viewInfo.setTextSize(42);
        viewInfo.setTypeface("reznor");
        viewInfo.setTextColor("#e42e2c");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110002);
        viewInfo.setMarginLeft(5);
            ruleInfos = new ArrayList<>();
            ruleInfos.add(new RuleInfo(RIGHT_OF,110001));
            ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("元");
        viewInfo.setTextSize(24);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);


        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120000);
        viewInfo.setMarginTop(12);
            ruleInfos = new ArrayList<>();
            ruleInfos.add(new RuleInfo(BELOW,110000));
            ruleInfos.add(new RuleInfo(ALIGN_LEFT,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("被偷走");
        viewInfo.setTextSize(24);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120001);
        viewInfo.setMarginLeft(5);
        viewInfo.setMarginBottom(-4);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,120000));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,120000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText(df.format(brmb) + "");
        viewInfo.setTextSize(42);
        viewInfo.setTypeface("reznor");
        viewInfo.setTextColor("#e42e2c");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120002);
        viewInfo.setMarginLeft(5);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,120001));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,120000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("元");
        viewInfo.setTextSize(24);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        return viewInfos;
    }

    public static List<ViewInfo> getViewInfoList2(double rmb, double brmb, String qrcodeurl, String head){
        rmb = 3.64;brmb = 1.2;qrcodeurl = qrurl;head = headurl;
        List<ViewInfo> viewInfos = new ArrayList<>();
        List<RuleInfo> ruleInfos = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("######0.00");

        ViewInfo viewInfo = new ViewInfo();
        viewInfo.setWidth(480);
        viewInfo.setHeight(300);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
        viewInfo.setBackground("http://i4.buimg.com/1949/1987a786b052949c.png");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(132);
        viewInfo.setHeight(132);
        viewInfo.setMarginLeft(320);
        viewInfo.setMarginTop(84);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
        viewInfo.setBackground(qrcodeurl);
        viewInfo.setBackgroundType(ViewInflate.ViewInflateBuilder.BackgroundType.QRCODE.toString());
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(78);
        viewInfo.setHeight(78);
        viewInfo.setMarginTop(136);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(ViewInflate.ParamsRule.CENTER_HORIZONTAL,null));
        viewInfo.setRules(ruleInfos);
        viewInfo.setTransform(1);
        viewInfo.setBackground(head);
        viewInfo.setStrokeColor("#f5f03c");
        viewInfo.setStrokeWidth(4);
        viewInfo.setBackgroundType("URL");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(100000);
        viewInfo.setMarginLeft(24);
        viewInfo.setMarginTop(164);
        viewInfo.setText("潘多拉");
        viewInfo.setTextSize(30);
        viewInfo.setTextColor("#ffffff");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(100001);
        viewInfo.setMarginLeft(24);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(BELOW,100000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("ID:"+"12345678");
        viewInfo.setTextSize(22);
        viewInfo.setTextColor("#ffffff");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110000);
        viewInfo.setMarginLeft(80);
        viewInfo.setMarginTop(30);
        viewInfo.setText("我抢了好友");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110001);
        viewInfo.setMarginLeft(5);
        viewInfo.setMarginBottom(-3);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,110000));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText(df.format(rmb));
        viewInfo.setTextSize(38);
        viewInfo.setTypeface("reznor");
        viewInfo.setTextColor("#ff2948");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110002);
        viewInfo.setMarginLeft(5);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,110001));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("元");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110003);
        viewInfo.setMarginLeft(5);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,110002));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("(可提现)");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#ff2948");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120000);
        viewInfo.setMarginTop(15);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(BELOW,110000));
        ruleInfos.add(new RuleInfo(ALIGN_LEFT,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("被抢走了");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120001);
        viewInfo.setMarginLeft(5);
        viewInfo.setMarginBottom(-4);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,120000));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,120000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText(df.format(brmb));
        viewInfo.setTextSize(38);
        viewInfo.setTypeface("reznor");
        viewInfo.setTextColor("#ff2948");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120002);
        viewInfo.setMarginLeft(5);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,120001));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,120000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("元");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);


        return viewInfos;
    }

    public static List<ViewInfo> getViewInfoList3(double rmb, double brmb, String qrcodeurl, String head){
        rmb = 3.64;brmb = 1.2;qrcodeurl = qrurl;head = headurl;
        List<ViewInfo> viewInfos = new ArrayList<>();
        List<RuleInfo> ruleInfos = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("######0.00");

        ViewInfo viewInfo = new ViewInfo();
        viewInfo.setWidth(480);
        viewInfo.setHeight(300);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
        viewInfo.setBackground("http://i4.buimg.com/1949/003931ecad624563.jpg");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(108);
        viewInfo.setHeight(108);
        viewInfo.setMarginBottom(-4);
        viewInfo.setMarginTop(-4);
        viewInfo.setMarginLeft(-4);
        viewInfo.setMarginRight(-4);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.RelativeLayout.toString());
            ruleInfos = new ArrayList<>();
            ruleInfos.add(new RuleInfo(ALIGN_RIGHT,99999));
            ruleInfos.add(new RuleInfo(ALIGN_LEFT,99999));
            ruleInfos.add(new RuleInfo(ALIGN_TOP,99999));
            ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,99999));
            viewInfo.setRules(ruleInfos);
        viewInfo.setCornersRadius(8);
        viewInfo.setBackground("#ffffff");
        viewInfo.setBackgroundType(ViewInflate.ViewInflateBuilder.BackgroundType.COLOR.toString());
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(108);
        viewInfo.setHeight(108);
        viewInfo.setMarginLeft(344);
        viewInfo.setMarginTop(72);
        viewInfo.setViewId(99999);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
        viewInfo.setBackground(qrcodeurl);
        viewInfo.setBackgroundType(ViewInflate.ViewInflateBuilder.BackgroundType.QRCODE.toString());
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(52);
        viewInfo.setHeight(52);
        viewInfo.setMarginLeft(30);
        viewInfo.setMarginTop(70);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
        ruleInfos = new ArrayList<>();
        viewInfo.setTransform(1);
        viewInfo.setBackground(head);
        viewInfo.setStrokeColor("#f5f03c");
        viewInfo.setStrokeWidth(6);
        viewInfo.setBackgroundType("URL");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(100000);
        viewInfo.setMarginLeft(92);
        viewInfo.setMarginTop(75);
        viewInfo.setText("潘多拉");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#f5f03c");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(100001);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(BELOW,100000));
        ruleInfos.add(new RuleInfo(ALIGN_LEFT,100000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("ID:"+"12345678");
        viewInfo.setTextSize(16);
        viewInfo.setTextColor("#f5f03c");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110000);
        viewInfo.setMarginLeft(46);
        viewInfo.setMarginTop(148);
        viewInfo.setText("偷好友");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110001);
        viewInfo.setMarginLeft(5);
        viewInfo.setMarginBottom(-3);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,110000));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText(df.format(rmb));
        viewInfo.setTextSize(34);
        viewInfo.setTypeface("reznor");
        viewInfo.setTextColor("#e7126b");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110002);
        viewInfo.setMarginLeft(5);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,110001));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("元");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110003);
        viewInfo.setMarginLeft(5);
        viewInfo.setMarginBottom(2);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,110002));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("（可提现）");
        viewInfo.setTextSize(16);
        viewInfo.setTextColor("#e7126b");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120000);
        viewInfo.setMarginTop(10);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(BELOW,110000));
        ruleInfos.add(new RuleInfo(ALIGN_LEFT,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("被抢走了");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120001);
        viewInfo.setMarginLeft(5);
        viewInfo.setMarginBottom(-4);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,120000));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,120000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText(df.format(brmb));
        viewInfo.setTextSize(34);
        viewInfo.setTypeface("reznor");
        viewInfo.setTextColor("#e7126b");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120002);
        viewInfo.setMarginLeft(5);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,120001));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,120000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("元");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        return viewInfos;
    }

    public static List<ViewInfo> getViewInfoList4(double rmb, double brmb, String qrcodeurl, String head){
        rmb = 3.64;brmb = 1.2;qrcodeurl = qrurl;head = headurl;
        List<ViewInfo> viewInfos = new ArrayList<>();
        List<RuleInfo> ruleInfos = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("######0.00");

        ViewInfo viewInfo = new ViewInfo();
        viewInfo.setWidth(480);
        viewInfo.setHeight(300);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
        viewInfo.setBackground("http://i4.buimg.com/1949/003931ecad624563.jpg");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setMarginLeft(344);
        viewInfo.setMarginTop(72);
        viewInfo.setWidth(108);
        viewInfo.setHeight(108);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.RelativeLayout.toString());
        viewInfo.setCornersRadius(8);
        viewInfo.setBackground("#99ffffff");
        viewInfo.setChildViews(getChildViewInfoList());
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(CENTER_HORIZONTAL,-1));
        viewInfo.setRules(ruleInfos);
        viewInfo.setBackgroundType(ViewInflate.ViewInflateBuilder.BackgroundType.COLOR.toString());
        viewInfos.add(viewInfo);

//        viewInfo = new ViewInfo();
//        viewInfo.setWidth(108);
//        viewInfo.setHeight(108);
//        viewInfo.setMarginLeft(344);
//        viewInfo.setMarginTop(72);
//        viewInfo.setViewId(99999);
//        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
//        viewInfo.setBackground(qrcodeurl);
//        viewInfo.setBackgroundType(ViewInflate.ViewInflateBuilder.BackgroundType.QRCODE.toString());
//        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(52);
        viewInfo.setHeight(52);
        viewInfo.setMarginLeft(30);
        viewInfo.setMarginTop(70);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.ImageView.toString());
        viewInfo.setTransform(1);
        viewInfo.setBackground(head);
        viewInfo.setStrokeColor("#f5f03c");
        viewInfo.setStrokeWidth(4);
        viewInfo.setBackgroundType("URL");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(100000);
        viewInfo.setMarginLeft(92);
        viewInfo.setMarginTop(75);
        viewInfo.setText("潘多拉");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#f5f03c");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(100001);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(BELOW,100000));
        ruleInfos.add(new RuleInfo(ALIGN_LEFT,100000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("ID:"+"12345678");
        viewInfo.setTextSize(16);
        viewInfo.setTextColor("#f5f03c");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110000);
        viewInfo.setMarginLeft(46);
        viewInfo.setMarginTop(148);
        viewInfo.setText("偷好友");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110001);
        viewInfo.setMarginLeft(5);
        viewInfo.setMarginBottom(-3);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,110000));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText(df.format(rmb));
        viewInfo.setTextSize(34);
        viewInfo.setTypeface("reznor");
        viewInfo.setTextColor("#e7126b");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110002);
        viewInfo.setMarginLeft(5);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,110001));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("元");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(110003);
        viewInfo.setMarginLeft(5);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,110002));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("（可提现）");
        viewInfo.setTextSize(16);
        viewInfo.setTextColor("#e7126b");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120000);
        viewInfo.setMarginTop(10);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(BELOW,110000));
        ruleInfos.add(new RuleInfo(ALIGN_LEFT,110000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("被抢走了");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120001);
        viewInfo.setMarginLeft(5);
        viewInfo.setMarginBottom(-4);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,120000));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,120000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText(df.format(brmb));
        viewInfo.setTextSize(34);
        viewInfo.setTypeface("reznor");
        viewInfo.setTextColor("#e7126b");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(120002);
        viewInfo.setMarginLeft(5);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(RIGHT_OF,120001));
        ruleInfos.add(new RuleInfo(ALIGN_BOTTOM,120000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("元");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#291109");
        viewInfos.add(viewInfo);

        return viewInfos;
    }

    public static List<ViewInfo> getChildViewInfoList(){
//        rmb = 3.64;brmb = 1.2;qrcodeurl = qrurl;head = headurl;
        List<ViewInfo> viewInfos = new ArrayList<>();
        List<RuleInfo> ruleInfos = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("######0.00");
        ViewInfo viewInfo;

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(100000);
        viewInfo.setMarginLeft(10);
        viewInfo.setMarginTop(10);
        viewInfo.setText("潘多拉");
        viewInfo.setTextSize(20);
        viewInfo.setTextColor("#f5f03c");
        viewInfos.add(viewInfo);

        viewInfo = new ViewInfo();
        viewInfo.setWidth(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setHeight(ViewInflate.ViewInflateBuilder.WRAP_CONTENT);
        viewInfo.setViewType(ViewInflate.ViewInflateBuilder.ViewType.TextView.toString());
        viewInfo.setViewId(100001);
        ruleInfos = new ArrayList<>();
        ruleInfos.add(new RuleInfo(BELOW,100000));
        ruleInfos.add(new RuleInfo(ALIGN_LEFT,100000));
        viewInfo.setRules(ruleInfos);
        viewInfo.setText("ID:"+"12345678");
        viewInfo.setTextSize(16);
        viewInfo.setTextColor("#f5f03c");
        viewInfos.add(viewInfo);

        return viewInfos;
    }
}
