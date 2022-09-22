#1/bin/bash

if [[ ${1} =~ ^[0-9]+$ ]] && [[ ${2} =~ ^[0-9]+$ ]];
then
        let "a = ${1} / ${2}";
	b=$((${1}%${2}));
        echo ${2} goes into ${1} ... $a times;
	echo With a remainder of $b
else
        echo "INVALID: There is at least one value that is not a complete number.";
fi

