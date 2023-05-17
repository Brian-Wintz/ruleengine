# Rule Engine
Initial exploration into building a rules engine based on object comparisons

This implementation defines how dissimilar object types are compared against each other.  For example, when comparing a GregorianCalendar instance to a String, the GregorianCalendar is first converted to a String by applying the "yyyy-mm-dd" format and then comparing the resulting String using the Comparable.compareTo method.  This compareTo method returns the following values:

* = 0 if the Strings are the same
* < 0 if the string is lexicographically (e.g. "A"<"B"<"C"...) less than the other string
* \> 0 if the string is lexicographically greater than the other string (more characters)
