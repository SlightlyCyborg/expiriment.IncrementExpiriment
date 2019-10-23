
all: IncrementExpiriment.java
	javac IncrementExpiriment.java

run-expiriment:
	java IncrementExpiriment 10000 > result
	printf "\n" >> result
	java IncrementExpiriment 100000 >> result
	printf "\n" >> result
	java IncrementExpiriment 1000000 >> result
	printf "\n" >> result
	java IncrementExpiriment 10000000 >> result
	printf "\n" >> result
	java IncrementExpiriment 100000000 >> result
