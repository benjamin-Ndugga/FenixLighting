# FenixLighting

### Coding Challenge
Each customer has a device that lights up their home that they can use as collateral for several loans. 
When a customer takes out a loan, this device is locked and payment of the amount equivalent to the daily rate unlocks the device for 1 day of lighting. 
The daily rate that a customer has to pay to get a day of lighting (the account daily rate)is the sum of the daily rates of all the active loans that the 
customer has for that particular day. The account daily rate on a particular day is determined by the summation of daily rates of all loans that have started by that day.whenever a customer makes a payment K.

> If K > account daily rate on that day, the account daily rate is deducted from the paid amount k, the customer gets a day of lighting and the balance is transfered to the next day. On the next day, if the amount transfered is greater than the daily rate on that day, the customer gets a day of power and the daily rate that day is deducted from the amount and the balance transfered to the 3rd day. This goes on until the amount left is less than the account daily rate that day in which case the customer does not get any days of lighting and nothing is transfered.

### Short Installation and Quick Start-up   
download project then switch into the target diretory

```sh
$cd target
```
run the `FenixLighting-1.0-jar-with-dependencies.jar` file using the command and passing arguments in order:

>R1 D1 R2 D2 R3 D3 K
Where:
R1 - daily rate1 loan1
D1 - start in days loan1
R2 - daily rate1 loan2
D2 - start in days loan2
R3 - daily rate1 loan3
D3 - start in days loan3
K - amount paid

run command herebelow and validate:

```sh
$java -jar FenixLighting-1.0-jar-with-dependencies.jar 10000 3 500 10 1500 7 11000
```

### Long Installation   
Please install git and maven build first then. 

Clone project from repo

```sh
$ git clone https://github.com/benjamin-Ndugga/FenixLighting.git
$ cd FenixLighting
```
switch into the directory
```sh
$ cd fenixlighting
```
clean and build project using maven
```sh
$mvn clean install
```
this will create a target directory with a `FenixLighting-1.0.jar`  and `FenixLighting-1.0-jar-with-dependencies.jar` files
```sh
$cd target
```
run the `FenixLighting-1.0-jar-with-dependencies.jar` file using the command and passing arguments in order:

>R1 D1 R2 D2 R3 D3 K
Where:
R1 - daily rate1 loan1
D1 - start in days loan1
R2 - daily rate1 loan2
D2 - start in days loan2
R3 - daily rate1 loan3
D3 - start in days loan3
K - amount paid

run command herebelow:

```sh
$java -jar FenixLighting-1.0-jar-with-dependencies.jar 10000 3 500 10 1500 7 11000
```
## Sample run
here is a sample run taking 
- DailyRate 1000 starts in 3 days for loan1 (R1,D1) (1000,3)
- DailyRate 500 starts in 10 days for loan2 (R2,D2) (500,10)
- DailyRate 1500 starts in 7 datys for loan3 (R3,D3) (1500,7)
- Amount paid (K) (21000)
```sh
$ java -jar FenixLighting-1.0-jar-with-dependencies.jar 1000 3 500 10 1500 7 21000
Running program with arguments:
R1=1000,D1=3,R2=500,D2=10,R3=1500D3=,7,K=21000
Amount Paid: 21000/-
Taking Customer loans in the order: [Loan{dailyRate=1000, startsInDays=3}, Loan{dailyRate=1500, startsInDays=7}, Loan{dailyRate=500, startsInDays=10}]

Computing Days of Lighting: Loan{dailyRate=1000, startsInDays=3}
Computing Loan1 at rate: 1000
Charge for loan1: 4000/-
Current account balance after loan1 : 17000/-
Days of Power: 4
Total Days of Power after loan1 : 4

Computing Days of Lighting: Loan{dailyRate=1500, startsInDays=7}
Computing Loan2 at rate: 2500
Charge for loan2: 7500/-
Current account balance after loan2: 9500/-
Days of Power: 3
Total Days of Power after loan2: 7

Computing Days of Lighting: Loan{dailyRate=500, startsInDays=10}
Computing Loan3 at rate: 3000
Charge for loan3: 9500/-
Current account balance after loan3: 500/-
Days of Power: 3
Total Days of Power after loan3: 10

Total Balance left on the account 500/-
Total Computed Days of Power: 10
```
