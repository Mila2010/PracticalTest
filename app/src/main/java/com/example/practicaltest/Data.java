package com.example.practicaltest;

import java.util.List;

/**
 * Created by Millochka on 12/10/16.
 */

public class Data {

    private Long count;

    private String anchorStr;

    private List<Record> records;

    private Object previousPage;

    private String backAnchor;

    private Long anchor;

    private Integer nextPage;

    private Integer size;

    public Long getCount() {
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

    public Long getAnchor() {
        return anchor;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public Integer getSize() {
        return size;
    }
}
