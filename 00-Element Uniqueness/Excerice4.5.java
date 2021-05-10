public class Excerice4.5{
	//R4.3 the number of operations executed by algorithms A and B is 40n^2 
	//and 2n^3, respectively. Determine n0 such that A is better than B for n>= n0

	// give a big-Oh characterization, in terms of n, of the running time 
	//R4.9 O(n)
	public static int example1(int[] arr){
		int n = arr.length,total= 0; //total in here is int variable 
		for(int j = 0; j <n;j++){
			total+ = arr[j];
		return total;
		}
	}

	//R4.10 example2: O(n)
	public static int example2(int[] arr){
		int n = arr.length,total = 0;
		for(int j = 0; j < n; j+=2){ // increment by 2
			total+=arr[j];
		return total;
		}
	}

	//R4.11 example3 O(n^2)
	public static int example3(int[] arr){
		int n =arr.length, total = 0;
		for(int j = 0; j < n; j++){
			for(int k =0; k <= j; k++){
				total += arr[j];
			}
		}
		return total;
	}

	//4.12 example4 O(n)
	public static int example4(int[] arr){
		int n = arr.length, prefix = 0, total = 0;
		for(int j = 0; j < n; j++){
			prefix += arr[j];
			total += prefix;
		}
	}

	//4.13 example5 O(n^3)
	public static int example5(int[] first,int[] second){
		int n = first.length, count = 0;
		for(int i = 0; i < n; i++){
			int total = 0;
			for(int j =0; j < n; j++){
				for(int k =0; k <= j; k++){
					total += first[k];
				}
			}
			if(second[i] == total) count++;
		} 
		return count;
	}

	//4.16show that if d(n) is O(f(n)) and e(n) is O(g(n))
	// then d(n) + e(n) is O(f(n) + g(n))































}