package cavista.interview.grid_viewer.core.base.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.crashlytics.android.Crashlytics;

public class RobotoLightTextView extends androidx.appcompat.widget.AppCompatTextView {

    public static final String ROBOTO_LIGHT_TTF = "Roboto_Light.ttf";

    public RobotoLightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);
    }

    public RobotoLightTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        try {
            Typeface myTypeface = FontCache.getTypeface(ROBOTO_LIGHT_TTF, context);
            setTypeface(myTypeface);
        } catch (Exception e) {
            e.printStackTrace();
            Crashlytics.logException(e);
        }
    }
}
