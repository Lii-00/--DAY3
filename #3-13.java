/*
题目：#13将罗马数字转为整型

*/

class Solution {
    public int romanToInt(String s) {
        int len = s.length();                   //获取字符串长度
        char ch;                                //声明字符串中取单个字符
        int romToInt = 0;                       //罗马数字转换后的整数
        int ifMin = 0;                          //用于判断是否存在特殊情况
        int argu = 1;                           //乘数引数
        int get_int = 0;                        //获取单个罗马数字对应的int型数字
        for(int i = 0;i < len ;i++){
            get_int = getValue(s.charAt(i));
            if(i + 1 != len){
                ifMin = get_int < getValue(s.charAt(i+1)) ? -2 : 0;     //若存在特殊情况，为ifMin赋值-2
            }else{
                ifMin = 0;
            }
            //若存在特殊情况，则在正常按位加后减去相应多余的数
            if(get_int < 10){                   
                argu = 1;
            }else if(get_int >= 10 && get_int < 100){
                argu = 10;
            }else{
                argu = 100;
            }
            romToInt += (get_int) + (ifMin * argu);   
        }
        return romToInt;
    }

    //获取罗马数字对应的int型数据值
    public int getValue(char ch){
        switch(ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}