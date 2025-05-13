package org.basicjavaapi.study.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AcceptEitherTest {
        public static void main(String[] args) {
            //第一个异步任务，休眠2秒，保证它执行晚点
            CompletableFuture<String> first = CompletableFuture.supplyAsync(()->{
                try{
                    Thread.sleep(2000L);
                    System.out.println("执行完第一个异步任务");}
                catch (Exception e){
                    return "第一个任务异常";
                }
                return "第一个异步任务";
            });
            ExecutorService executor = Executors.newSingleThreadExecutor();
            CompletableFuture<Void> future = CompletableFuture
                    //第二个异步任务
                    .supplyAsync(() -> {
                                try {
                                    Thread.sleep(2000L);
                                    System.out.println("执行完第二个任务");
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                return "第二个任务";}
                            , executor)
                    //第三个任务
                    .acceptEitherAsync(first, result->System.out.println("----"+result), executor);
            try {
                Thread.sleep(4000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            executor.shutdown();
        }
    }

