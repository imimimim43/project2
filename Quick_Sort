public class Quick_Sort {
	 public static int[] shuffle(int[] arr){
			    for(int x=0;x<arr.length;x++){
			      int i = (int)(Math.random()*arr.length);
			      int j = (int)(Math.random()*arr.length);
			            
			      int tmp = arr[i];
			      arr[i] = arr[j];
			      arr[j] = tmp;
			    }
			        
			    return arr;
			  }
    
    public void sort(int[] arr, int l, int r){
        int left = l;
        int right = r;
        int pivot = arr[(l+r)/2];
        
        do{
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;
            if(left <= right){    
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);
        
        if(l < right) sort(arr, l, right);
        if(r > left) sort(arr, left, r);
    }
    
    public static void main(String[] args) {
    	System.out.println("Quick_Sort");
    	
    	int N = 12;
		while(N >= 5 ) {
		long start = System.nanoTime();
		int size = (int) Math.pow(2, N);
		int[] arr = new int[size];
        
		//값이 정렬됐을 때
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i+1); 
		}
		//값이 역순일 때
		/*for(int i = 0; i < arr.length; i++) {
					arr[i] = (arr.length-i*1); 
			}*/
				//값이 랜덤일 때
		/*for(int i = 0; i < arr.length; i++) {
			arr[i] = (i+1); 
		}
		arr = shuffle(arr);*/
			        
        Quick_Sort quick = new Quick_Sort();
        quick.sort(arr, 0, arr.length - 1);
        for(int i =0 ; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
		//끝나는 시점의 시간에서 시작 시간을 빼는 것.
		double run = (System.nanoTime()-start);
		System.out.println("수행시간 : "+ run + " ns");
		N--;
    }
   }
}
