## 정렬 알고리즘(+퀵정렬)의 성능 분석 및 비교
<ol>
<li>값 정렬 설명</li>
<li>각 알고리즘 설명 및 그래프 분석</li>
</ol>
<br>

## 값 정렬 하기
각 알고리즘마다 정렬된 배열값, 역순으로 정렬된 배열값, 랜덤으로 정렬된 배열값을 넣어 비교해볼 것이다. 입력개수를 **2^20값**까지 넣었어야했으나, **2^20값**까지의 값을 넣으면 이클립스가 실행되지 않아 2^5 ~ 2^12까지 넣어 실행시켰다.

### 코드 구현
 **코드에 쓰일 배열 선언**
 
 ■ 배열 정렬시키는 코드
```
for(int i = 0; i < arr.length; i++) {
				arr[i] = (i+1); 
		}

```
 ■ 배열 역순으로 정렬시키는 코드
```
for(int i = 0; i < arr.length; i++) {
			arr[i] = (arr.length-i*1); 
	}

```
 ■ 값을 랜덤으로 정렬시키는 코드
```
 public static int[] shuffle(int[] arr){
		    for(int x=0;x<arr.length;x++){
		      int i = (int)(Math.random()*arr.length);
		      int j = (int)(Math.random()*arr.length);
		            
		      int tmp = arr[i];
		      arr[i] = arr[j];
		      arr[j] = tmp;
		    }
      
      for(int i = 0; i < arr.length; i++) {
				arr[i] = (i+1); 
				}
	        arr = shuffle(arr);

```
## 쉘 정렬(Shell_Sort)
■ 쉘 정렬(Shell_Sort)

<br>

