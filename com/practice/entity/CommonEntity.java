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

    protected String chessImgPath;

    private static final Integer imgWeight = 55;

    private static final Integer imgHeight = 55;

    public CommonEntity() {
        super();
        setBounds(0,0,imgWeight,imgHeight);
    }

}
