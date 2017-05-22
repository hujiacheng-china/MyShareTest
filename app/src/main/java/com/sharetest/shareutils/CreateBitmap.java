package com.sharetest.shareutils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by HuJiaCheng on 2017/5/16.
 */

public class CreateBitmap {

    /**
     * 创建圆角Bitmap
     * @param width
     * @param height
     * @param colorStr
     * @param roundPx
     * @return
     */
    public static Bitmap GetRoundedCornerBitmap(int width, int height, String colorStr, int roundPx) {
        if(width <= 0 || height <= 0){
            width = 230;
            height = 100;
        }
        Bitmap mBitmap = GetSimpleColorBitmap(width,height,colorStr);
        Bitmap bitmap = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(),Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        //设置矩形大小
        Rect rect = new Rect(0,0,mBitmap.getWidth(),mBitmap.getHeight());
        RectF rectf = new RectF(rect);

        // 相当于清屏
        canvas.drawARGB(0, 0, 0, 0);
        //画圆角
        canvas.drawRoundRect(rectf, roundPx, roundPx, paint);
        // 取两层绘制，显示上层
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        // 把原生的图片放到这个画布上，使之带有画布的效果
        canvas.drawBitmap(mBitmap, rect, rect, paint);
        return bitmap;
    }

    /**
     * 获取纯色Bitmap
     * @param width
     * @param height
     * @param colorStr
     * @return
     */
    public static Bitmap GetSimpleColorBitmap(int width, int height, String colorStr){
        Bitmap mBitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        mBitmap.eraseColor(Color.parseColor(colorStr));
        return mBitmap;
    }

}
