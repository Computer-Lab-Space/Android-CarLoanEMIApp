// EMIAidlInterface.aidl
package com.computerlabspace.emiloancaluculatorserver;

interface EMIAidlInterface {
    double calculateEMI(long principalAmount, long downPayment, float interestRate, int tenure);
}