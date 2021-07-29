/*  CSI2114 Lab 3 - lab3.java
 *  
 *  Class to check balanced brackets in math expressions  
 *
 *  Usage: java bracketsBalance <exp>
 *  
 *  by Jeff Souza
 *
 */

class bracketsBalance {

    private boolean bBalance (String exp){ 
        char[] c = exp.toCharArray();
        ArrayStack charStack = new ArrayStack();

        for(int i =0; i < c.length; i++){
            if(c[i] == '('|| c[i] == '{' || c[i] == '['){ // open bracket
                charStack.push(c[i]);
            }

            if(charStack.isEmpty()){ // the first one is closing braket
                return false;
            }



           if(c[i] == ')'|| c[i] == '}' || c[i] == ']'){ // closing bracket
               char check;
               check = (Character)charStack.pop();  //when it meet the close bracket pop out 
               char current = c[i];
               if(current == ']'){
                    if(check == '{' || check == '('){
                        return false;
                    }
               }else if(current == '}'){
                    if(check == '[' || check == '('){
                        return false;
                    }
               }else if(current == ']'){
                    if(check == '(' || check =='{'){
                        return false;
                    }
               }

            }
        }

        boolean result = charStack.isEmpty();// if it matches, then stack should be empty
        return(result);
        
    }

    public static void main(String[] args) {

        bracketsBalance b = new bracketsBalance();
        boolean result = b.bBalance(args[0]);
   
        if (result) System.out.println("The expression is balanced."); 
        else        System.out.println("The expression is NOT balanced."); 
    }
}