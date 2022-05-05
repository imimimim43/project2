public class Selection_Sort {
	
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
	     for(int i = 0 ; i < arr.length; i++) {
				int min = arr[i]; // 맨 왼쪽 값을 최소값으로 설정
				int idx = i;
				
				//최솟값 (인덱스) 찾기
				for(int j =i; j <arr.length; j++) {
					if(min > arr[j]) {
						min = arr[j];
						idx = j;
					}
				}
				// 제일 왼쪽값이랑 최솟값이랑 교환.
				int tmp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = tmp;
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
