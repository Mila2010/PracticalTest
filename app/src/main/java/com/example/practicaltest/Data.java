package com.example.practicaltest;

import java.util.List;

/**
 * Created by Millochka on 12/10/16.
 */

public class Data {

    private Integer count;

    private String anchorStr;

    private List<Record> records;

    private Object previousPage;

    private String backAnchor;

    private Integer anchor;

    private Integer nextPage;

    private Integer size;

    public Integer getCount() {
        return count;
    }

    public String getAnchorStr() {
        return anchorStr;
    }

    public List<Record> getRecords() {
        return records;
    }

    public Object getPreviousPage() {
        return previousPage;
    }

    public String getBackAnchor() {
        return backAnchor;
    }

    public Integer getAnchor() {
        return anchor;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public Integer getSize() {
        return size;
    }
}
