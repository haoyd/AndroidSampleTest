package com.sample.mylibs.NetworkTest;

import java.util.concurrent.BlockingQueue;

/**
 * Created by haoyundong on 2018/5/14.
 */

public class NetDispatcher extends Thread {

    private final BlockingQueue<NetTask> mQueue;
    private BaseNetRequest mNetwork;

    public NetDispatcher(BlockingQueue<NetTask> queue, BaseNetRequest network) {
        mQueue = queue;
        mNetwork = network;
    }

    @Override
    public void run() {
        NetTask task = null;
        while (true) {
            try {
                task = mQueue.take();
                String result = task.getMethod() == Method.GET ? mNetwork.get(task.getUrl(), task.getParams()) : mNetwork.post(task.getUrl(), task.getParams());

                if (result != null) {
                    task.getListener().onResponse(result);
                } else {
                    task.getListener().onError(new ErrorClass(1, "网络错误"));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                if (task != null) {
                    task.getListener().onError(new ErrorClass(1, "网络错误"));
                }
            }
        }
    }

    public void addTask(NetTask task) {
        if (task != null) {
            mQueue.add(task);
        }
    }

    public void quit() {
        interrupt();
    }
}
