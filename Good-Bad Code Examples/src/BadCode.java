public class BadCode {public static void main(String[] args) {
int bob = 10; int jerry = 0; int alex = 1;
System.out.println(jerry);
for(int c = 0; c < bob; c++){ System.out.println(alex);
int temp = jerry; jerry = alex; alex = temp + alex; }}}
