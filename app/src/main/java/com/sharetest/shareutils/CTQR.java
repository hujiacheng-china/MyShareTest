package com.sharetest.shareutils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

import static com.sharetest.shareutils.CreateQRCodeTest.context;

/**
 * Created by HuJiaCheng on 2017/5/18.
 */

public class CTQR {
    //获取英文二维码
    public static class CreateEnglishQRCode extends AsyncTask<Void, Void, Bitmap> {
        ImageView imageView;
        String url;
        Bitmap bitmap;
        public CreateEnglishQRCode(ImageView imageView, String url, Bitmap bitmap) {
            this.imageView = imageView;
            this.url = url;
            this.bitmap = bitmap;
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            return QRCodeEncoder.syncEncodeQRCode(url, BGAQRCodeUtil.dp2px(context, 150), Color.parseColor("#000000"),
                    Color.TRANSPARENT,bitmap);
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
}
