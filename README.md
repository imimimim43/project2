## 정렬 알고리즘(+퀵정렬)의 성능 분석 및 비교
<ol>
<li>값 정렬 설명</li>
<li>각 알고리즘 설명 및 그래프 분석</li>
</ol>
<br>

각 알고리즘마다 정렬된 배열값, 역순으로 정렬된 배열값, 랜덤으로 정렬된 배열값을 넣어 비교해볼 것이다. 입력개수를 2^20값까지 넣으면 이클립스가 실행되지 않아 2^5 ~ 2^12까지 넣어봤다.

## 코드 구현
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

## 버블 정렬(Bublle_Sort)

<br>

## 쉘 정렬(Shell_Sort)
<br>
■ 쉘 정렬(Shell_Sort)
<br>
- 삽입 정렬을 개선한 정렬 알고리즘으로, 쉘 정렬은 일정한 gap을 기준으로 띄엄띄엄 정렬하게 된다. gap은 배열의 size를 0이 될때까지 2로 나누는 방식으로 지정했다. 
<br>

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
![image](https://user-images.githubusercontent.com/102197100/166885473-207a92c7-0ef2-4dd3-aedb-68aa970263fe.png)
<br>
- 쉘 정렬로 정렬, 역순, 랜덤 배열 값을 정렬한 결과, 입력 값이 점점 늘어날수록 위 사진과 같은 그래프가 만들어졌다.
> 역순, 랜덤, 정렬 순으로 정렬 시간이 점점 길어지는 것을 알 수 있다.

