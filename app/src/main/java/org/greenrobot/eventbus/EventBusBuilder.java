package org.greenrobot.eventbus;

import android.os.Looper;

import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Creates EventBus instances with custom parameters and also allows to install a custom default EventBus instance.
 * 使用自定义参数创建EventBus实例，并允许安装自定义默认EventBus实例
 * Create a new builder using {@link EventBus#builder()}.
 */
public class EventBusBuilder {

    // 这个就是我们的线程池了，异步任务，后台任务就要靠它来执行了
    private final static ExecutorService DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    boolean logSubscriberExceptions = true;  //订阅者异常日志
    boolean logNoSubscriberMessages = true;  //不要订阅者消息日志
    boolean sendSubscriberExceptionEvent = true; //是否发送订阅者异常
    boolean sendNoSubscriberEvent = true;  //是否发送无订阅者异常
    boolean throwSubscriberException;  // 是否抛出订阅者异常
    boolean eventInheritance = true;   // 是否继承事件
    boolean ignoreGeneratedIndex;      // 是否忽略生成的索引
    boolean strictMethodVerification; // 是否严格执行方法验证
    ExecutorService executorService = DEFAULT_EXECUTOR_SERVICE; // 默认线程池
    List<Class<?>> skipMethodVerificationForClasses;   // 需要跳过执行方法验证的类
    List<SubscriberInfoIndex> subscriberInfoIndexes;   // 订阅者信息索引
    Logger logger;
    MainThreadSupport mainThreadSupport;

    EventBusBuilder() {
    }

    /**
     * Default: true  订阅者异常日志，默认打印
     */
    public EventBusBuilder logSubscriberExceptions(boolean logSubscriberExceptions) {
        this.logSubscriberExceptions = logSubscriberExceptions;
        return this;
    }

    /**
     * Default: true  不要订阅者消息日志
     */
    public EventBusBuilder logNoSubscriberMessages(boolean logNoSubscriberMessages) {
        this.logNoSubscriberMessages = logNoSubscriberMessages;
        return this;
    }

    /**
     * Default: true   是否发送订阅者异常
     */
    public EventBusBuilder sendSubscriberExceptionEvent(boolean sendSubscriberExceptionEvent) {
        this.sendSubscriberExceptionEvent = sendSubscriberExceptionEvent;
        return this;
    }

    /**
     * Default: true  是否发送无订阅者异常
     */
    public EventBusBuilder sendNoSubscriberEvent(boolean sendNoSubscriberEvent) {
        this.sendNoSubscriberEvent = sendNoSubscriberEvent;
        return this;
    }

    /**
     * Fails if an subscriber throws an exception (default: false).
     * Tip: Use this with BuildConfig.DEBUG to let the app crash in DEBUG mode (only). This way, you won't miss
     * exceptions during development.
     * 使用buildconfig.debug可以使应用程序在调试模式下崩溃（仅限）。这样，您就不会错过开发过程中的异常。
     *
     * 是否抛出订阅者异常  默认为 false，可以在debug情况下设置为 true 进行调试
     */
    public EventBusBuilder throwSubscriberException(boolean throwSubscriberException) {
        this.throwSubscriberException = throwSubscriberException;
        return this;
    }

    /**
     * By default, EventBus considers the event class hierarchy (subscribers to super classes will be notified).
     * Switching this feature off will improve posting of events. For simple event classes extending Object directly,
     * we measured a speed up of 20% for event posting. For more complex event hierarchies, the speed up should be
     * >20%.
     * 默认情况下，EventBus考虑事件类层次结构（将通知父类的订户）。
     * 关闭此功能将改进事件发布。
     * 对于直接扩展对象的简单事件类，我们测量到事件发布的速度提高了20%。对于更复杂的事件层次结构，速度应大于20%
     * <p/>
     * However, keep in mind that event posting usually consumes just a small proportion of CPU time inside an app,
     * unless it is posting at high rates, e.g. hundreds/thousands of events per second.
     * 但是，请记住，事件发布通常只占用应用程序内部CPU时间的一小部分，除非它以高速率发布，例如每秒数百/数千个事件
     *
     * 是否继承事件，把这个功能关闭可以提高效率，默认为 true
     */
    public EventBusBuilder eventInheritance(boolean eventInheritance) {
        this.eventInheritance = eventInheritance;
        return this;
    }


    /**
     * Provide a custom thread pool to EventBus used for async and background event delivery. This is an advanced
     * setting to that can break things: ensure the given ExecutorService won't get stuck to avoid undefined behavior.
     * 为用于异步和后台事件传递的事件总线提供自定义线程池。
     * 这是一个高级设置，可以打断一些事件：确保给定的ExecutorService不会被卡住以避免未定义的行为
     */
    public EventBusBuilder executorService(ExecutorService executorService) {
        this.executorService = executorService;
        return this;
    }

    /**
     * Method name verification is done for methods starting with onEvent to avoid typos; using this method you can
     * exclude subscriber classes from this check. Also disables checks for method modifiers (public, not static nor
     * abstract).
     * 方法名验证是对以OnEvent开头的方法进行的，以避免出现错误；使用此方法，可以从该检查中排除订阅服务器类。
     * 还禁用对方法修饰符（公共、非静态或抽象）的检查
     */
    public EventBusBuilder skipMethodVerificationFor(Class<?> clazz) {
        if (skipMethodVerificationForClasses == null) {
            skipMethodVerificationForClasses = new ArrayList<>();
        }
        skipMethodVerificationForClasses.add(clazz);
        return this;
    }

    /**
     * Forces the use of reflection even if there's a generated index (default: false).
     * 强制使用反射，即使存在生成的索引（默认值：false）。
     * 使用索引可以大大提高效率
     */
    public EventBusBuilder ignoreGeneratedIndex(boolean ignoreGeneratedIndex) {
        this.ignoreGeneratedIndex = ignoreGeneratedIndex;
        return this;
    }

    /**
     * Enables strict method verification (default: false).
     * 启用严格的方法验证（默认值：false）
     */
    public EventBusBuilder strictMethodVerification(boolean strictMethodVerification) {
        this.strictMethodVerification = strictMethodVerification;
        return this;
    }

    /**
     * Adds an index generated by EventBus' annotation preprocessor.
     * 添加由EventBus的批注预处理器生成的索引，可以添加多个索引
     */
    public EventBusBuilder addIndex(SubscriberInfoIndex index) {
        if (subscriberInfoIndexes == null) {
            subscriberInfoIndexes = new ArrayList<>();
        }
        subscriberInfoIndexes.add(index);
        return this;
    }

    /**
     * Set a specific log handler for all EventBus logging. 为所有事件总线日志记录设置特定的日志处理程序。
     * <p/>
     * By default all logging is via {@link android.util.Log} but if you want to use EventBus
     * outside the Android environment then you will need to provide another log target.
     * 默认情况下，所有日志记录都是通过 android.util.log进行的，但如果您想在android环境之外使用eventbus，则需要提供另一个日志目标。
     */
    public EventBusBuilder logger(Logger logger) {
        this.logger = logger;
        return this;
    }

    Logger getLogger() {
        if (logger != null) {
            return logger;
        } else {
            // also check main looper to see if we have "good" Android classes (not Stubs etc.)
            return Logger.AndroidLogger.isAndroidLogAvailable() && getAndroidMainLooperOrNull() != null
                    ? new Logger.AndroidLogger("EventBus") :
                    new Logger.SystemOutLogger();
        }
    }


    MainThreadSupport getMainThreadSupport() {
        if (mainThreadSupport != null) {
            return mainThreadSupport;
        } else if (Logger.AndroidLogger.isAndroidLogAvailable()) {
            Object looperOrNull = getAndroidMainLooperOrNull();
            return looperOrNull == null ? null :
                    new MainThreadSupport.AndroidHandlerMainThreadSupport((Looper) looperOrNull);
        } else {
            return null;
        }
    }

    Object getAndroidMainLooperOrNull() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException e) {
            // Not really a functional Android (e.g. "Stub!" maven dependencies)
            return null;
        }
    }

    /**
     * Installs the default EventBus returned by {@link EventBus#getDefault()} using this builders' values. Must be
     * done only once before the first usage of the default EventBus.
     * 使用此生成器的值安装 eventbus getdefault（）返回的默认eventbus。在第一次使用默认事件总线之前只能执行一次
     * 所以在 Application 中执行
     * @throws EventBusException if there's already a default EventBus instance in place
     * 如果已经有了一个默认的eventbus实例，就抛出异常
     */
    public EventBus installDefaultEventBus() {
        synchronized (EventBus.class) {
            if (EventBus.defaultInstance != null) {
                throw new EventBusException("Default instance already exists." +
                        " It may be only set once before it's used the first time to ensure consistent behavior.");
            }
            EventBus.defaultInstance = build();
            return EventBus.defaultInstance;
        }
    }

    /**
     * Builds an EventBus based on the current configuration.
     * 基于当前配置生成事件总线
     */
    public EventBus build() {
        return new EventBus(this);
    }

}
