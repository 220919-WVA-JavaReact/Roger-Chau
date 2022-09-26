#1/bin/bash
read -p "What number would you like to find the factorial of? " f #user inputs a number

fact=1 #set to 1 so when the line in the loop runs, it will be reassigned to the proper number

for (( i = $f; i >= 1; i-- ));
do
	fact=$((fact * i)); #reassigns fact to the number that needs to be multiplied next
done
echo $fact
