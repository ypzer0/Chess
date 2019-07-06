package com.practice.location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 存储棋子所有可能的落点
 * @author 杨鹏
 */
public class PieceRouting {

    public List<Integer[]> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<Integer[]> ruleList) {
        this.ruleList = ruleList;
    }

    protected List<Integer[]> ruleList =new ArrayList<>();

    public boolean judgeLegal(Integer[] location){
        for (Integer[] locationGuess : ruleList) {
            if(Arrays.equals(location,locationGuess)){
                return true;
            }
        }
        return false;
    }

}
