# Element Uniqueness 
- Reading 174 - 175
- R-4.3 R4.9 R4.10 R4.11 R4.12 R4.13 R4.16

* Algorithm 1: Element uniquenessO(n^2)
```java
	/**Returns true if there are no duplicate elements in the array.*/
		public static boolean unique1(int[] data){
			int n =data.length;
			for(int j=0; j<n-1;j++)
				for(int k =j+1;k<n; k++)
					if(data[j] == data[k])
						return false;
			return true;
		}
```

* Algorithm 2: Element uniquenessO(nlogn)
```java
		public static boolean unique2(int[] data){
			int n = data.length;
			int[] temp = Arrays.copyOf(data,n); // make copy of data
			Arrays.sort(temp);
			for(int j=0; j < n-1; j++)
				if(temp[j] == temp[j+1])
					return false;
			return true;
		}
```

