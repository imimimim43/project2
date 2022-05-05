public class Bubble_Sort{
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
		//시작 시간 저장.
		long start = System.nanoTime();
		int N = 5;
		
		while(N >= 5) {
			int size = (int) Math.pow(2, N);
			int[] arr = new int[size];
			
			for(int i = 0; i < arr.length; i++) {
				arr[i] = (i+1); 
			}
			//값이 역순일 때
		/*	for(int i = 0; i < arr.length; i++) {
					arr[i] = (arr.length-i*1); 
			}*/
				//값이 랜덤일 때
			/*for(int i = 0; i < arr.length; i++) {
			  	arr[i] = (i+1); 
			}
			arr = shuffle(arr);*/
			for(int i = 0; i <arr.length;i++) {
				for(int j = 0; j < arr.length - 1 -i; j++) {
					if(arr[j] > arr[j+1]) {
						int tmp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = tmp;
					}
				}
			}	

			for(int i =0 ; i < arr.length; i++) {
				System.out.printf("%d ", arr[i]);
			}
			System.out.println();
			//끝나는 시점의 시간에서 시작 시간을 빼는 것.
			double run = (System.nanoTime()-start);
			System.out.println("수행시간 : "+ run + " ns");
			System.out.println();
			N--;
		}
	}
}
