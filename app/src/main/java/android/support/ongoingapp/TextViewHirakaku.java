package android.support.ongoingapp;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by gmgn on 8/23/2016.
 */
public class TextViewHirakaku extends TextView {

    public TextViewHirakaku(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public TextViewHirakaku(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewHirakaku(Context context) {
        super(context);
    }

    public void setTypeface(Typeface tf, int style) {
        if (style == Typeface.BOLD) {
            super.setTypeface(TypeFaces.getTypeFace(getContext(),
                    "fonts/hirakakupronbold.ttf"));
        } else if (style == Typeface.ITALIC) {
            super.setTypeface(TypeFaces.getTypeFace(getContext(),
                    "fonts/hirakakupronitalic.ttf"));
        } else {
            super.setTypeface(TypeFaces.getTypeFace(getContext(),
                    "fonts/hirakakupron.ttf"));
        }
    }
}