package com.lyambda.worker;

public class Worker {

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String error);
    }

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }


    public void start() {
        for (int i = 0; i < 10; i++) {
            if (i < 2) {
                callback.onDone("Задание " + (i + 1) + " выполнено!");
            } else if (i == 2) {
                errorCallback.onError("Задание " + (i + 1) + " завершилось с ошибкой.");
                break;
            }

        }
    }
}
