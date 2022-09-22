#1/bin/bash

if [[ ${1} =~ ^[0-9]+$ ]] && [[ ${2} =~ ^[0-9]+$ ]];
then
	let "a = ${1} + ${2}";
	echo ${1}+${2}=$a;
else
	echo "INVALID: There is at least one value that is not a complete number.";
fi

