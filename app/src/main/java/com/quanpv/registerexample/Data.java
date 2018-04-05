package com.quanpv.registerexample;

import java.io.Serializable;
import java.util.List;

/**
 * Created by QuanPV on 4/2/18.
 */

public class Data implements Serializable {

    private String title;
    private List<String> content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
