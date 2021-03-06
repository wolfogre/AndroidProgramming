package wolfogre.kh2_1_calculator;

/**
 * Created by Administrator on 12/05/2015.
 */
public class Analyser {
    public static double analy(String expression) throws Exception{
        expression = expression.replace('＋', operators[0]);
        expression = expression.replace('－', operators[1]);
        expression = expression.replace('×', operators[2]);
        expression = expression.replace('x', operators[2]);
        expression = expression.replace('X', operators[2]);
        expression = expression.replace('÷', operators[3]);
        for(char ch : expression.toCharArray()){
            if("1234567890.".indexOf(ch) == -1 && !isOperator(ch))
                throw new Exception("输入有误");
        }
        try{
            return analyHelp(expression);
        }
        catch(Exception ex){
            throw new Exception("输入有误");
        }
    }

    private static char[] operators = {'+','-','*','/'};

    private static double analyHelp(String expression)
    {
        int index = findLastOperator(expression);
        if(index == -1)
            return Double.parseDouble(expression);
        if(expression.charAt(index) == operators[0])
            return analyHelp(expression.substring(0, index)) + analyHelp(expression.substring(index + 1, expression.length()));
        if(expression.charAt(index) == operators[1])
            return analyHelp(expression.substring(0, index )) - analyHelp(expression.substring(index + 1, expression.length()));
        if(expression.charAt(index) == operators[2])
            return analyHelp(expression.substring(0, index)) * analyHelp(expression.substring(index + 1, expression.length()));
        return analyHelp(expression.substring(0, index)) / analyHelp(expression.substring(index + 1, expression.length()));
    }

    private static int findLastOperator(String expression){
        for(int  i = expression.length() - 1; i >= 0; --i){
            if(isAddOrSub(expression.charAt(i)) && i != 0 && !isOperator(expression.charAt(i - 1)))
                return i;
        }
        for(int  i = expression.length() - 1; i >= 0; --i){
            if(isOperator(expression.charAt(i)) && i != 0 && !isOperator(expression.charAt(i - 1)))
                return i;
        }
        return -1;
    }

    private static boolean isAddOrSub(char ch){
        if(ch == operators[0] || ch == operators[1])
            return true;
        return false;
    }

    private static boolean isOperator(char ch){
        if(ch == operators[2] || ch == operators[3])
            return true;
        return isAddOrSub(ch);
    }
}
