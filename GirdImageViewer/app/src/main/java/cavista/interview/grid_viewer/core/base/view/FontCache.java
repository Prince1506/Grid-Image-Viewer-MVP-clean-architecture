package cavista.interview.grid_viewer.core.base.view;

import android.content.Context;
import android.graphics.Typeface;

import com.crashlytics.android.Crashlytics;

import java.util.HashMap;


class FontCache {
    private static final HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(String fontName, Context context) {
        try {
            Typeface typeface = fontCache.get(fontName);
            if (typeface == null) {
                try {
                    typeface = Typeface.createFromAsset(context.getAssets(), fontName);
                } catch (Exception e) {
                    return null;
                }

                fontCache.put(fontName, typeface);
            }

            return typeface;
        }catch (Exception e){
            e.printStackTrace();
            Crashlytics.logException(e);
        }
        return null;
    }
}
