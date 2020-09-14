package com.twu.refactoring;

public class TimeDate {
    private int start;
    private int end;
    private int min;
    private int max;
    private String type;
    private String s;
    private String s2;
    private String s3;

    public TimeDate(int start, int end, int min, int max, String type) {
        this.start = start;
        this.end = end;
        this.min = min;
        this.max = max;
        this.type = type;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
