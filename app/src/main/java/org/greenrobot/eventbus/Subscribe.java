package org.greenrobot.eventbus;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented  // 命名为 java doc 文档
@Retention(RetentionPolicy.RUNTIME) // 指定在运行时有效，即在运行时能保持这个 Subscribe
@Target({ElementType.METHOD})  // 指定类型为 METHOD，表名用来描述方法
public @interface Subscribe {

    // 指定线程模式，可以指定在 Subscribe 中接收的 Event 所处的线程
    ThreadMode threadMode() default ThreadMode.POSTING;  // 订阅线程的模式，默认从哪个线程发送，就从哪个线程订阅

    /**
     * If true, delivers the most recent sticky event (posted with
     * {@link EventBus#postSticky(Object)}) to this subscriber (if event available).
     * 粘性事件是事件消费者在事件发布之后才注册，依然能接收到该事件的特殊类型。
     */
    boolean sticky() default false;

    /** Subscriber priority to influence the order of event delivery.
     * Within the same delivery thread ({@link ThreadMode}), higher priority subscribers will receive events before
     * others with a lower priority. The default priority is 0. Note: the priority does *NOT* affect the order of
     * delivery among subscribers with different {@link ThreadMode}s!
     * 数值越高优先级越大，越先接收事件
     * */
    int priority() default 0;
}

