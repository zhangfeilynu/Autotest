package sort;

public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
		System.out.println("排序之前：");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
			if(i!=a.length-1){
				System.out.print(",");
			}
		}
				
		//打印排序结果
		Sort sort=new Sort();
		//sort.insertSort(a);
		//sort.barnarySort(a);
		//sort.shellSort(a);
		sort.selectSort(a);
		System.out.println();
		System.out.println("排序之后：");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
			if(i!=a.length-1){
				System.out.print(",");
			}
		}

	}
	
	/**
	 * 直接插入排序、稳定、时间复杂度O(n2)
	 * @param array
	 */
	public  void insertSort(int[] array){
		for(int i=1;i<array.length;i++){//第0位独自作为有序数列，从第1位开始向后遍历
			if(array[i]<array[i-1]){//0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，否则认为0~i位也是有序的，忽略此次
				int temp=array[i];//保存第i位的值
				int k=i-1;
				for(int j=k;j>=0 && temp<array[j];j--){//从第i-1位向前遍历并移位，直至找到小于第i位值停止
					array[j+1]=array[j];
					k--;
				}
				array[k+1]=temp;//插入第i位的值
			}
		}
	}
	
	/**
	 * 二分法插入排序、稳定、时间复杂度O(n2)
	 * @param a
	 */
	public void barnarySort(int[] array){
		for(int i=0;i<array.length;i++){
			int temp=array[i];
			int left=0;
			int right=i-1;
			int mid=0;
			while(left<=right){
				mid=(left+right)/2;
				if(temp<array[mid]){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}
			for(int j=i-1;j>=left;j--){
				array[j+1]=array[j];
			}
			if(left!=i){
				array[left]=temp;
			}
		}
	}
	
	/**
	 * 希尔排序、不稳定、时间复杂度O(nlogn)
	 * @param array
	 */
	public void shellSort(int[] array){
		int d=array.length;
		while(true){
			d=d/2;
			for(int x=0;x<d;x++){
				for(int i=x+d;i<array.length;i=i+d){
					int temp=array[i];
					int j;
					for(j=i-d;j>=0 && array[j]>temp;j=j-d){
						array[j+d]=array[j];
					}
					array[j+d]=temp;
				}
			}
			if(d==1){
				break;
			}
		}
		
		//方法2，好理解
		/*while(true){
            for(int i=0;i<d;i++){
                for(int j=i;j+d<array.length;j+=d){
                int temp;
                if(array[j]>array[j+d]){
                    temp=array[j];
                    array[j]=array[j+d];
                    array[j+d]=temp;
                    }
                }
            }
             
             
            if(d==1){break;}
            d--;
           }*/
	}
	
	/**
	 * 直接选择排序、不稳定、时间复杂度O(n2)
	 * @param array
	 */
	public void selectSort(int[] array){
		for(int i=0;i<array.length;i++){
			int min=array[i];
			int n=i;//最小数的索引
			for(int j=i+1;j<array.length;j++){
				if(array[j]<min){//找出最小数
					min=array[j];
					n=j;
				}
			}
			array[n]=array[i];
			array[i]=min;
		}
	}
	
	
	

}
