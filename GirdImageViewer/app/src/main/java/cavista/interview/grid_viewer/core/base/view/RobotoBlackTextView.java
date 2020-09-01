package cavista.interview.grid_viewer.core.base.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.crashlytics.android.Crashlytics;


public class RobotoBlackTextView extends androidx.appcompat.widget.AppCompatTextView {

    private static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";
    public static final String HELVETICA_NEUE_OTF = "Roboto_Regular.ttf";
    public static final String ROBOTO_ITALIC_TTF = "Roboto_Medium.ttf";
    public static final String ROBOTO_BLACK_TTF = "roboto_black.ttf";
    public static final String TEXT_STYLE = "textStyle";

    public RobotoBlackTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    public RobotoBlackTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        try {
            int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, TEXT_STYLE, Typeface.NORMAL);
            Typeface customFont = selectTypeface(context, textStyle);
            setTypeface(customFont);
        }catch (Exception e){
            e.printStackTrace();
            Crashlytics.logException(e);
        }
    }

    private Typeface selectTypeface(Context context, int textStyle) {
        switch (textStyle) {
//            case Typeface.BOLD:
//                return FontCache.getTypeface(ROBOTO_BOLD_TTF, context);

//            case Typeface.BOLD_ITALIC:
//                return FontCache.getTypeface(ROBOTO_BOLD_TTF, context);

            case Typeface.ITALIC: // italic
                return FontCache.getTypeface(ROBOTO_ITALIC_TTF, context);

            case Typeface.NORMAL: // regular
            default:
                return FontCache.getTypeface(ROBOTO_BLACK_TTF, context);
        }
    }
}
