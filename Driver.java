import java.io.*;
import java.util.*;

public class Driver {

public static void main(String[] args) {

double[] array = {1,2,4,5,6,6};
double[] array2 = {-6, -1, 1};

int[] exp = {3,4,5,0,2,1};
int[] exp2 = {4,7,2};

Polynomial x = new Polynomial(array, exp);
Polynomial q = new Polynomial(array2, exp2);
Polynomial p = x.add(q);

for (int i = 0; i < p.exp.length; i++) {
System.out.println(p.exp[i]);
}

System.out.println("");

for (int j = 0; j < p.exp.length; j++) {
System.out.println(p.coeff[j]);
}

System.out.println("");

double[] array3 = {1,2,4,5,6,6};
double[] array4 = {-6, -1, 1};

int[] exp3 = {3,4,5,0,2,1};
int[] exp4 = {4,7,2};

Polynomial v = new Polynomial(array3, exp3);
Polynomial b = new Polynomial(array4, exp4);
Polynomial n = v.multiply(b);

for (int i = 0; i < n.exp.length; i++) {
System.out.println(n.exp[i]);
}

System.out.println("");

for (int j = 0; j < n.exp.length; j++) {
System.out.println(n.coeff[j]);
}

System.out.println("");

File file = new File("C:\\Users\\bphun\\Downloads\\polynomialtext.txt\\");

Polynomial tester = new Polynomial(file);

for (double e: tester.coeff) {
System.out.println(e);
}

for (int r: tester.exp) {
System.out.println(r);
}

tester.saveToFile("C:\\Users\\bphun\\Downloads\\writingtest.txt");


}

}
