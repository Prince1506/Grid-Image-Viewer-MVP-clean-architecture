package cavista.interview.grid_viewer.core.network.dataFactory;

import android.content.Context;
import javax.inject.Inject;
import cavista.interview.grid_viewer.core.network.NetworkHelper;

public class DstvAfricaApis {

    @Inject
    NetworkHelper networkHelper;

    @Inject
    public DstvAfricaApis(Context context) {
        Context mContext = context;
    }
}
