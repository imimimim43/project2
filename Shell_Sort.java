public class Shell_Sort {
	 public static int[] shuffle(int[] arr){
		    for(int x=0;x<arr.length;x++){
		      int i = (int)(Math.random()*arr.length);
		      int j = (int)(Math.random()*arr.length);
		            
		      int tmp = arr[i];
		      arr[i] = arr[j];
		      arr[j] = tmp;
		    }
		        
		    return arr;
		  } //배열 값 랜덤으로 바꿀 때 사용하는 매소드
	public static void main(String[] args) {
		System.out.println("Shell_Sort");
		
		int N = 12;
		while(N >= 5 ) {
		long start = System.nanoTime();
		int size = (int) Math.pow(2, N);
		int[] arr = new int[size];
		//값이 정렬됐을 때
		/*for(int i = 0; i < arr.length; i++) {
				arr[i] = (i+1); 
		}*/
		//값이 역순일 때
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (arr.length-i*1); 
	}
		//값이 랜덤일 때
		for(int i = 0; i < arr.length; i++) {
				arr[i] = (i+1); 
				}
	        arr = shuffle(arr);

	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i] + " ");
	        }
		
		int interval = arr.length/2;// 간격은 배열의 크기 /2
		
		while (interval >= 1) { // 간격이 0이 될 때까지 실행.

			for (int i = 0; i < interval; i++) {
				// 같은 간격 값끼리 비교.
				for (int j = i + interval; j <= arr.length-1 ; j += interval) {
		            int item = arr[j];
		            int z = 0;
		            for (z = j - interval; z >= i && item < arr[z]; z -= interval) {
		                // arr[z]의 값이 크니까 삽입
		                arr[z + interval] = arr[z];
		            }
		            //삽입 끝났으니 기억해둔 값 삽입
		            arr[z + interval] = item;
		        }
		    }
			interval /= 2;
	   }
			
		for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    	//끝나는 시점의 시간에서 시작 시간을 빼는 것.
    	double run = (System.nanoTime()-start);
    	System.out.println("수행시간 : "+ run + " ns");
    	System.out.println();
    	System.out.println();
    	N--;
		}
	}
}
