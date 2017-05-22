package com.sharetest.shareutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

import static com.sharetest.shareutils.GetShareDataList.headurl;

/**
 * 根据ViewInfo信息向RelativeLayout动态添加View封装工具类
 * Created by HuJiaCheng on 2017/5/15.
 */

public class ViewInflate {

    public static class ParamsRule{
        public static final String LEFT_OF             = "LEFT_OF";
        public static final String ABOVE               = "ABOVE";
        public static final String RIGHT_OF            = "RIGHT_OF";
        public static final String BELOW               = "BELOW";
        public static final String ALIGN_LEFT          = "ALIGN_LEFT";
        public static final String ALIGN_TOP           = "ALIGN_TOP";
        public static final String ALIGN_RIGHT         = "ALIGN_RIGHT";
        public static final String ALIGN_BOTTOM        = "ALIGN_BOTTOM";
        public static final String ALIGN_PARENT_LEFT   = "ALIGN_PARENT_LEFT";
        public static final String ALIGN_PARENT_TOP    = "ALIGN_PARENT_TOP";
        public static final String ALIGN_PARENT_RIGHT  = "ALIGN_PARENT_RIGHT";
        public static final String ALIGN_PARENT_BOTTOM = "ALIGN_PARENT_BOTTOM";
        public static final String CENTER_HORIZONTAL   = "CENTER_HORIZONTAL";
        public static final String CENTER_IN_PARENT    = "CENTER_IN_PARENT";
        public static final String CENTER_VERTICAL     = "CENTER_VERTICAL";
        public static int getRule(String rule){
            switch (rule){
                case "LEFT_OF"              :return RelativeLayout.LEFT_OF;
                case "ABOVE"                :return RelativeLayout.ABOVE;
                case "RIGHT_OF"             :return RelativeLayout.RIGHT_OF;
                case "BELOW"                :return RelativeLayout.BELOW;
                case "ALIGN_LEFT"           :return RelativeLayout.ALIGN_LEFT;
                case "ALIGN_TOP"            :return RelativeLayout.ALIGN_TOP;
                case "ALIGN_RIGHT"          :return RelativeLayout.ALIGN_RIGHT;
                case "ALIGN_BOTTOM"         :return RelativeLayout.ALIGN_BOTTOM;
                case "ALIGN_PARENT_LEFT"    :return RelativeLayout.ALIGN_PARENT_LEFT;
                case "ALIGN_PARENT_TOP"     :return RelativeLayout.ALIGN_PARENT_TOP;
                case "ALIGN_PARENT_RIGHT"   :return RelativeLayout.ALIGN_PARENT_RIGHT;
                case "ALIGN_PARENT_BOTTOM"  :return RelativeLayout.ALIGN_PARENT_BOTTOM;
                case "CENTER_HORIZONTAL"    :return RelativeLayout.CENTER_HORIZONTAL;
                case "CENTER_IN_PARENT"     :return RelativeLayout.CENTER_IN_PARENT;
                case "CENTER_VERTICAL"      :return RelativeLayout.CENTER_VERTICAL;
                default:return -1;
            }
        }
    }

    public static class ViewInflateBuilder{

        public static final String NORMAL = "normal";
        public static final String BOLD = "bold";
        public static final String ITALIC = "italic";
        public static final int MATCH_PARENT = -1;
        public static final int WRAP_CONTENT = -2;
        private static float multiple = 1;
        private Integer backgroundId;
        private Context context;
        private RelativeLayout.LayoutParams params;
        private ViewInfo viewInfo;
        public enum ViewType{
            TextView,ImageView,RelativeLayout
        }
        public enum BackgroundType{
            URL,QRCODE,COLOR
        }

        /**
         * 初始化数据 获得上下文
         * @param context 上下文
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder with(Context context){
            this.context = context;
            viewInfo = new ViewInfo();
            backgroundId = null;
            params = null;
            return this;
        }

        /**
         * 加载JavaBean ViewInfo 动态创建
         * @param viewInfo View信息封装
         * @return
         */
        public ViewInflateBuilder loadViewInfo(ViewInfo viewInfo){
            this.viewInfo = viewInfo;
            createParams(viewInfo.getWidth(),viewInfo.getHeight());
            setMargins(viewInfo.getMarginLeft(),viewInfo.getMarginTop(),viewInfo.getMarginRight(),viewInfo.getMarginBottom());
            setParamsRules(viewInfo.getRules());
            setZoom();
            return this;
        }


