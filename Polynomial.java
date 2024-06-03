public class Polynomial {
	
	double [] arr;
	
	public Polynomial() {
		arr = new double [1];
	}
	
	public Polynomial(double [] user_arr) {
		arr = new double [user_arr.length];
		
		for (int i = 0; i < user_arr.length; i++) {
			arr[i] = user_arr[i];
		}
	}
	
	Polynomial add(Polynomial p) {
		
		int max = Math.max(p.arr.length, arr.length);
		
		double [] new_poly_arr = new double [max];
		
		for (int i = 0; i < max; i++) {
			if (i <= Math.min(p.arr.length, arr.length) - 1) {
				new_poly_arr[i] = p.arr[i] + arr[i];
			} else if (p.arr.length == max) {
				new_poly_arr[i] = p.arr[i];
			} else if (arr.length == max) {
				new_poly_arr[i] = arr[i];
			}
		}
		
		Polynomial new_p = new Polynomial(new_poly_arr);
		
		return new_p;
	}
	
	double evaluate(double x) {
		double val = 0;
		
		for (int i = 0; i < arr.length; i++) {
			val += arr[i]*(Math.pow(x, i));
		}
		
		return val;
	}
	
	boolean hasRoot(double x) {		
		return (evaluate(x) == 0);
	}
	
}
