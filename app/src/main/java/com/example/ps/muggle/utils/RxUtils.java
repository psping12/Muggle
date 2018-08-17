package com.example.ps.muggle.utils;

import com.example.ps.muggle.http.exception.ApiException;
import com.example.ps.muggle.model.bean.RootBean;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxUtils {


    /**
     * 简化处理 一般用于网络请求
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> applyScheduler() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 返回数据带RootBean
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<RootBean<T>, RootBean<T>> handleFKResult() {
        return new FlowableTransformer<RootBean<T>, RootBean<T>>() {
            @Override
            public Flowable<RootBean<T>> apply(Flowable<RootBean<T>> upstream) {
                return upstream.flatMap(new Function<RootBean<T>, Flowable<RootBean<T>>>() {
                    @Override
                    public Flowable<RootBean<T>> apply(RootBean<T> tRootBean) throws Exception {
                        if (tRootBean.isOk())
                            return createData(tRootBean);
                        else
                            return Flowable.error(new ApiException(tRootBean.getMsg(), tRootBean.getCode()));
                    }
                });
            }
        };
    }


    /**
     * 返回不带RootBean
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<RootBean<T>, T> handleFKResultNoRootBean() {
        return new FlowableTransformer<RootBean<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<RootBean<T>> upstream) {
                return upstream.flatMap(new Function<RootBean<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(RootBean<T> tRootBean) throws Exception {
                        if (tRootBean.isOk())
                            return createData(tRootBean.getData());
                        else
                            return Flowable.error(new ApiException(tRootBean.getMsg()));
                    }
                });
            }
        };
    }

    /**
     * 返回不带RootBean
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<RootBean, RootBean> handleFKResultRootBean() {
        return new FlowableTransformer<RootBean, RootBean>() {
            @Override
            public Flowable<RootBean> apply(Flowable<RootBean> upstream) {
                return upstream.flatMap(new Function<RootBean, Flowable<RootBean>>() {
                    @Override
                    public Flowable<RootBean> apply(RootBean tRootBean) throws Exception {
                        if (tRootBean.isOk())
                            return createData(tRootBean);
                        else
                            return Flowable.error(new ApiException(tRootBean.getMsg()));
                    }
                });
            }
        };
    }

    /**
     * 生成Flowable
     *
     * @param <T>
     * @return
     */
    private static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }


    public static <T> ObservableTransformer<T, T> applyObservableScheduler() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
