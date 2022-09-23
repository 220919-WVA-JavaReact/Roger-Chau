#/bin/bash
#print Fibonacchi series up to 100

a=0
b=1
echo $a

for (( i=0; i <= 100; i ));
do
	sum=$((a + b)); #adds a and b
	a=$b; #assigns the value of b to a
	b=$sum; #b becomes the sum of a and b previously (fibonacchi)
	i=$sum; #added this so the loop ends when it reaches 100
	echo $a;
done
