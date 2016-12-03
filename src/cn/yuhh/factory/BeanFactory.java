package cn.yuhh.factory;

import java.util.ResourceBundle;

/**
 * Created by Brill on 2016/12/3.
 */
public class BeanFactory {
    private static ResourceBundle bundle;

    static {
        bundle = ResourceBundle.getBundle("instance");
    }

    public static <T> T getInstance(String key, Class<T> clazz) {
        try {
            String className = bundle.getString(key);
            return (T) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
