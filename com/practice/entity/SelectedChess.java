package com.practice.entity;

import com.practice.constant.CommonConstant;

import javax.swing.ImageIcon;

/**
 * @author 杨鹏
 */
public class SelectedChess extends CommonEntity {

    public SelectedChess(){
        super();
        setIcon(new ImageIcon(CommonConstant.CHESS_IMAGE_PATH+"r_box.png"));
        setLocation(CommonConstant.originLocationX,CommonConstant.originLocationY);
    }
}
