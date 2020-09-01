package cavista.interview.grid_viewer.core.base.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

import com.crashlytics.android.Crashlytics;

public class HelveticaEditText extends AppCompatEditText {
    public static final String ROBOTO_REGULAR_TTF = "Roboto_Regular.ttf";
    public static final String ROBOTO_LIGHT_TTF = "Roboto_Light.ttf";

    public HelveticaEditText(Context context) {
        super(context);
        init();
    }

    public HelveticaEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HelveticaEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        try {
            Typeface font = Typeface.createFromAsset(getContext().getAssets(), ROBOTO_LIGHT_TTF);
            this.setTypeface(font);
        }catch (Exception e){
            e.printStackTrace();
            Crashlytics.logException(e);
        }
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        tf = Typeface.createFromAsset(getContext().getAssets(), ROBOTO_LIGHT_TTF);
        super.setTypeface(tf, style);
    }

    @Override
    public void setTypeface(Typeface tf) {
        tf = Typeface.createFromAsset(getContext().getAssets(),ROBOTO_LIGHT_TTF);
        super.setTypeface(tf);
    }
}
