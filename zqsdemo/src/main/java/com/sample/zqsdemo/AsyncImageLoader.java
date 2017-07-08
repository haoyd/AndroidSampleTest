package com.sample.zqsdemo;

import java.io.IOException;  
import java.io.InputStream;  
import java.lang.ref.SoftReference;  
import java.net.URL;  
import java.util.HashMap;  
  
import android.graphics.drawable.Drawable;  
import android.os.Handler;  
  
public class AsyncImageLoader {  
    final Handler handler = new Handler();  
    private HashMap<String, SoftReference<Drawable>> imageCache;  
    public AsyncImageLoader() {  
        imageCache = new HashMap<String, SoftReference<Drawable>>();//ͼƬ����  
    }  
      
    public interface ImageCallback {
        public void onImageLoad(Integer t, Drawable drawable);  
        public void onError(Integer t);  
    }  
  
    public Drawable loadDrawable(final Integer pos, final String imageUrl,  
             final ImageCallback imageCallback) {  
        new Thread() {  
            @Override  
            public void run() {  
                  
                LoadImg(pos, imageUrl, imageCallback);  
  
            }  
        }.start();  
        return null;  
    }// loadDrawable---end  
  
    public void LoadImg(final Integer pos, final String imageUrl,  
            final ImageCallback imageCallback) {  
        if (imageCache.containsKey(imageUrl)) {
            SoftReference<Drawable> softReference = imageCache.get(imageUrl);  
            final Drawable drawable = softReference.get();  
            if (drawable != null) {  
                handler.post(new Runnable() {  
                    @Override  
                    public void run() {  
                        imageCallback.onImageLoad(pos, drawable);  
                    }  
                });  
                return;  
            }  
        }  
        try {
            final Drawable drawable = loadImageFromUrl(imageUrl);  
            if (drawable != null) {  
                imageCache.put(imageUrl, new SoftReference<Drawable>(drawable));  
            }  
            handler.post(new Runnable() {  
                @Override  
                public void run() {  
                        imageCallback.onImageLoad(pos, drawable);  
                }  
            });  
        } catch (IOException e) {  
            handler.post(new Runnable() {  
                @Override  
                public void run() {  
                    imageCallback.onError(pos);  
                }  
            });  
            e.printStackTrace();  
        }  
  
    }  
  
    public static Drawable loadImageFromUrl(String url) throws IOException {
        URL m;  
        InputStream i = null;  
        m = new URL(url);  
        i = (InputStream) m.getContent();  
        Drawable d = Drawable.createFromStream(i, "src");  
        return d;  
    }  
  
}  