        /**
         * 设置缩放
         */
        private void setZoom() {
            if(viewInfo.getCornersRadius() != null)
                viewInfo.setCornersRadius((int)(multiple * viewInfo.getCornersRadius()));
            if(viewInfo.getStrokeWidth() != null)
                viewInfo.setStrokeWidth((int)(multiple * viewInfo.getStrokeWidth()));
            if(viewInfo.getTextSize() != null)
                viewInfo.setTextSize((int)(multiple * viewInfo.getTextSize()));
        }

        /**
         * 设置ViewId 默认-2
         * @param viewId 用作约束使用
         * @return
         */
        public ViewInflateBuilder setViewId(int viewId){
            this.viewInfo.setViewId(viewId);
            return this;
        }

        /**
         * 设置View的类型
         * @param viewType View的类型（例如：ViewInflate.ViewInflateBuilder.ViewType.ImageView）
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setViewType(ViewType viewType){
            this.viewInfo.setViewType(viewType.toString());
            return this;
        }

        /**
         * 创建ViewParams
         * @param width View的宽度
         * @param height View的高度
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder createParams(int width, int height){
            width  = width  > 0 ? (int)(multiple * width ) : width;
            height = height > 0 ? (int)(multiple * height) : height;
            this.params = new RelativeLayout.LayoutParams(width,height);
            viewInfo.setWidth(width);
            viewInfo.setHeight(height);
            return this;
        }

        /**
         * 设置四方位边距
         * @param left 左边距
         * @param top 上边距
         * @param right 右边距
         * @param bottom 底边距
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setMargins(int left, int top, int right, int bottom){
            if(params != null){
                params.setMargins((int)(multiple * left),(int)(multiple * top),
                        (int)(multiple * right),(int)(multiple * bottom));
                viewInfo.setMarginLeft(params.leftMargin);
                viewInfo.setMarginTop(params.topMargin);
                viewInfo.setMarginRight(params.rightMargin);
                viewInfo.setMarginBottom(params.bottomMargin);
            }
            return this;
        }

        /**
         * 设置单条View约束规则
         * @param rule 规则名称 (例如：ViewInflate.ParamsRule.CENTER_HORIZONTAL 或 "CENTER_HORIZONTAL")
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setParamsRule(String rule, Integer bindingId){
            if(params != null){
                if(bindingId != null){
                    params.addRule(ParamsRule.getRule(rule),bindingId);
                    viewInfo.getRules().add(new RuleInfo(rule,bindingId));
                }
                else{
                    params.addRule(ParamsRule.getRule(rule));
                    viewInfo.getRules().add(new RuleInfo(rule,-1));
                }
            }
            return this;
        }

        /**
         * 设置多条View约束规则
         * @param rules 规则名称
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setParamsRules(List<RuleInfo> rules){
            if(params != null){
                for (RuleInfo rule : rules) {
                    if(rule.getRuleId() != null)
                        params.addRule(ParamsRule.getRule(rule.getRuleName()),rule.getRuleId());
                    else
                        params.addRule(ParamsRule.getRule(rule.getRuleName()));
                }
            }
            return this;
        }

        /**
         * 设置文字
         * @param text 文字内容
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setText(String text) {
            this.viewInfo.setText(text);
            return this;
        }

        /**
         * 设置字体（不设置为默认字体）
         * @param typeface 字体名称（例如："reznor"）
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setTypeface(String typeface) {
            this.viewInfo.setTypeface(typeface);
            return this;
        }

        /**
         * 设置字体大小
         * @param textSize 字体大小（单位：px）
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setTextSize(Integer textSize) {
            this.viewInfo.setTextSize(textSize);
            return this;
        }

        /**
         * 设置字体颜色
         * @param textColor 字体颜色文本（例如："#ff0000"）
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setTextColor(String textColor) {
            this.viewInfo.setTextColor(textColor);
            return this;
        }

        /**
         * 设置字体的风格
         * @param textStyle 风格（例如:"normal"、"bold"、"italic"）
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setTextStyle(String textStyle) {
            this.viewInfo.setTextStyle(textStyle);
            return this;
        }

        /**
         * 设置图片背景
         * @param background 图片URL
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setBackground(String background) {
            this.viewInfo.setBackground(background);
            return this;
        }

        /**
         * 设置图片背景
         * @param backgroundId 图片id
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setBackground(Integer backgroundId) {
            this.backgroundId = backgroundId;
            return this;
        }

        /**
         * 设置图片背景类型
         * @param backgroundType 类型("URL","QRCODE","COLOR")
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setBackgroundType(String backgroundType) {
            this.viewInfo.setBackgroundType(backgroundType);
            return this;
        }

        /**
         * 设置图片处理方式
         * @param transform 0不处理，1圆形，2圆角
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setTransform(Integer transform) {
            this.viewInfo.setTransform(transform);
            return this;
        }

        /**
         * 设置边框宽度
         * @param strokeWidth 边框宽度（单位PX）
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setStrokeWidth(Integer strokeWidth) {
            this.viewInfo.setStrokeWidth((int)(multiple * strokeWidth));
            return this;
        }

        /**
         * 设置边框颜色
         * @param strokeColor 边框颜色（例如："#ff0000"）
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setStrokeColor(String strokeColor) {
            this.viewInfo.setStrokeColor(strokeColor);
            return this;
        }

        /**
         * 设置圆角半径
         * @param cornersRadius 圆角半径（单位PX）
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setCornersRadius(Integer cornersRadius) {
            this.viewInfo.setCornersRadius((int)(multiple * cornersRadius));
            return this;
        }

        /**
         * 创建并添加进父容器
         * @param parent 父容器
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder buildInto(RelativeLayout parent){
            if (parent == null || context == null || params == null)
                return this;
            if(viewInfo.getViewType() != null && viewInfo.getViewType().equals(ViewType.ImageView.toString())){
                setImageView(parent);
            }else if(viewInfo.getViewType() != null && viewInfo.getViewType().equals(ViewType.TextView.toString())){
                setTextView(parent);
            }else if(viewInfo.getViewType() != null && viewInfo.getViewType().equals(ViewType.RelativeLayout.toString())){
                setRelativeLayout(parent);
            }
            return this;
        }

        /**
         * 设置RelativeLayout
         * @param parent
         */
        private void setRelativeLayout(RelativeLayout parent) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            if(viewInfo.getChildViews().size() > 0) {
                List<ViewInfo> childViews = viewInfo.getChildViews();
                ViewInflateBuilder builder = new ViewInflateBuilder();
                for (ViewInfo childView : childViews) {
                    builder.with(context)
                            .loadViewInfo(childView)
                            .buildInto(relativeLayout);
                }
            }
            if(viewInfo.getBackgroundType().equals(BackgroundType.COLOR.toString())) {
                relativeLayout.setBackgroundDrawable(new BitmapDrawable(CreateBitmap.GetRoundedCornerBitmap(params.width, params.height
                        , viewInfo.getBackground(), viewInfo.getCornersRadius())));
                parent.addView(relativeLayout, params);
            }
        }

