package cavista.interview.grid_viewer.core.base.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.crashlytics.android.Crashlytics;


public class HelveticaTextView extends androidx.appcompat.widget.AppCompatTextView {

    private static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";
    public static final String ROBOTO_REGULAR_TTF = "Roboto_Regular.ttf";
    public static final String ROBOTO_ITALIC_TTF = "Roboto_Light.ttf";
    public static final String ROBOTO_BLACK_TTF = "roboto_black.ttf";
    public static final String ROBOTO_BOLD_TTF = "roboto_bold.ttf";
    public static final String TEXT_STYLE = "textStyle";

    public HelveticaTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);
    }

    public HelveticaTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        try {
            int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, TEXT_STYLE, Typeface.NORMAL);
            Typeface customFont = selectTypeface(context, textStyle);
            setTypeface(customFont);
        } catch (Exception e) {
            e.printStackTrace();
            Crashlytics.logException(e);
        }
    }

    private Typeface selectTypeface(Context context, int textStyle) {
        switch (textStyle) {
            case Typeface.BOLD:
                return FontCache.getTypeface(ROBOTO_BOLD_TTF, context);

            case Typeface.ITALIC:
                return FontCache.getTypeface(ROBOTO_ITALIC_TTF, context);

            case Typeface.NORMAL:
            default:
                return FontCache.getTypeface(ROBOTO_REGULAR_TTF, context);
        }
    }
}