![image](https://user-images.githubusercontent.com/102197100/166949468-f1e3dadf-eaee-407d-893b-422c829f14bf.png)

<br>

<br>

- **삽입 정렬을 개선한 정렬 알고리즘**으로, 쉘 정렬은 일정한 gap을 기준으로 띄엄띄엄 정렬하게 된다. gap은 배열의 size를 0이 될때까지 2로 나누는 방식으로 지정했다. 

<br>


### 코드 구현

```
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
		            //삽입 끝낫으니 기억해둔 값 삽입
		            arr[z + interval] = item;
		        }
		    }
			interval /= 2;
	   }
```

<br>

![image](https://user-images.githubusercontent.com/102197100/166903427-4bd1c801-258d-4326-ad6d-19e5147d39a0.png)


<br>

- **쉘 정렬**로 정렬, 역순, 랜덤 배열 값을 정렬한 결과, 위 그래프가 그려졌는데 입력 값이 2^12으로 갈수록 랜덤, 정렬,  순으로 정렬 시간이 점점 길어지는 것을 알 수 있다.

<br>

## 퀵 정렬(Quick_Sort)
■ 퀵 정렬(Quick_Sort)

<br>

![image](https://user-images.githubusercontent.com/102197100/166949327-7f279124-a12e-467a-9da9-bc86e19ec1a8.png)

<br>

<br>

- 분할, 정복을 이용해서 정렬을 수행하며 pivot를 정하여 왼쪽으로는 pivot보다 낮은 값을 정렬하고 오른쪽으로는 pivot보다 높은 값으로 정렬한다. pivot은 배열 가운데 요소를 선택하면 되고 pivot를 기준으로 왼쪽, 오른쪽을 재귀호출 시켜주면 된다.

<br>


### 코드 구현

```
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
```

<br>

![image](https://user-images.githubusercontent.com/102197100/166902442-033dce8b-745b-4bf8-b4d4-d542ab6b3f60.png)

<br>

- **퀵 정렬**로 정렬, 역순, 랜덤 배열 값을 정렬한 결과, 위 그래프가 그려졌는데 쉘 정렬과 같이 입력 값이 2^12으로 갈수록 랜덤, 정렬,  순으로 정렬 시간이 점점 길어지는 것을 알 수 있다.

<br>

## 힙 정렬(Heap_Sort)
■ 힙 정렬(Heap_Sort)

<br>

![image](https://user-images.githubusercontent.com/102197100/166949202-94ff3df5-02fe-42b8-b6ba-652d29da69dc.png)

<br>

<br>

- 힙 트리 구조를 이용한 정렬 방법이며 내림차순 정렬에는 최대 힙을 구성하고 , 오름차순 정렬에는 최소 힙을 구성하면 된다. 자바에는 quere가 이미 구현되어 있기 때문에 그것을 이용하면 쉽게 구현할 수 있다.

<br>


### 코드 구현

```
Queue H = new PriorityQueue();
    
    for(int i=0; i<arr.length; i++)
        H.offer(arr[i]); //offer 값을 넣기

    Object obj = null;
    int a = 0;
    while((obj = H.poll())!=null) //poll 값을 빼기
        System.out.printf("%s ",obj);
```

<br>

![image](https://user-images.githubusercontent.com/102197100/166901583-85e194ed-589b-468b-a57f-3157b258b7cd.png)

<br>

- **힙 정렬**로 정렬, 역순, 랜덤 배열 값을 정렬한 결과, 위 그래프가 그려졌는데 입력 값이 2^12으로 갈수록 정렬, 랜덤, 역순 순으로 정렬 시간이 점점 길어지는 것을 알 수 있다.

<br>

## 삽입 정렬(Insertion_Sort)
■ 섭입 정렬(Insertion_Sort)

<br>

![image](https://user-images.githubusercontent.com/102197100/166949067-aecf70cb-6c97-464d-8c5f-8c781c174a67.png)

<br>

<br>

- 아직 정렬되지 않은 임의의 값을 이미 정렬된 부분의 적절한 위치에 삽입해가며 정렬하는 방식이다.

<br>


### 코드 구현

```
   for(int i=0; i<arr.length; i++) {
	    	int tmp = arr[i]; //tmp에 우선 배열 값 넣어두기
	    	int prev = i - 1; //tmpm의 왼쪽 배열 값
	    	
	    	while(prev >= 0 && arr[prev] > tmp) { // 왼쪽 배열 값의 크기가 크다면
	    		arr[prev + 1] = arr[prev]; //오른쪽으로 옮기기
	    		prev--;
	    	}
	    	arr[prev + 1] = tmp;
	    }
```


<br>
![image](https://user-images.githubusercontent.com/102197100/166901077-d5ad4711-8e13-4107-a2e4-852a0515e27d.png)

<br>

- **삽입 정렬**로 정렬, 역순, 랜덤 배열 값을 정렬한 결과, 위 그래프가 그려졌는데 입력 값이 2^12으로 갈수록 랜덤, 역순, 정렬 순으로 정렬 시간이 점점 길어지는 것을 알 수 있다.

<br>

## 버블 정렬(Bubble_Sort)
■ 버블 정렬(Bubble_Sort)

<br>

![image](https://user-images.githubusercontent.com/102197100/166948923-0a47ffc9-5541-4778-a244-3da20d6b2254.png)

<br>

<br>

![image](https://user-images.githubusercontent.com/102197100/166948634-f38b4d97-d595-4769-bc65-5e74f3a9a651.png)

<br>

<br>

- 서로 이웃한 데이터들을 비교하며 가장 큰 데이터를 가장 뒤로 보내며 정렬하는 방식이다.

<br>


### 코드 구현

```
for(int i = 0; i <arr.length;i++) {
				for(int j = 0; j < arr.length - 1 -i; j++) {
					if(arr[j] > arr[j+1]) {
						int tmp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = tmp;
					}
				}
			}	
```



<br>

![image](https://user-images.githubusercontent.com/102197100/166898149-007becf0-ada9-4577-90ff-ee1deb9514ac.png)

<br>

- **버블 졍렬**로 정렬, 역순, 랜덤 배열 값을 정렬한 결과, 위 그래프가 그려졌는데 입력 값이 2^12으로 갈수록 랜덤, 정렬, 역순 순으로 정렬 시간이 점점 짧아지는 것을 알 수 있다. 다른 정렬들과 달리 모든 입력 값의 정렬 시간이 비슷한 것을 알 수 있다.

<br>

## 선택 정렬(Selection_Sort)
■ 선택 정렬(Selection_Sort)

<br>

- 정렬되지 않은 값들 중 가장 작은 데이터, 최솟값을 찾아 제일 왼쪽의 값과 swap하는 정렬이다.

<br>


### 코드 구현

```
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
```



<br>

![image](https://user-images.githubusercontent.com/102197100/166899583-561ee105-781d-4d48-921d-d90b377417af.png)

<br>

- **선택 졍렬**로 정렬, 역순, 랜덤 배열 값을 정렬한 결과, 위 그래프가 그려졌는데 입력 값이 2^12으로 갈수록 랜덤, 역순, 정렬 순으로 정렬 시간이 점점 길어지는 것을 알 수 있다. 