        /**
         * 设置TextView
         * @param parent
         */
        private void setTextView(RelativeLayout parent) {
            TextView textView = new TextView(context);
            textView.setId(viewInfo.getViewId());
            textView.setText(viewInfo.getText());
            textView.setTextColor(Color.parseColor(viewInfo.getTextColor()));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, viewInfo.getTextSize());
            if(viewInfo.getTypeface() != null && !viewInfo.getTypeface().equals("")){
                String path = "fonts/" + viewInfo.getTypeface() + ".ttf";
                Typeface typeFace = Typeface.createFromAsset(context.getAssets(), path);
                if(viewInfo.getTextStyle().equals(BOLD)) {
                    textView.setTypeface(typeFace, Typeface.BOLD);
                }
                else if(viewInfo.getTextStyle().equals(ITALIC)){
                    textView.setTypeface(typeFace, Typeface.ITALIC);
                }else {
                    textView.setTypeface(typeFace, Typeface.NORMAL);
                }
            }else {
                if(viewInfo.getTextStyle().equals(BOLD)) {
                    textView.setTypeface(Typeface.DEFAULT_BOLD, Typeface.BOLD);
                }
                else if(viewInfo.getTextStyle().equals(ITALIC)){
                    textView.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                }else {
                    textView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                }
            }
            parent.addView(textView,params);
        }
        private String url;
        /**
         * 设置ImageView
         * @param parent
         */
        private void setImageView(RelativeLayout parent) {
            final ImageView imageView = new ImageView(context);
            imageView.setId(viewInfo.getViewId());
            if(viewInfo.getBackgroundType().equals(BackgroundType.QRCODE.toString())){
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                url = viewInfo.getBackground();
                Glide.with(context)
                        .load(headurl)
                        .asBitmap()
                        .transform(new CenterCrop(context),new GlideRoundTransform(context,params.width/5))
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(new SimpleTarget<Bitmap>(params.width,params.height) {
                            @Override
                            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                                Bitmap avatarBitmap = QRCodeEncoder.syncEncodeQRCode(url, BGAQRCodeUtil.dp2px(context, 150), Color.parseColor("#000000"),
                                        Color.TRANSPARENT,bitmap);
                                imageView.setImageBitmap(avatarBitmap);
                            }
                        });
            }else if(viewInfo.getBackgroundType().equals(BackgroundType.URL.toString())){
                if(viewInfo.getTransform() == 0){
                    Glide.with(context)
                            .load(backgroundId == null ? viewInfo.getBackground() : backgroundId)
                            .asBitmap()
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new SimpleTarget<Bitmap>() {
                                @Override
                                public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                                    imageView.setImageBitmap(bitmap);
                                }
                            });
                }
                else if(viewInfo.getTransform() == 1){
                    Glide.with(context)
                            .load(viewInfo.getBackground())
                            .asBitmap()
                            .transform(new CenterCrop(context),new GlideCircleTransform(context,viewInfo.getStrokeWidth(), Color.parseColor(viewInfo.getStrokeColor())))
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new SimpleTarget<Bitmap>(params.width,params.height) {
                                @Override
                                public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                                    imageView.setImageBitmap(bitmap);
                                }
                            });
                }else if(viewInfo.getTransform() == 2){
                    Glide.with(context)
                            .load(viewInfo.getBackground())
                            .asBitmap()
                            .transform(new CenterCrop(context),new GlideRoundTransform(context,viewInfo.getCornersRadius()))
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(new SimpleTarget<Bitmap>(params.width,params.height) {
                                @Override
                                public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                                    imageView.setImageBitmap(bitmap);
                                }
                            });
                }
            }else if(viewInfo.getBackgroundType().equals(BackgroundType.COLOR.toString())){
                if(viewInfo.getTransform() == 0){
                    imageView.setImageBitmap(CreateBitmap.GetSimpleColorBitmap(params.width,params.height
                            ,viewInfo.getBackground()));
                }else if(viewInfo.getTransform() == 1){
                    imageView.setImageBitmap(CreateBitmap.GetRoundedCornerBitmap(params.width,params.height
                            ,viewInfo.getBackground(),viewInfo.getCornersRadius()));
                }else if(viewInfo.getTransform() == 2){
                    imageView.setImageBitmap(CreateBitmap.GetRoundedCornerBitmap(params.width,params.height
                            ,viewInfo.getBackground(),viewInfo.getCornersRadius()));
                }
            }
            parent.addView(imageView,params);
        }


        /**
         * 设置缩放倍数
         * @param multiple
         * @return 返回ViewInflateBuilder
         */
        public ViewInflateBuilder setMultiple(float multiple) {
            this.multiple = multiple;
            return this;
        }

        /**
         * 通过背景图初始宽度设置缩放倍数（横版）
         * @param initialWidth 背景图初始宽度（单位PX）
         * @return
         */
        public ViewInflateBuilder initialMultipleByWidth(float initialWidth){
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            float screenWidth = dm.widthPixels;
            this.multiple = screenWidth/initialWidth;
            return this;
        }

        /**
         * 通过背景图初始高度度设置缩放倍数（竖版长图）
         * @param initialHeight 背景图初始高度（单位PX）
         * @return
         */
        public ViewInflateBuilder initialMultipleByHeight(float initialHeight){
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            float screenHeight = dm.heightPixels;
            this.multiple = screenHeight/initialHeight;
            return this;
        }



    }
}
