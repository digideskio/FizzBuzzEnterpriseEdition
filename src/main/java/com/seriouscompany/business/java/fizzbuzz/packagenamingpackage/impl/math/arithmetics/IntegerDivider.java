package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.math.arithmetics;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.comparators.integercomparator.IntegerForEqualityComparator;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.comparators.doublecomparator.FirstIsSmallerThanSecondDoubleComparator;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.comparators.doublecomparator.FirstIsLargerThanSecondDoubleComparator;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.converters.primitivetypesconverters.DoubleToIntConverter;
import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.converters.primitivetypesconverters.IntToDoubleConverter;

public class IntegerDivider {
	
	public static final int INTEGER_DIVIDE_ZERO_VALUE = 0;
	public static final int INTEGER_ORIGIN_ZERO_VALUE = 0;
	
	public static int divide(int nFirstInteger, int nSecondInteger){
		boolean denominatorEqualsZero =
			IntegerForEqualityComparator.areTwoIntegersEqual(nSecondInteger, INTEGER_DIVIDE_ZERO_VALUE);
		if (denominatorEqualsZero) {
			throw new ArithmeticException("An attempt was made to divide by zero.");
		}else{
			final double dbFirstNumber = IntToDoubleConverter.Convert(nFirstInteger);
			final double dbSecondNumber = IntToDoubleConverter.Convert(nSecondInteger);
			final double dbQuotient = dbFirstNumber / dbSecondNumber;
			double dbRoundedQuotient = INTEGER_ORIGIN_ZERO_VALUE;
			if(FirstIsSmallerThanSecondDoubleComparator.FirstIsSmallerThanSecond(dbQuotient, INTEGER_ORIGIN_ZERO_VALUE)){
				dbRoundedQuotient = Math.ceil(dbQuotient);
			}else if(FirstIsLargerThanSecondDoubleComparator.FirstIsLargerThanSecond(dbQuotient, INTEGER_ORIGIN_ZERO_VALUE)){
				dbRoundedQuotient = Math.floor(dbQuotient);
			}
			final int nIntegerQuotient = DoubleToIntConverter.Convert(dbRoundedQuotient);
			return nIntegerQuotient;
		}
	}
}
