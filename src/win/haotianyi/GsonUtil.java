package win.haotianyi;

import com.google.gson.Gson;

/**
 * Created by 天 on 2017/7/12.
 */
public class GsonUtil {
    private static Gson mGson;

    private GsonUtil() {
    }

    public static Gson getInstance() {
        if (mGson == null) {
            synchronized (GsonUtil.class) {
                if (mGson == null) {
                    mGson = new Gson();
                }
            }
        }
        return mGson;
    }

}
