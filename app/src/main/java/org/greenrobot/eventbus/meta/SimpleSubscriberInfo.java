package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

/**
 * Uses {@link SubscriberMethodInfo} objects to create {@link SubscriberMethod} objects on demand.
 * 使用 SubscriberMethodInfo 对象根据需要创建 SubscriberMethod 对象。
 */
public class SimpleSubscriberInfo extends AbstractSubscriberInfo {

    private final SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(Class subscriberClass, boolean shouldCheckSuperclass, SubscriberMethodInfo[] methodInfos) {
        super(subscriberClass, null, shouldCheckSuperclass);
        this.methodInfos = methodInfos;
    }

    @Override
    public synchronized SubscriberMethod[] getSubscriberMethods() {
        int length = methodInfos.length;
        SubscriberMethod[] methods = new SubscriberMethod[length];
        for (int i = 0; i < length; i++) {
            SubscriberMethodInfo info = methodInfos[i];
            methods[i] = createSubscriberMethod(info.methodName, info.eventType, info.threadMode,
                    info.priority, info.sticky);
        }
        return methods;
    }
}