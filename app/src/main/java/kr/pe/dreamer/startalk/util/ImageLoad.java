package kr.pe.dreamer.startalk.util;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.StringSignature;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by rhdlr on 2017-02-12.
 */

public class ImageLoad {
    private static ImageLoad instance;

    private ImageLoad() {

    }

    public static ImageLoad getInstance() {
        if (instance == null) {
            instance = new ImageLoad();
        }

        return instance;
    }

    public void load(Context context, ImageView imageView, int resource) {
        Glide.with(context)
                .load(resource)
                .into(imageView);
    }

    public void load(Context context, ImageView imageView, String resource) {
        Glide.with(context)
                .load(resource)
                .into(imageView);
    }

    public void load(Context context, ImageView imageView, Uri resource) {
        Glide.with(context)
                .load(resource)
                .signature(new StringSignature(String.valueOf(System.currentTimeMillis())))
                .into(imageView);
    }

    public void circleLoad(Context context, ImageView imageView, int resource) {
        Glide.with(context).load(resource)
                .bitmapTransform(new CropCircleTransformation(context)).into(imageView);
    }
}
