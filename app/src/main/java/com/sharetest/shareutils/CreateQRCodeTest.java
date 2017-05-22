package com.sharetest.shareutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

/**
 * Created by HuJiaCheng on 2017/4/10.
 */

public class CreateQRCodeTest {

    private static Integer saveLogoId;
    private static String saveUrl;
    private static Bitmap saveBitmap;
    private static Bitmap saveBitmapWithLogo;
    public static Context context;

    //获取英文二维码
    public static class CreateEnglishQRCode extends AsyncTask<Void, Void, Bitmap> {
        ImageView imageView;
        String url;
        Bitmap logo;
        public CreateEnglishQRCode(ImageView imageView, String url, Bitmap logo) {
            this.imageView = imageView;
            this.url = url;
            this.logo = logo;
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            saveBitmapWithLogo = QRCodeEncoder.syncEncodeQRCode(url, BGAQRCodeUtil.dp2px(context, 150), Color.BLACK, Color.WHITE, logo);
            return saveBitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                Toast.makeText(context, "生成英文二维码失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //获取中文二维码
    public static class CreateChineseQRCode extends AsyncTask<Void, Void, Bitmap> {
        ImageView imageView;
        String url;
        public CreateChineseQRCode(ImageView imageView, String url) {
            this.imageView = imageView;
            this.url = url;
            if(saveUrl == null){
                saveUrl = url;
            }
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            if(!saveUrl.equals(url)){
                return QRCodeEncoder.syncEncodeQRCode(url, BGAQRCodeUtil.dp2px(context, 150));
            }else if(saveBitmap == null){
                saveBitmap = QRCodeEncoder.syncEncodeQRCode(url, BGAQRCodeUtil.dp2px(context, 150));
            }
            return saveBitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                Toast.makeText(context, "生成中文二维码失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //获取中文二维码带Logo
    public static class CreateChineseQRCodeWithLogo extends AsyncTask<Void, Void, Bitmap> {
        int logoid;
        ImageView imageView;
        String url;
        public CreateChineseQRCodeWithLogo(ImageView imageView, String url, int logoid) {
            this.imageView = imageView;
            this.url = url;
            this.logoid = logoid;
            if(saveUrl == null){
                saveUrl = url;
            }
            if(saveLogoId == null){
                saveLogoId = logoid;
            }
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            if(!saveUrl.equals(url) || saveLogoId != logoid){
                Bitmap logoBitmap = BitmapFactory.decodeResource(context.getResources(), logoid);
                return QRCodeEncoder.syncEncodeQRCode(url, BGAQRCodeUtil.dp2px(context, 150), Color.BLACK, logoBitmap);
            }else if(saveBitmapWithLogo == null){
                Bitmap logoBitmap = BitmapFactory.decodeResource(context.getResources(), logoid);
                saveBitmapWithLogo = QRCodeEncoder.syncEncodeQRCode(url, BGAQRCodeUtil.dp2px(context, 150), Color.BLACK, logoBitmap);
            }
            return saveBitmapWithLogo;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                Toast.makeText(context, "生成带logo的中文二维码失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //获取英文二维码带Logo
    public static class CreateEnglishQRCodeWithLogo extends AsyncTask<Void, Void, Bitmap> {
        int logoid;
        ImageView imageView;
        String url;
        EncodeListener listener;
        public CreateEnglishQRCodeWithLogo(ImageView imageView, String url, int logoid, EncodeListener listener) {
            this.imageView = imageView;
            this.url = url;
            this.logoid = logoid;
            this.listener = listener;
            if(saveUrl == null){
                saveUrl = url;
            }
            if(saveLogoId == null){
                saveLogoId = logoid;
            }
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            if(!saveUrl.equals(url) && saveLogoId != logoid){
                Bitmap logoBitmap = BitmapFactory.decodeResource(context.getResources(), logoid);
                return QRCodeEncoder.syncEncodeQRCode(url, BGAQRCodeUtil.dp2px(context, 150), Color.BLACK, Color.WHITE, logoBitmap);
            }else if(saveBitmapWithLogo == null){
                Bitmap logoBitmap = BitmapFactory.decodeResource(context.getResources(), logoid);
                saveBitmapWithLogo = QRCodeEncoder.syncEncodeQRCode(url, BGAQRCodeUtil.dp2px(context, 150), Color.BLACK, Color.WHITE, logoBitmap);
            }
            return saveBitmapWithLogo;

        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                if(listener != null)
                    listener.onComplete();
            } else {
                Toast.makeText(context, "生成带logo的英文二维码失败", Toast.LENGTH_SHORT).show();
                if(listener != null)
                    listener.onError();
            }
        }
    }

    public static abstract class EncodeListener{
        public abstract void onComplete();
        public void onError(){
            Log.e("QRcode", "SyncEncodeQRCode error,Check the params!");
        }
    }
}
