package com.zjz.threadDemo0001.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListUtils
 * @Author Junzhou Zhang
 * @Create 2022/8/13 20:10
 */
public class ListUtils {
    /**
     * 实现分页的功能，将userEntity分成不同的线程
     * @param list
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
        int listSize = list.size();
        int page = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>> listArray = new ArrayList<List<T>>();
        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<T>();
            for (int j = 0; j < listSize; j++) {
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                if (pageIndex == (i + 1)) {
                    subList.add(list.get(j));
                }
                if ((j + 1) == ((j + 1) * pageSize)) {
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }
}
