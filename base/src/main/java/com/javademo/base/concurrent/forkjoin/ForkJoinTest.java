package com.javademo.base.concurrent.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
    public static class MakeArray {

        // 数组最大长度
        public static int arrayLength = 3000000;
        // 任务拆分最小单位,拆分到这个单位就不能拆分了,即阈值
        public static int splitMixThreshold = (arrayLength / 10);


        public static int[] make() {
            int[] origin = new int[arrayLength];
            Random random = new Random();
            for (int i = 0; i < arrayLength; ++i) {
                origin[i] = random.nextInt(arrayLength * 3);
            }
            return origin;
        }

    }

    public class SumForkJoin {

        /**
         * 创建ForkJoin框架  递归进入任务拆分,递归出来任务结果累加
         **/
        static class SumTask extends RecursiveTask<Integer> {

            int[] recursiveArray;
            // 划分开始位置
            int form;
            // 划分结束位置
            int to;

            public SumTask(int[] recursiveArray, int form, int to) {
                this.recursiveArray = recursiveArray;
                this.form = form;
                this.to = to;
            }

            @Override
            protected Integer compute() {
                // 判断当前数组最小长度阈值,没有达到继续拆分
                if ((to - form) < MakeArray.splitMixThreshold) {
                    // 满足阈值的数组处理,累加
                    int count = 0;
                    for (int i = form; i < to; ++i) {
                        count += recursiveArray[i];
                    }
                    return count;
                } else {
                    // 数组长度划半
                    int half = (form + to) / 2;
                    // 递归拆分
                    SumTask left = new SumTask(recursiveArray, form, half);
                    SumTask right = new SumTask(recursiveArray, half + 1, to);
                    invokeAll(left, right);
                    // 等待最小阈值求和完毕在累加返回给上一层Join任务
                    return left.join() + right.join();
                }
            }

        }


    }


    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int[] array = MakeArray.make();
        SumForkJoin.SumTask sumTask = new SumForkJoin.SumTask(array, 0, array.length - 1);
        Long recordTime = System.currentTimeMillis();
        forkJoinPool.submit(sumTask);
        System.out.println("数组累加最终结果:" + sumTask.join() + ",耗时时长:" + (System.currentTimeMillis() - recordTime) + "ms");

    }

}
