package com.sample.mylibs.NetworkTest;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by haoyundong on 2018/5/14.
 */

public class TaskQueue {

    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;

    private NetDispatcher[] mDispatchers;

    private BaseNetRequest network;
    private final PriorityBlockingQueue<NetTask> mNetworkQueue = new PriorityBlockingQueue<>();

    public TaskQueue(BaseNetRequest network) {
        this.network = network;
        mDispatchers = new NetDispatcher[DEFAULT_NETWORK_THREAD_POOL_SIZE];
        start();
    }

    public void add(NetTask task) {
        if (task == null) {
            return;
        }

        mNetworkQueue.add(task);
    }

    public void start() {
        stop();

        for (int i = 0; i < mDispatchers.length; i++) {
            NetDispatcher networkDispatcher = new NetDispatcher(mNetworkQueue, network);
            mDispatchers[i] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void stop() {
        for (int i = 0; i < mDispatchers.length; i++) {
            if (mDispatchers[i] != null) {
                mDispatchers[i].quit();
            }
        }
    }
}
