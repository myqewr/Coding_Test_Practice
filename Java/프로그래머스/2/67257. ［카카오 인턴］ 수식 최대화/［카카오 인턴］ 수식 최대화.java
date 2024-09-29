import java.util.*;
import java.util.stream.Collectors;
class Solution {
    
    public long dfs(List<String> operator, List<Long> operand, String op,List<String> operatorList){
        operatorList.remove(op);
        
        int num = Long.valueOf(operator.stream().filter(o->o.equals(op)).count()).intValue();
        long result = 0;
        for(int i=0;i<num;i++){
            int index = operator.indexOf(op);
            if(op.equals("m")){
                result = operand.get(index) - operand.get(index+1);
                operand.remove((int)index);
                operand.add(index, result);
                operand.remove((int)index+1);
                operator.remove((int)index);
            }
            else if(op.equals("p")){
                result = operand.get(index) + operand.get(index+1);
                operand.remove((int)index);
                operand.add(index, result);
                operand.remove((int)index+1);
                operator.remove((int)index);
            }
            else if(op.equals("g")){
                result = operand.get(index) * operand.get(index+1);
                operand.remove((int)index);
                operand.add(index, result);
                operand.remove((int)index+1);
                operator.remove((int)index);
            }
         }
        
        if(operatorList.size()==0){return Math.abs(operand.get(0));}
        
        long max = 0;
        for(String nextOp : operatorList){
            List<String> newOperator= new ArrayList<>(operator);
            List<Long> newOperand= new ArrayList<>(operand);
            List<String> newOpList= new ArrayList<>(operatorList);
            max = Math.max(max,dfs(newOperator,newOperand,nextOp,newOpList));
        }
        return max;
        
    }
    
    
    public long solution(String expression) {
        //사용 가능한 연산자와 피연산자 순서대로 정리
        List<String> operator = new ArrayList<>();
        List<Long> operand = new ArrayList<>();
        char[] chars = expression.toCharArray();
        int lastIndex = 0;
        for(int i=0;i<chars.length;i++){
            if(String.valueOf(chars[i]).equals("-")){
                operator.add("m");
                operand.add(Long.valueOf(expression.substring(lastIndex,i)));
                lastIndex=i+1;}
            if(String.valueOf(chars[i]).equals("+")){
                operator.add("p");
                operand.add(Long.valueOf(expression.substring(lastIndex,i)));
                lastIndex=i+1;}
            if(String.valueOf(chars[i]).equals("*")){
                operator.add("g");
                operand.add(Long.valueOf(expression.substring(lastIndex,i)));
                lastIndex=i+1;}
        }
        operand.add(Long.valueOf(expression.substring(lastIndex,chars.length)));
        
        List<String> operatorList = operator.stream().distinct().collect(Collectors.toList());
        long max = 0;
        for(String op : operatorList){
            List<String> newOperator = new ArrayList<>(operator);
            List<Long> newOperand = new ArrayList<>(operand);
            List<String> newOpList= new ArrayList<>(operatorList);
            max = Math.max(max,dfs(newOperator,newOperand, op, newOpList));
        }

        return max;
    }
}