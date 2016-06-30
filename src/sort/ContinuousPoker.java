package sort;
import java.util.Arrays;
import java.util.Random;
public class ContinuousPoker {

	/** 
     * Q67 扑克牌的顺子 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。 
     * 2-10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。 
     */
	private static final int[] poker={
		0,0,
		1,2,3,4,5,6,7,8,9,10,11,12,13,
		1,2,3,4,5,6,7,8,9,10,11,12,13,
		1,2,3,4,5,6,7,8,9,10,11,12,13,
		1,2,3,4,5,6,7,8,9,10,11,12,13,
	};
	
	private static final int MAX=5;
	private static final int MAX_VAL=13;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test 1.测试的具体数据.  
        int[][] testData = {   
                { 7, 8, 0, 10, 11 },   
                { 7, 8, 0, 0, 11 },  
                { 8, 9, 9, 10, 11 },   
                { 7, 8, 9, 10, 11 },   
                { 0, 8, 0, 10, 11 },   
                };  
        for (int[] pokerSelected : testData) {  
            test(pokerSelected);  
        }  
        // test 2.模拟真实情况：随机选择5个扑克.  
        int[] pokerSelected = randomSelect(poker, MAX);  
        test(pokerSelected);
        
	}
	
	public static void test(int[] pokerSelected){
		System.out.print("所选牌型："+Arrays.toString(pokerSelected));
		boolean continuous = isContinuous(pokerSelected);  
        System.out.println("是否顺子： " + continuous);
	}
	
	/* 
     * 1）确认5张牌中除了0，其余数字没有重复的（可以用表统计的方法）;  
     * 2) 
     * 满足这样的逻辑：（max，min分别代表5张牌中的除0以外的最大值最小值） 如果没有0，则max-min=4，则为顺子，否则不是 
     * 如果有一个0，则max-min=4或者3，则为顺子，否则不是 如果有两个0，则max-min=4或者3或者2，则为顺子，否则不是 
     *  
     * 最大值和最小值在第1步中就可以获得 
     */
	public static boolean isContinuous(int[] x){
		int[] existTimes=new int[MAX_VAL+1];
		boolean result=false;
		int len=x.length;
		int max=x[0],min=x[0];
		int zeroCount=0;
		for(int i=0;i<len;i++){
			existTimes[x[i]]++;//记录次数
			if(x[i]==0){
				zeroCount++;
			}else{
				if(x[i]>max || max==0)
					max=x[i];
				if(x[i]<min || min==0)
					min=x[i];
			}			
		}
		
		for(int i=1;i<MAX_VAL;i++){//从1开始，排除0
			if(existTimes[i]>1){//重复非零元素
				return false;
			}
		}
		
		if(zeroCount==0){
			if(max-min==MAX-1)
				result=true;
		}else if(zeroCount==1){
			if(max-min==MAX-1||max-min==MAX-2)
				result=true;
		}else if(zeroCount==2){
			if(max-min==MAX-1||max-min==MAX-2||max-min==MAX-3)
				result=true;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param data 计数选择的元素
	 * @param count 数据数组
	 * @return
	 */
	public static int[] randomSelect(int[] data, int count) {  
        int[] result = new int[count];  
        int len = data.length;  
        for (int i = 0; i < count; i++) {  
            Random random = new Random();  
            int pos = random.nextInt(len);  
            result[i] = data[pos];//选择元素 ，
            data[pos] = data[len - 1];//并用最后一个元素替换它  
            len--;
        }
        return result;  
    }  

}
