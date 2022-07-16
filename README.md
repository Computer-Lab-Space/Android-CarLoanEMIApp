# Android Car Loan EMI Calculator

#### Clone the project

```sh
git clone https://github.com/Computer-Lab-Space/Android-CarLoanEMIApp.git
```

#### Implementation Video Links
> [Car Loan EMI Calculator - Requirement Understanding](https://youtu.be/ru4oRMScNmw)
>
> [Car Loan EMI Calculator - AIDL Overview](https://youtu.be/orIj0eo29RM)
>
> [Car Loan EMI Calculator - UI Implementation](https://youtu.be/t-cozkATUA4)
>
> [Car Loan EMI Calculator - AIDL Implementation](https://youtu.be/ztqq9Jt_hU8)
>
> [Car Loan EMI Calculator - Integration of EMI Formula](https://youtu.be/vXqmvaEFfnE)
>
> Please do Share, Like, Subscribe and support us, finally hit the bell icon.

#### Requirement
Create an AIDL service that calculates Car Loan EMI. The formula to calculate EMI is  
E = P * r * (1+r)n)/((1+r)n-1)  
where  
E = The EMI payable on the car loan amount  
P = The Car loan Principal Amount  
r = The interest rate value computed on a monthly basis  
n = The loan tenure in the form of months  
The down payment amount has to be deducted from the principal amount paid towards buying
theCar. Develop an application that makes use of this AIDL service to calculate the EMI.
Thisapplication should have four EditText to read the PrincipalAmount, Down Payment, Interest
Rate,Loan Term (in months) and a button named as “Calculate Monthly EMI”. On click of this
button,the result should be shown in a TextView. Also, calculate the EMI by varying the Loan
Term andInterest Rate values.

Note:- Please follow the below steps  
  1) Please clone the below project first
  ```sh
  https://github.com/Computer-Lab-Space/Android-EMILoanCalculatorServer/tree/develop
  ```
  2) Start Android-EMILoanCalculatorServer project in your local  
  3) Start Android-CarLoanEMIApp project  

[Car Loan EMI Calculator Applicaiton Wiremock](https://github.com/Computer-Lab-Space/Android-CarLoanEMIApp/blob/master/app/src/main/res/drawable/EMI_calculator_wiremock.png)
