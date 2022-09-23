#1/bin/bash

array=() #declaring an array
for ((a=0; a <= 6 ; a++)) #first variable 'a' is 0, while a is less than 6, increase a by one value
do
	echo ${array[@]}; #print the entire array
	array+=($a) #append the new incremented value to the array
done

