package com.practice.entity;

import com.practice.constant.CommonConstant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author 杨鹏
 */
public class CommonEntity extends JLabel{

    private static final Integer IMG_WEIGHT = 55;

    private static final Integer IMG_HEIGHT = 55;
    /**
     * 用于存储选取的棋子对象信息
     */
    private Integer[] selectedArray;

    public Integer[] getSelectedArray() {
        return selectedArray;
    }

    public void setSelectedArray(Integer[] selectedArray) {
        this.selectedArray = selectedArray;
    }

    public CommonEntity() {
        super();
        setBounds(0,0,IMG_WEIGHT,IMG_HEIGHT);
    }

}
