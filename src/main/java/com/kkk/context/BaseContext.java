package com.kkk.context;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/9/23 9:08
 * @Version V1.0
 */
public class BaseContext {
    public static final ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setUserId(Long id) {
        threadLocal.set(id);
    }

    public static Long getUserId() {
        return threadLocal.get();
    }

    public static void removeUserId() {
        threadLocal.remove();
    }
}
