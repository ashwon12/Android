package com.example.imageviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class myPictureView extends View {
    String imagePath = null;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(imagePath != null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            canvas.drawBitmap(bitmap,0,0,null);
            bitmap.recycle();
        }
    }

    public myPictureView(Context context, AttributeSet attr) {
        super(context,attr);

    }
}
