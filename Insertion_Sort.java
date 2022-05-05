public class Insertion_Sort{
	
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
	public static void main(String[] args) {
		System.out.println("Insertion_Sort");
		
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
	        
	    for(int i=0; i<arr.length; i++) {
	    	int tmp = arr[i];
	    	int prev = i - 1;
	    	
	    	while(prev >= 0 && arr[prev] > tmp) {
	    		arr[prev + 1] = arr[prev];
	    		prev--;
	    	}
	    	arr[prev + 1] = tmp;
	    }
	    
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
