import java.io.*;
import java.util.*;

public class Polynomial {



double [] coeff;



int [] exp;



public Polynomial() {

coeff = new double [1];

exp = new int [1];

}



public Polynomial(double [] coeff, int [] exp) {

this.coeff = coeff;

this.exp = exp;

}

public Polynomial(File file) {
try {
BufferedReader reader = new BufferedReader(new FileReader(file));

String polynomial = reader.readLine();

polynomial = polynomial.replace("-", "+-");

if (polynomial.charAt(1) == '-') {
polynomial = polynomial.substring(1);
}


String [] split_poly = polynomial.split("\\+");

Polynomial result = new Polynomial();

for (String a: split_poly) {

if (!a.contains("x")) {
double [] temp_coeff = {Double.parseDouble(a)};
int [] temp_exp = {1};
Polynomial temp = new Polynomial(temp_coeff, temp_exp);
result = result.add(temp);
} else {
String [] split_expression = a.split("x");
double [] temp_coeff = {Double.parseDouble(split_expression[0])};
int [] temp_exp = {Integer.parseInt(split_expression[1])};
Polynomial temp = new Polynomial(temp_coeff, temp_exp);
result = result.add(temp);
}
}

double [] actual_coeff = new double [result.coeff.length - 1];

int [] actual_exp = new int [result.exp.length - 1];

for (int l = 1; l < result.coeff.length; l++) {
actual_coeff[l - 1] = result.coeff[l];
}

for (int z = 1; z < result.exp.length; z++) {
actual_exp[z - 1] = result.exp[z];
}

coeff = actual_coeff;
exp = actual_exp;

reader.close();

} catch (IOException e) {
System.out.println("Error");
e.printStackTrace();
}
}


Polynomial add(Polynomial p) {

if (((p == null) || (p.coeff.length != p.exp.length)) || (coeff.length != exp.length)) {

return null;

}

int same = 0;

for (int i = 0; i < exp.length; i++) {

for (int j = 0; j < p.exp.length; j++) {

if (p.exp[j] == exp[i]) {

same++;

}

}

}

int length = exp.length + p.exp.length - same;

double [] new_coeff = new double [length];

int [] new_exp = new int [length];

int counter = 0;

boolean found = false;

for (int j = 0; j < exp.length; j++) {
new_coeff[j] = coeff[j];
new_exp[j] = exp[j];

}

for (int k = 0; k < p.exp.length; k++) {
for (int l = 0; l < exp.length; l++) {
if (p.exp[k] == new_exp[l]) {
new_coeff[l] += p.coeff[k];
found = true;
break;
}
}

if (!found) {
new_coeff[exp.length + counter] = p.coeff[k];
new_exp[exp.length + counter] = p.exp[k];
counter++;
}

found = false;
}

Polynomial new_p = new Polynomial(new_coeff, new_exp);

return new_p;

}



double evaluate(double x) {

double val = 0;

for (int i = 0; i < coeff.length; i++) {

val += coeff[i]*exp[i];

}

return val;

}



boolean hasRoot(double x) {

return (evaluate(x) == 0);

}


Polynomial multiply(Polynomial p) {

if (((p == null) || (p.coeff.length != p.exp.length)) || (coeff.length != exp.length)){

return null;

}

Polynomial result = new Polynomial();

Polynomial temp = new Polynomial();


for (int i = 0; i < coeff.length; i++) {
for (int k = 0; k < p.coeff.length; k++) {
temp.coeff[0] = coeff[i] * p.coeff[k];
temp.exp[0] = exp[i] + p.exp[k];
result = result.add(temp);
}
}

double [] actual_coeff = new double [result.coeff.length - 1];

int [] actual_exp = new int [result.exp.length - 1];

for (int l = 1; l < result.coeff.length; l++) {
actual_coeff[l - 1] = result.coeff[l];
}

for (int z = 1; z < result.exp.length; z++) {
actual_exp[z - 1] = result.exp[z];
}

Polynomial actual_result = new Polynomial(actual_coeff, actual_exp);

return actual_result;

}



void saveToFile(String fileName) {

try {
FileWriter writer = new FileWriter(fileName);

String result = "";

for (int i = 0; i < coeff.length; i++) {
if (exp[i] == 1) {
result = result + coeff[i];
} else if (coeff[i] > 0) {
result = result + "+" + coeff[i] + "x" + exp[i];
} else {
result = result + coeff[i] + "x" + exp[i];
}
}

writer.write(result);

writer.close();

} catch (IOException e) {
System.out.println("Error");
e.printStackTrace();
}
}

}
