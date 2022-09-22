#1/bin/bash

#user input info into terminal

echo Hello, please provide the following information

read -p 'First name: ' fname;
read -p 'Last name: ' lname;
read -p 'Email: ' email;
read -p 'Username: ' uname;
read -p 'Password: ' pword;

#user double checks info and restarts if necessary

read -p "Is the previous information you provided correct? (Y/N): " a

if [ $a = "Y" ] || [ $a = "y" ];
then
	echo $fname,$lname,$email,$uname,$pword >> MOCK_DATA.csv; #puts inputted data into MOCK_DATA.csv
else [ $a = "N" ] || [ $a = "n" ];
	read -p "Would you like to exit? (Y/N): " b; #prompts user if they would like to stop
	if [ $b = "N" ] || [ $b = "n" ];
	then
		./$(basename $0) && exit; #restarts the script
	else [ $b = "Y" ] || [ $b = "y" ];
	fi
fi
