#1/bin/bash
read -p "What number would you like to find the factorial of? " f #user inputs a number

fact=1

for (( i = $f; i >= 1; i-- ));
do
	fact=$((fact * i));
done
echo $fact
